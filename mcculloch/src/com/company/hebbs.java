package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class hebbs
{
    public boolean found=false;
    int epoch=0;
    int size=4;
    public float weight1=0, weight2=0, bias=0;

    public class Heb
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

        @Override
        public String toString()
        {
            return String.valueOf(input1) + " " +  String.valueOf(input2) + " " + String.valueOf(output1) ;
        }
    }

    public void callClass()
    {
        ArrayList<Heb> hebArrayList = new ArrayList<Heb>();

        for (int i = 0; i <size ; i++)
        {
            Heb heb = new Heb();
            System.out.println("enter value for "+ i + "row");
            Scanner scaner = new Scanner(System.in);
            //input x1
            System.out.println("Enter value for input x1");
            int x =scaner.nextInt();
            heb.setInput1(x);
            //input x2
            System.out.println("Enter value for input x2");
            x =scaner.nextInt();
            heb.setInput2(x);
            //output
            System.out.println("Enter value for output");
            x =scaner.nextInt();
            heb.setOutput1(x);
            hebArrayList.add(heb);
        }
        System.out.println("Table is ");
        for (int i = 0; i <size ; i++)
        {
            System.out.println(hebArrayList.get(i));
        }
        while(!found)
        {
            Boolean[] b= new Boolean[size];
            boolean condition ;
            int increment=0;

            epoch++;
            System.out.println("epoch is " + epoch);
            for (int i = 0; i < size; i++)
            {
                weight1+=hebArrayList.get(i).input1*hebArrayList.get(i).output1;
                weight2+=hebArrayList.get(i).input2*hebArrayList.get(i).output1;
                bias+=hebArrayList.get(i).output1;

            }
            for (int i = 0; i < size; i++)
            {
                if(hebArrayList.get(i).output1==-1)
                    b[i]=false;
                else
                    b[i]=true;
            }
            for (int i = 0; i <size ; i++)
            {
                if((weight1*hebArrayList.get(i).input1+ weight2*hebArrayList.get(i).input2+bias)>=0)
                {
                    condition=true;
                }
                else
                    condition=false;

                if(condition!=b[i])
                {
                    break;
                }
                else
                    increment++;
            }
            if(increment==4)
                found=true;
        }
        System.out.println("found ture so we exit ");
        System.out.println("weight1 is " + weight1 + "weight2 is " + weight2 +"bias is " + bias);
    }
}
