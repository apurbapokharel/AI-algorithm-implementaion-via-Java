package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mcandpit
{
    public boolean found=false; //when found is true our neural network fires.
    int iteration=0; //interation check how many time the output prouduced by NN matches with the output of the truth table. All 4 results should be identical for found to be TRUE
    int size=4;
    public float weight1, weight2, trigger;

    public class McCulloh
    {
        public int input1, input2, output1;

        public int getInput1() 
        {
            return input1;
        }

        public void setInput1(int input1) 
        {
            this.input1 = input1;
        }

        public int getInput2() 
        {
            return input2;
        }

        public void setInput2(int input2) 
        {
            this.input2 = input2;
        }

        public int getOutput1() 
        {
            return output1;
        }

        public void setOutput1(int output1) 
        {
            this.output1 = output1;
        }

        @Override //override to display the value of arraylist duting printing arraylist
        public String toString()
        {
            return String.valueOf(input1) + " " +  String.valueOf(input2) + " " + String.valueOf(output1) ;
        }
    }
    public void callClass()
    {
        ArrayList<McCulloh> McCullohArrayList = new ArrayList<McCulloh>();
        for (int i = 0; i <size ; i++)
        {
            McCulloh mcCulloh = new McCulloh();
            System.out.println("enter value for "+ i + "row");
            Scanner scaner = new Scanner(System.in);
            //input x1
            System.out.println("Enter value for input x1");
            int x =scaner.nextInt();
            mcCulloh.setInput1(x);
            //input x2
            System.out.println("Enter value for input x2");
            x =scaner.nextInt();
            mcCulloh.setInput2(x);
            //output
            System.out.println("Enter value for output");
            x =scaner.nextInt();
            mcCulloh.setOutput1(x);
            McCullohArrayList.add(mcCulloh);
        }
        System.out.println("Table is ");
        for (int i = 0; i <size ; i++)
        {
            System.out.println(McCullohArrayList.get(i));
        }
        while(!found)
        {
            Boolean[] b= new Boolean[size]; //this array stores the output of the truth table entered by user.
            boolean condition ;
            int increment=0;

            iteration++;
            System.out.println("iteration is " + iteration);
            Random random = new Random();
            weight1=random.nextFloat();
            System.out.println("weight 1 random is "+ weight1);
            weight2=random.nextFloat();
            System.out.println("weight 2 random is "+ weight2);
            trigger=random.nextFloat();
            System.out.println("trigger random is "+ trigger);

            for (int i = 0; i < size; i++)
            {
                if(McCullohArrayList.get(i).output1==0)
                    b[i]=false;
                else
                    b[i]=true;

            }
            for (int i = 0; i <size ; i++)
            {
                   if((weight1*McCullohArrayList.get(i).input1+ weight2*McCullohArrayList.get(i).input2)>=trigger)
                   {
                        condition=true;
                   }
                   else
                       condition=false;

                   if(condition!=b[i])
                   {
                       break;
                   }else
                       increment++;
            }
            if(increment==4)
                found=true;
        }
        System.out.println("found ture so we exit ");
        System.out.println("weight1 is " + weight1 + "weight2 is " + weight2 +"trigger is " + trigger);
    }
}
