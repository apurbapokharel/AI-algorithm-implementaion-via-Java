package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class perceptron
{
    Random random = new Random();
    public boolean found=false;
    int epoch=0;
    int size=4;
    public double weight1=1.5, weight2=1.5, bias=-1.5,alpha=0.1;

    public class Perceptron
    {
        public int input1, input2, output1;

        public int getInput1() {
            return input1;
        }

        public void setInput1(int input1) {
            this.input1 = input1;
        }

        public int getInput2() {
            return input2;
        }

        public void setInput2(int input2) {
            this.input2 = input2;
        }

        public int getOutput1() {
            return output1;
        }

        public void setOutput1(int output1) {
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
        ArrayList<Perceptron> perceptronArrayList = new ArrayList<Perceptron>();
        System.out.println("Randomly initialized value is " + weight1 +" "+ weight2 + " " + bias);
        for (int i = 0; i <size ; i++)
        {
            Perceptron perceptron = new Perceptron();
            System.out.println("enter value for "+ i + "row");
            Scanner scaner = new Scanner(System.in);
            //input x1
            System.out.println("Enter value for input x1");
            int x =scaner.nextInt();
            perceptron.setInput1(x);
            //input x2
            System.out.println("Enter value for input x2");
            x =scaner.nextInt();
            perceptron.setInput2(x);
            //output
            System.out.println("Enter value for output");
            x =scaner.nextInt();
            perceptron.setOutput1(x);
            perceptronArrayList.add(perceptron);
        }
        System.out.println("Table is ");
        for (int i = 0; i <size ; i++)
        {
            System.out.println(perceptronArrayList.get(i));
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
                weight1+=perceptronArrayList.get(i).input1*perceptronArrayList.get(i).output1*alpha;
                weight2+=perceptronArrayList.get(i).input2*perceptronArrayList.get(i).output1*alpha;
                bias+=perceptronArrayList.get(i).output1*alpha;

            }
            for (int i = 0; i < size; i++)
            {
                if(perceptronArrayList.get(i).output1==-1)
                    b[i]=false;
                else
                    b[i]=true;

            }
            for (int i = 0; i <size ; i++)
            {
                if((weight1*perceptronArrayList.get(i).input1+ weight2*perceptronArrayList.get(i).input2+bias)>=0)
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
        System.out.println("weight1 is " + weight1 + "weight2 is " + weight2 +"bias is " + bias);
    }
}
