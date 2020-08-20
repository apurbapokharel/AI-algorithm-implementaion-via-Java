package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class backwardprop 
{
    public boolean found = false;
    int epoch = 0;
    int size = 4;
    public double weight13 = .15, weight14 = .25, weight23 = .2, weight24 = .3, weight35 = .35, weight45 = .4, bias3 = .1, bias4 = .35, bias5 = .45, alpha = 0.1;

    public class BackwardProp 
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
            return String.valueOf(input1) + " " + String.valueOf(input2) + " " + String.valueOf(output1);
        }
    }

    public void callClass() 
    {
        ArrayList<BackwardProp> backwardPropArrayList = new ArrayList<BackwardProp>();
        System.out.println("Randomly initialized value is " + weight13 + " " + weight14 + " " + bias3 + weight23 + " " + weight24 + " " + bias4 + weight35 + " " + weight45 + " " + bias5);
        for (int i = 0; i < size; i++) {
            BackwardProp backwardProp = new BackwardProp();
            System.out.println("enter value for " + i + "row");
            Scanner scaner = new Scanner(System.in);
            //input x1
            System.out.println("Enter value for input x1");
            int x = scaner.nextInt();
            backwardProp.setInput1(x);
            //input x2
            System.out.println("Enter value for input x2");
            x = scaner.nextInt();
            backwardProp.setInput2(x);
            //output
            System.out.println("Enter value for output");
            x = scaner.nextInt();
            backwardProp.setOutput1(x);
            backwardPropArrayList.add(backwardProp);
        }
        System.out.println("Table is ");
        for (int i = 0; i < size; i++) 
        {
            System.out.println(backwardPropArrayList.get(i));
        }
        while (!found) 
        {
            Boolean[] b = new Boolean[size];
            boolean condition;
            int increment = 0;
            double truthValue=0.7; //output must be > than 0.7 to be considered true
            double input3, input4, input5, output3, output4, output5, error3, error4, error5;
            epoch++;
            System.out.println("epoch is " + epoch);

            for (int i = 0; i < size; i++) 
            {
                if (backwardPropArrayList.get(i).output1 == 0)
                    b[i] = false;
                else
                    b[i] = true;
            }
            for (int i = 0; i < size; i++)
            {
                input3 = weight13 * backwardPropArrayList.get(i).input1 + weight23 * backwardPropArrayList.get(i).input2 + bias3;
                output3 = 1 / (1 + Math.exp(-input3));
                input4 = weight14 * backwardPropArrayList.get(i).input1 + weight24 * backwardPropArrayList.get(i).input2 + bias4;
                output4 = 1 / (1 + Math.exp(-input4));
                input5 = weight35 * output3 + weight45 * output4 + bias5;
                output5 = 1 / (1 + Math.exp(-input5));

                //considered value can satisfy the NN so check condition is necessary
                if (output5 > truthValue) 
                {
                    condition = true;
                } else 
                {
                    condition = false;
                }
                if (condition == b[i]) 
                {
                } 
                else {
                    //update bias and weight value
                    error5 = output5 * (1 - output5) * (backwardPropArrayList.get(i).output1 - output5);
                    error3 = output3 * (1 - output3) * error5 * weight35;
                    error4 = output4 * (1 - output4) * error5 * weight45;

                    double delA13 = alpha * error3 * 1;
                    weight13 += delA13;
                    double delB3 = alpha * error3;
                    bias3 += delB3;

                    double delA23 = alpha * error3 * 1;
                    weight23 += delA13;

                    double delA14 = alpha * error4 * 1;
                    weight14 += delA14;
                    double delB4 = alpha * error4;
                    bias4 += delB4;

                    double delA24 = alpha * error4 * 1;
                    weight24 += delA24;

                    double delA35 = alpha * error5 * output3;
                    weight35 += delA35;

                    double delA45 = alpha * error5 * output4;
                    weight45 += delA45;

                    double delB5 = alpha * error5;
                    bias4 += delB5;
                }
            }
            //after the weight and bias value have been calculated the output is calculated with these values and result compared to TRUTHVALUE
            for (int i = 0; i < size; i++)
            {
                input3 = weight13 * backwardPropArrayList.get(i).input1 + weight23 * backwardPropArrayList.get(i).input2 + bias3;
                output3 = 1 / (1 + Math.exp(-input3));
                input4 = weight14 * backwardPropArrayList.get(i).input1 + weight24 * backwardPropArrayList.get(i).input2 + bias4;
                output4 = 1 / (1 + Math.exp(-input4));
                input5 = weight35 * output3 + weight45 * output4 + bias5;
                output5 = 1 / (1 + Math.exp(-input5));

                if (output5 > truthValue) 
                {
                    condition = true;
                } else 
                {
                    condition = false;
                }
                if (condition != b[i]) 
                {
                    break;
                } 
                else
                    increment++;
            }
            if (increment == 4)
                found = true;
        }
        System.out.println("found ture so we out ");
        System.out.println("weight13 is " + weight13 + "weight23 is " + weight23 + "weight14 is " + weight14 + "weight24 is " + weight24 + "weight35 is " + weight35 + "weight45 is " + weight45 + "bias3 " + bias3 + "bias4 " + bias4 + "bias5 " + bias5);
    }
}

