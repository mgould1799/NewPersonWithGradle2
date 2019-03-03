/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.cirdles.person.Person;

import java.beans.XMLDecoder;
import java.io.*;

/**
 *
 * @author meagangould
 */
public class PersonTest {        
    static Person bloop=null;


    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    bloop = new Person("Meagan",5);    
    
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of serializationBinary method, of class Person.
     */
    @Test
    public void testSerializationBinary() {
        System.out.println("serializationBinary");
        Person person = new Person("Meagan",55);
        String fileName = "binary.ser";
        Person.serializationBinary(person, fileName);
        // TODO review the generated test code and remove the default call to fail.

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            Person testPerson = (Person) in.readObject();
            in.close();
            assertEquals(person.equals(testPerson),true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Test of deserializationBinary method, of class Person.
     */
    @Test
    public void testDeserializationBinary() {
        System.out.println("deserializationBinary");
        String fileName = "binary.ser";
        Person expResult = new Person("Meagan",55);
        Person result = Person.deserializationBinary(fileName);
        assertEquals(expResult.equals(result),true);

    }

    /**
     * Test of serializationCSV method, of class Person.
     */
    @Test
    public void testSerializationCSV() {
        System.out.println("serializationCSV");
        Person person = new Person("Meagan",55);
        String fileName = "csv.csv";
        Person.serializationCSV(person, fileName);

        Person test=null;
        BufferedReader fileReader = null;


        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            //read CSV file header to skip it
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line
                String[] token = line.split(",");
                if (token.length > 0) {
                    //create a new person object
                    //token 0 and 1 are the name and DOB
                    test = new Person(token[0], Long.parseLong(token[1]));
                }

            }
        } catch (Exception e) {
            System.out.println("Error while reading csv");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("error while closing file reader");
            }
        }

        assertEquals(test.equals(person),true);
    }

    /**
     * Test of deserializationCSV method, of class Person.
     */
    @Test
    public void testDeserializationCSV() {
        System.out.println("deserializationCSV");
        String fileName = "csv.csv";
        Person expResult = new Person("Meagan",55);
        Person result = Person.deserializationCSV(fileName);
        assertEquals(result.equals(expResult),true);

    }

    /**
     * Test of serializationXML method, of class Person.
     */
    @Test
    public void testSerializationXML() {
        System.out.println("serializationXML");
        Person person = new Person("Meagan",55);
        String fileName = "xml.xml";
        Person.serializationXML(person, fileName);
        XMLDecoder decoder = null;
        FileInputStream input = null;
        try {
            input = new FileInputStream(fileName);
            decoder = new XMLDecoder(input);
        } catch (Exception e) {
            System.out.println(e);
        }
        Person testPerson = (Person) decoder.readObject();
        decoder.close();

        assertEquals( person.equals(testPerson),true);
    }

    /**
     * Test of deserializationXML method, of class Person.
     */
    @Test
    public void testDeserializationXML() {
        System.out.println("deserializationXML");
        String fileName = "xml.xml";
        Person expResult = new Person("Meagan",55);;
        Person result = Person.deserializationXML(fileName);
        assertEquals(result.equals(expResult),true);

    }
    
    @Test
    public void testDeserializationXStream(){
        String fileName="xstream.xml";
        Person expResult= new Person("Meagan",55);
        Person.serializationXStream(expResult, fileName);
        Person result= Person.deserializationXStream(fileName);
        assertEquals(result.equals(expResult),true);
    }
    
    
}
