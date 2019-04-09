/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

import org.cirdles.person.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author meagangould
 */
public class ReportingService {

    public ReportingService(){
    }


    public static String reverse(String text){
        String reverse_string="";
        for(int i=text.length()-1; i>=0;i--){
           reverse_string+=text.charAt(i);
        }
        return reverse_string;
    }

    public Person change_person_age(Person person){
        Person person_change = new Person(person.getName(),person.getDOB()+1);
        return person_change;
    }

    public Path generatePerson(InputStream personFileGiven){
        Path personFile= null;
        try {
            Path uploadDirectory = Files.createTempDirectory("temp");
            Path filePathForPerson = uploadDirectory.resolve("person.xml");
            personFile = Files.createFile(filePathForPerson);
            Path givenPathForPerson = uploadDirectory.resolve("givenPerson.xml");
            Files.copy(personFileGiven,givenPathForPerson);

            Person given = Person.deserializationXML(givenPathForPerson.toString());
            given.setDOB(1000);

            Person.serializationXML(given,filePathForPerson.toString());
            personFile = filePathForPerson.getParent();
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("there is an error here in the generate person method");
            try {
                Path failFile = Files.createTempFile("failFile","txt");
                try (BufferedWriter writer = Files.newBufferedWriter(failFile, StandardCharsets.UTF_8)) {
                    writer.write("It failed");
                }
                File message = failFile.toFile();
                Path messageDirectory = Files.createTempDirectory("message");
                Path messageFilePath = messageDirectory.resolve("failMessage.txt");
                Files.copy(message.toPath(),messageFilePath);
                personFile = messageFilePath.getParent();

            }
            catch(Exception e2){
                System.out.println(e2);
            }


        }
        return personFile;

    }

}
