/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse420lab2;

import java.util.Scanner;

/**
 *
 * @author erfan
 */
public class Cse420lab2 {
    static int first_run_count = 0;
    static int second_run_count = 0;
    static String first_run_inputs[];
    static String second_run_inputs[];
    static String var_table [][];
    static String results[];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner nemesis = new Scanner(System.in);
        first_run_count = Integer.valueOf(nemesis.nextLine());
        first_run_inputs = new String[first_run_count];
        
        for(int i = 0; i < first_run_count; i++){
            first_run_inputs[i] = nemesis.nextLine().replaceAll(" ", "");
        }
        
        var_table = new String[first_run_count][2];
        second_run_count = Integer.valueOf(nemesis.nextLine());
        second_run_inputs = new String[second_run_count];
        results = new String [second_run_count];
        
        for(int i = 0; i < second_run_count; i++){
            second_run_inputs[i] = nemesis.nextLine().replaceAll(" ", "");
        }
        
        for(int j=0; j <first_run_inputs.length;j++){
            String code_portions[] = first_run_inputs[j].split("=");
            var_table[j][0] = code_portions[0];
            var_table[j][1] = code_portions[1];
        }
        
        /*
        for(int j=0; j <second_run_inputs.length;j++){
           String equation = second_run_inputs[j];
           
           Boolean mul_left = true;
           while(mul_left){
               int mul_indx = equation.indexOf('X');
               if(mul_indx == -1){
                   mul_left = false;
               }else{
                   equation = do_mul(equation, mul_indx ,j);
               }
           }
           
           results[j] = equation;
        }*/
        
        //printer
        for(int z =0; z< results.length; z++){
            System.out.println(results[z]);
        }
    }
    public static String do_mul(String eq, int idx, int looper_idx){
        
        char mul_1 = eq.charAt(idx+1);
           char mul_2 = eq.charAt(idx-1);
           String mul_1_val = var_to_val(mul_1);
           String mul_2_val = var_to_val(mul_2);
           int result__ = 0;
           
           if(!mul_1_val.equals("aa")){
               int mul1_ = Integer.valueOf(mul_1_val);
                if(!mul_1_val.equals("aa")){
                    int mul2_ = Integer.valueOf(mul_2_val);
                    result__ = mul1_ * mul2_;
                }else{
                    //error
                    results[looper_idx] = "Compilation error";
                }
           }else{
              //error
              results[looper_idx] = "Compilation error";
           }
           
           return replacer(eq, idx, result__);
        
    }
    public static String replacer(String equ, int mul_indx , int result){
        //replace 
           String part1 = equ.substring(0, mul_indx-1);
           String part2 = equ.substring( mul_indx+2 , equ.length());
           String new_equ = part1+ String.valueOf(result) +part2;
           return new_equ;
    }
    public static String var_to_val(char v){
        String tobe = "aa";
        for(int k =0; k < var_table.length; k++){
            if(var_table[k][0].equals(String.valueOf(v))){
                tobe = var_table[k][1];
                break;
            }
        }
        return tobe;
    }
    
   
}
