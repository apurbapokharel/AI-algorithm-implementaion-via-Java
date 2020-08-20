package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main
{
    public static int randomnumber() //generates random number either 0 or 1
    {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static String creategnome() //return a chromosome of size 8
    {
        String string ;
        string="";
        for(int i =0; i<8;i++)
        {
            string += Integer.toString(randomnumber());
        }
        return string;
    }

    static class Individual
    {
        public String chromosome ;
        public int fitness;

        public Individual()
        {

        }
        public Individual (String chromosome)
        {
            this.chromosome=chromosome;
            this.cal_fitness();
        }

        public Individual mate(Individual parent2  ) //function to create offspring
        {
            String childstring ="";
            for(int i =0; i<8;i++)
            {
               if(i<3)
                   childstring+=this.chromosome.charAt(i);
               else if(2<i && i<7)
                   childstring+=parent2.chromosome.charAt(i);
               else
                   childstring+=this.chromosome.charAt(i);

            }
            return new Individual(childstring);
        }

        public void cal_fitness() //fitness value calculator
        {
            fitness=0;
            for(int i =0; i<8;i++)
            {
                if(chromosome.charAt(i)=='1')
                    fitness++;
            }
        }

        @Override //override method toString to print arraylist of type individual
        public String toString()
        {
            return chromosome +" fitness is " +  fitness;
        }
    }

    static class sortByFitness implements Comparator<Individual> //function that will sort chromosomes based on descending order of fitness value
    {
        public int compare(Individual i1,Individual i2)
        {
            i1.cal_fitness();
            i2.cal_fitness();
            return i2.fitness - i1.fitness;
        }
    }

    public static void main(String[] args)
    {
        int generation =1;
        int size=100;
        ArrayList<Individual> population= new ArrayList<Individual>();
        boolean found =false;

        for(int i =0;i<size;i++) //create 100 random chromosomes
        {
            String gnome = creategnome();
            population.add(new Individual(gnome));
        }
        while(! found) //program will end when an offspring generation is created where all 100 chromosomes will have a fitness function of 8
        {
            System.out.println("Generation : " + generation);
            Collections.sort(population, new sortByFitness());
            System.out.println(" after sort");
            for(int i=0;i<size;i++)
            {
                System.out.println(population.get(i));
            }
            if(population.get(size-1).fitness==8)
            {
                System.out.println("top of check for break condition");
                found = true;
                System.out.println("found is true");
                break;
            }
            ArrayList<Individual> newGeneration= new ArrayList<Individual>();
            //top 10% is selected/copied to next generation
            int s = (10*size)/100;
            for(int i = 0;i<s;i++)
                newGeneration.add(population.get(i));
            //remaining 90% offspring are generated at random through mate function
            s = (90*size)/100;
            for(int i = 0;i<s;i++)
            {
                Random random = new Random();
                int r = random.nextInt(size-1);
                Individual parent1 = population.get(r);
                r = random.nextInt((size/2) +1 );
                Individual parent2 = population.get(r);
                Individual offspring = parent1.mate(parent2);
                newGeneration.add(offspring);
            }
            population=newGeneration;
            System.out.println("offspring created");
            generation++;
        }
        System.out.println("total generation created is  : " +generation);
    }
}

