package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("enter 1 for Mcculloh and pit" +
                " enter 2 for hebbs" +
                "enter 3 for perceptron" +
                "enter 4 for adaline" +
                "enter 5 for back propogation");
        Scanner scanner= new Scanner(System.in);
        int x = scanner.nextInt();

        switch (x)
        {
            case 1:
                System.out.println("McCulloch and Pit nerural network");
                mcandpit mcandpit = new mcandpit();
                mcandpit.callClass();
                break;

            case 2:
                System.out.println("Hebbs nerural network");
                hebbs hebbs = new hebbs();
                hebbs.callClass();
                break;

            case 3:
                System.out.println("Perceptron nerural network");
                perceptron perceptron = new perceptron();
                perceptron.callClass();
                break;

            case 4:
                System.out.println("Adline nerural network");
                adaline adaline = new adaline();
                adaline.callClass();
                break;

            case 5:
                System.out.println("Backward Propogation nerural network");
                backwardprop backwardprop = new backwardprop();
                backwardprop.callClass();
                break;

            default:
                break;
        }
    }
}
