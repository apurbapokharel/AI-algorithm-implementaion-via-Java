package com.company;

import java.util.ArrayList;
import java.util.Random;

public class genetic
{
    ArrayList<Integer> list = new ArrayList<Integer>();
    int fitness;

    public int randomnumber()
    {
        Random random = new Random();
        return random.nextInt(2);
    }

    public void initialisetarget()
    {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
    }

    public void randomgenerate()
    {
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
        list.add(randomnumber());
    }

    public int cal_fitness()
    {
        int count=0;
        for(Integer x: list)
        {
            if(x==1)
                count++;
        }
        return count;
    }

    public genetic offspring(ArrayList<Integer> i1,ArrayList <Integer> i2)
    {
        genetic g1 = new genetic();
        for(int x=0;x<8;x++)
        {
            if(x<3)
                g1.list.add(i1.get(x));
            else if(2<x && x<=6)
                g1.list.add(i2.get(x));
            else
                g1.list.add(i1.get(x));
        }
        return g1;
    }
}
