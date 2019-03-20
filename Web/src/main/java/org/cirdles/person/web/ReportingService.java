/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

import org.cirdles.person.Person;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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

}
