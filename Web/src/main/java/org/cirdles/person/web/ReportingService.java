/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.person.web;

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

    public static void main(String[] args){

        String x = "purple";
        System.out.println(reverse(x));
    }
}
