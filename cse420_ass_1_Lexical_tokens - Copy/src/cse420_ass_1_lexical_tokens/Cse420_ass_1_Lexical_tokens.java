/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse420_ass_1_lexical_tokens;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRACU\13101223
 */
public class Cse420_ass_1_Lexical_tokens {
    static String Numerical [];
    final static String Logical_sym[] = {"<",">","==", "!=",">=","<=","&&","||"};
    final static char albhabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    final static char numbers[] = {'0','1','2', '4','5','6','7','8','9'};
    final static char Mathmetical_sym[] = {'+','-','*','/','='};
    final static String keywords [] = {"if", "while","case","switch","int","float", "double","String", "long","else", "byte", "char"};
    static List<String>  keywords_out = new ArrayList<String>();
    static List<String> identifier_out = new ArrayList<String>();
    static List<String> math_symbols_out = new ArrayList<String>();
    static List<String> logical_operators_out = new ArrayList<String>();
    static List<String> numbers_out = new ArrayList<String>();
    static List<String> other_out = new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;	      
            try {
		String sCurrentLine;

                br = new BufferedReader(new FileReader("input.txt"));
                        
		while ((sCurrentLine = br.readLine()) != null) {
                    String [] temp_points= sCurrentLine.split(" ");
                    for(int i =0; i<temp_points.length;i++){
                        //Start checking for keywords then inside that, identifiers
                        for(int j =0; j < keywords.length; j++){
                            if(temp_points[i].equals(keywords[j])){
                                //get the following identifiers and them to the list
                                
                                int ii = i;
                                Boolean x = true;
                                while(x){
                                    if(temp_points[ii].indexOf(',') >=0){
                                        //add it to identifiers after trimming the ,
                                        identifier_out.add(temp_points[ii].replace(',' , ' '));
                                    }else if (temp_points[ii].indexOf(';') >=0){
                                        //end of the identifier searching.
                                        
                                        identifier_out.add(temp_points[ii].replace(';' , ' '));
                                        x = false;
                                    }
                                    if(temp_points.length-1 > ii){
                                        ii++;
                                    }else{
                                        x = false;
                                    }
                                   
                                }
                                
                                
                                
                                //add that keyword to list
                                if(keywords_out.contains(temp_points[i])){
                                    
                                }else{
                                    keywords_out.add(temp_points[i]);
                                }
                            }
                        }
                        
                        //start checking for Mathmetical_symbols
                        for(int j =0; j < Mathmetical_sym.length; j++){
                            //System.out.println(temp_points[i]);
                            //temp_points[ii].indexOf(',') >=0
                            
                            if(temp_points[i].indexOf(Mathmetical_sym[j]) >=0){
                                if(math_symbols_out.contains(temp_points[i])){
                                    
                                }else{
                                    math_symbols_out.add(temp_points[i].replace(' ' , ' '));
                                }
                            }
                        }
                        
                        
                        //start checking for logical operators
                        for(int j =0; j < Logical_sym.length; j++){
                            
                            if(temp_points[i].indexOf(Logical_sym[j]) >=0){
                                if(logical_operators_out.contains(temp_points[i])){
                                    
                                }else{
                                    logical_operators_out.add(temp_points[i].replace(' ' , ' '));
                                }
                            }
                        }   
                        
                         //start checking for numbers
                        for(int j =0; j < numbers.length; j++){
                            //System.out.println(temp_points[i]);
                            if(temp_points[i].equals(numbers[j])){
                                //add
                                    if(numbers_out.contains(temp_points[i])){
                                    
                                }else{
                                    numbers_out.add(temp_points[i]);
                                }
                            }
                            if(temp_points[i].indexOf(',') >=0 && temp_points[i].indexOf(numbers[j]) >=0){
                                Boolean noalphabet =true;
                                for(int k =0; k <albhabet.length;k++){
                                    if(temp_points[i].indexOf(albhabet[k]) >=0){
                                        noalphabet=false;
                                    }
                                }
                                if(noalphabet){
                                    
                                    //add 
                                    String tempo = temp_points[i].replace(',' , ' ');
                                    if(numbers_out.contains(tempo)){
                                    
                                }else{
                                    numbers_out.add(tempo);
                                }
                                }
                            }
                            
                            if(temp_points[i].indexOf(';') >=0 && temp_points[i].indexOf(numbers[j]) >=0){
                                Boolean noalphabet =true;
                                for(int k =0; k <albhabet.length;k++){
                                    if(temp_points[i].indexOf(albhabet[k]) >=0){
                                        noalphabet=false;
                                    }
                                }
                                if(noalphabet){
                                    
                                    //add 
                                    String tempo = temp_points[i].replace(';' , ' ');
                                    if(numbers_out.contains(tempo)){
                                    
                                }else{
                                    numbers_out.add(tempo);
                                }
                                }
                            }
                            
                        }
                        
                        //start checking for other symbols
                        /*
                        keywords_out = new ArrayList<String>();
    static List<String> identifier_out = new ArrayList<String>();
    static List<String> math_symbols_out = new ArrayList<String>();
    static List<String> logical_operators_out = new ArrayList<String>();
    static List<String> numbers_out = new ArrayList<String>();
    static List<String> other_out = new ArrayList<String>();
                        */
                        if(keywords_out.contains(temp_points[i])){
                            
                        }else if (identifier_out.contains(temp_points[i])){
                            
                        }else if (math_symbols_out.contains(temp_points[i])){
                            
                        }else if (logical_operators_out.contains(temp_points[i])){
                            
                        }else if (numbers_out.contains(temp_points[i])){
                            
                        }else{
                            //add this to others
                            String tempo = temp_points[i];//.replace(';' , ' ');
                            //tempo = temp_points[i].replace(',' , ' ');
                            Boolean others_eligable = true;
                            
                             if(tempo.indexOf(',') >=0){
                                if(other_out.contains(",")){
                                    
                                }else{
                                    other_out.add(",");
                                }
                             }
                             if(tempo.indexOf(';') >=0){
                                if(other_out.contains(";")){
                                    
                                }else{
                                    other_out.add(";");
                                }
                             }
                             
                             tempo = temp_points[i].replace(',' , ' ');
                             tempo = temp_points[i].replace(';' , ' ');
                             
                             for(int m =0;m<albhabet.length;m++){
                                 if(tempo.indexOf(albhabet[m]) >=0){
                                        others_eligable=false;
                                 }
                             }
                             for(int m =0;m<numbers.length;m++){
                                 if(tempo.indexOf(numbers[m]) >=0){
                                        others_eligable=false;
                                 }
                             }
                             if(others_eligable){
                                 //finally add it
                               if(other_out.contains(tempo)){
                                    
                                }else{
                                    other_out.add(tempo);
                                }
                             }
                            
                        }
                    }
                    
                }
                
                
                
                //printing begains
                
                
                //printing keywords
                    System.out.print("Keywords: ");
                    for(int k =0; k <keywords_out.size();k++){
                        System.out.print(keywords_out.get(k));
                        if(k<keywords_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    
                    //printing identifiers
                    System.out.print("Identifiers: ");
                    for(int k =0; k <identifier_out.size();k++){
                        System.out.print(identifier_out.get(k));
                        if(k<identifier_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    
                     //printing math symbols
                    System.out.print("Math Operators: ");
                    for(int k =0; k <math_symbols_out.size();k++){
                        System.out.print(math_symbols_out.get(k));
                        if(k<math_symbols_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    
                    
                    
                            //printing logical symbols
                    System.out.print("Logical Operators: ");
                    for(int k =0; k <logical_operators_out.size();k++){
                        System.out.print(logical_operators_out.get(k));
                        if(k<logical_operators_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    
                     //printing Numerical Values
                    System.out.print("Numerical Values: ");
                    for(int k =0; k <numbers_out.size();k++){
                        System.out.print(numbers_out.get(k));
                        if(k<numbers_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    
                    
                    //printing other symbols
                    System.out.print("Others: ");
                    for(int k =0; k <other_out.size();k++){
                        System.out.print(other_out.get(k));
                        if(k<other_out.size()-1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
		} catch (IOException e) {
                    System.out.println("No file dude");
		}
                
    }
    
}
