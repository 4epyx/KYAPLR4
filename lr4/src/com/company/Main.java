package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static InputArgs parceCmdArgs(String[] args)
    {
        return new InputArgs(args[0], args[1]);
    }


    public static void main(String[] args)
    {
        InputArgs ia;
        if(args.length == 2)
        {
            ia = parceCmdArgs(args);

            int[][] test = IOController.readArr(ia);

            System.out.print("Задание (1 или 2):");
            Scanner scan = new Scanner(System.in);
            int task = scan.nextInt();

            if(task == 1) {
                int[][] test2 = Task1.Relation(test);
                IOController.writeArr(test2, ia);
                System.out.println("Результат записан в файл " + ia.outputFile);
            }
            else if(task == 2)
            {
                int[][] t2 = Task2.Relation(test);
                IOController.writeArr(t2, ia);
                System.out.println("Результат записан в файл " + ia.outputFile);
            }
        }
        else
        {
            System.err.println("Нет необходимых параметров");
            System.exit(228);
        }
    }

}
