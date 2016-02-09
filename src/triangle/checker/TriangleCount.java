/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle.checker;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tomascik
 */
public class TriangleCount {
    
       Scanner user_input = new Scanner( System.in );
       float first_side,second_side,third_side;
   
    
    public TriangleCount(){
        
    }

    
    private boolean isTheTriangleReal(){
          
        float sum1,sum2,sum3;
       
         sum1 = first_side + second_side;
         sum2 = second_side + third_side;
         sum3 = first_side + third_side;
         
        return sum1 > third_side && sum2 > first_side && sum3 > second_side;
         
}
    private void getValues() {

        if (first_side == second_side && first_side == third_side) {
            System.out.print("Your triangle is equilateral triangle\n");
        } else if (first_side == second_side || first_side == third_side || second_side == third_side) {
            System.out.print("Your triangle is isosceles triangle\n");
        } 
        else if (first_side != second_side && first_side != third_side && second_side != third_side) {
            System.out.print("Your triangle is scalene triangle\n");
        }

    }
  
    public void run(){ 

        ArrayList<Float> side = new ArrayList<>();
        
         for (int i=1; i<4; i++){
            boolean inputCheck = true;
            
            while (inputCheck){
                System.out.print("Enter your number "+i+" value: ");
                try{
                    side.add(user_input.nextFloat());
                }
                catch (InputMismatchException e) 
                { 
                    System.out.println("Integers only, please.");      
                } 
                
                if (side.get(i-1) <= 0 ){
                    System.out.println("ERROR INPUT (You put 0 or negative number)");
                    side.remove(i-1);
                }
                else {        
                    System.out.print("Value number "+i+" : "+side.get(i-1)+"\n");
                    inputCheck = false; 
                }
            }
       
        }
         
        // TODO: better way ! 

        first_side = side.get(0); 
        second_side = side.get(1); 
        third_side = side.get(2); 
         
         
        if (isTheTriangleReal()) getValues();
        else System.out.print("Your triangle is not real\n");
    }
    
}

//TODO: ArrayList<Float> side = new ArrayList<>();
// create own ErrorHandler
// is the Exception handles properly ?  - should the prog. stop ? 

//NOTE:
//methods that are for internal use only should be private
//triangle sides can be float
//if exception is not caught is trianglereal will show some bullshit values
// should be && NOT ||
