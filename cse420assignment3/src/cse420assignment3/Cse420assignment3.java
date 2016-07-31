/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse420assignment3;

import java.util.Scanner;

/**
 *
 * @author 13101223
 */
public class Cse420assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("cse 420 lab 3");
        Scanner nemesis= new Scanner(System.in);
        while(true){
            System.out.println("PLease provide an input:");
            String input = nemesis.nextLine();
        checker(input);
        }
        
    }
    
    
    public static void checker(String ulala){
        zeroOrMore(ulala);
        oneOrMore(ulala);
        onceOrNotAtAll(ulala);
        charClasses(ulala);
        negCharClass(ulala);
        exactlyNTimes(ulala);
    }
    
    
    public static void zeroOrMore(String str) {
        boolean a_checker = false;
        boolean temp_b = false;
        boolean temp_c = false;
        boolean de_at_end_checker = false;
        
        try{
        char[] temp_char = str.toCharArray();
        
        
        
        if (temp_char[0] == 'a') {
            a_checker = true;
        } else {
            a_checker = false;
        }
        
        if (temp_char[temp_char.length - 1] == 'e') {
            if (temp_char[temp_char.length - 2] == 'd') {
                de_at_end_checker = true;
            } else {
                de_at_end_checker = false;
            }
        }

        
        int b_counter=0;
        int c_counter=0;
        
        
        for (int i = 1; i < str.length() - 2;) {
            if (temp_char[i] == 'b') {
                temp_b = true;
                b_counter++;
            } else {
                temp_b = false;
                break;
            }
            i = i + 2;
        }
        for (int i = 2; i < str.length() - 2;) {
            if (temp_char[i] == 'c') {
                temp_c = true;
                c_counter++;
            } else {
                temp_c = false;
                break;
            }
            i = i + 2;
        }
        if ((temp_b && temp_c && a_checker && de_at_end_checker && (b_counter==c_counter)) 
                || ((str.length() == 3) && a_checker && de_at_end_checker)) {
            System.out.println("RE: a(bc)*de accepts ->" + str);
        } else {
            System.out.println("RE: a(bc)*de rejects ->" + str);
        }
        } catch (Exception e) {
            System.out.println("RE: a(bc)?de rejects ->" + str);
        }

    }
    public static void oneOrMore(String str) {
        boolean a_checker = false;
        boolean temp_b = false;
        boolean temp_c = false;
        boolean de_at_end_checker = false;
        
       
        try{
        char[] temp_char = str.toCharArray();
        if (temp_char[0] == 'a') {
            a_checker = true;
        } else {
            a_checker = false;
        }
        
        
        
       
        if (temp_char[temp_char.length-1] == 'e') {
            if (temp_char[temp_char.length - 2] == 'd') {
                de_at_end_checker = true;
            } else {
                de_at_end_checker = false;
            }
        }

        
        int b_counter=0;
        int c_counter=0;
        
        
        for (int i = 1; i < str.length() - 2;) {
            if (temp_char[i] == 'b') {
                temp_b = true;
                b_counter++;
            } else {
                temp_b = false;
                break;
            }
            i = i + 2;
        }
        for (int i = 2; i < str.length() - 2;) {
            if (temp_char[i] == 'c') {
                temp_c = true;
                c_counter++;
            } else {
                temp_c = false;
                break;
            }
            i = i + 2;
        }
        
        
        if ((temp_b && temp_c && a_checker && de_at_end_checker && b_counter==c_counter && (str.length() > 3))) {
            System.out.println("RE: a(bc)+de accepts ->" + str);
        } else {
            System.out.println("RE: a(bc)+de rejects ->" + str);
        }
    } catch (Exception e) {
            System.out.println("RE: a(bc)?de rejects ->" + str);
}
    }
    public static void onceOrNotAtAll(String str) {
        boolean a_checker = false;
        boolean temp_b = false;
        boolean temp_c = false;
        boolean de_at_end = false;
     
        
        try {
            char[] temp_char = str.toCharArray();
            if (temp_char[0] == 'a') {
                a_checker = true;
            } else {
                a_checker = false;
            }
            //checking for de at the end
           
            if (temp_char[temp_char.length-1] == 'e') {
                if (temp_char[temp_char.length - 2] == 'd') {
                    de_at_end = true;
                } else {
                    de_at_end = false;
                }
            }

            //checking for (bc)*
            if (temp_char[1] == 'b') {
                temp_b = true;
            }
            if (temp_char[2] == 'c') {
                temp_c = true;
            }

            if (((str.length() <= 5) && temp_b && temp_c && a_checker && de_at_end ) || (a_checker && de_at_end && (str.length() <= 3))) {
                System.out.println("RE: a(bc)?de accepts ->" + str);
        } else {
            System.out.println("RE: a(bc)?de rejects ->" + str);
            }
            
            } catch (Exception e) {
            System.out.println("RE: a(bc)?de rejects ->" + str);
        }
        
    }
    public static void charClasses(String str ) {
        boolean validator = false;
        
        int ascii_val;
        
        //checking for a at the beginning
        char[] temp_char = str.toCharArray();
        
        
        int[] temp = new int[temp_char.length];
        
        
        for (int i = 0; i < temp_char.length; i++) {
            ascii_val = (int) temp_char[i];
            temp[i] = ascii_val;
        }
        
        for (int i = 0; i < temp.length; i++) {
            if ((temp[i] >= 97) && (temp[i] <= 109)) {
                validator = true;

            } else {
                validator = false;
                break;
            }
        }

        if (validator == true) {
            System.out.println("RE: [a-m]* accepts ->" + str);
        } else {
            System.out.println("RE: [a-m]* rejects ->" + str);
        }

    }
    public static void negCharClass(String str) {
          
        boolean validator = true;
        
        int ascii_val;
        
        char[] temp_char = str.toCharArray();
        
        int[] temp = new int[temp_char.length];
        
        for (int i = 0; i < temp_char.length; i++) {
            
            ascii_val = (int) temp_char[i];
            temp[i] = ascii_val;
            
        }
        
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 97 || temp[i] == 101 || temp[i] == 105 || temp[i] == 111 || temp[i] == 117) {
                validator = false;
            }
        }
        if (validator) {
            System.out.println("RE: [^aeiou] accepts ->" + str);
        } else {
            System.out.println("RE: [^aeiou] rejects ->" + str);
        }
    }
    public static void exactlyNTimes(String str) {
        boolean validator = true;
        int ascii;
        
        
        char[] temp_char = str.toCharArray();
        int[] temp = new int[temp_char.length];
        
        for (int i = 0; i < temp_char.length; i++) {
            ascii = (int) temp_char[i];
            temp[i] = ascii;
        }
        
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]==97 || temp[i]==101 || temp[i]==105 || temp[i]==111 || temp[i]==117){
            validator=false;
            }
        }
        if(validator && str.length()==6){
            System.out.println("RE: [^aeiou]{6} accepts ->" + str);
        } else {
            System.out.println("RE: [^aeiou]{6} rejects ->" + str);
        }
    }
}
