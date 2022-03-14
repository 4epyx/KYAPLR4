package com.company;

import java.util.ArrayList;

public class Task1
{
    public static int[][] Relation(int[][] Arr)
    {
        ArrayList<int[]> ColsNeg = new ArrayList<>();
        ArrayList<int[]> ColsPos = new ArrayList<>();

        for(int i = 0; i < Arr[0].length; i++)
        {
            int Sum = 0;
            for(int j = 0; j < Arr.length; j++)
            {
                Sum += Arr[j][i];
            }
            if(Sum < 0)
            {
                int[] Col = new int[Arr.length];
                for(int j = 0; j < Arr.length; j++)
                {
                    Col[j] = Arr[j][i];
                }
                ColsNeg.add(Col);
            }
            else
            {
                int[] Col = new int[Arr.length];
                for(int j = 0; j < Arr.length; j++)
                {
                    Col[j] = Arr[j][i];
                }
                ColsPos.add(Col);
            }
        }
//        for(int i = 0, index = 0; i < Arr[0].length; i++)
//        {
//            boolean contains = false;
//            for(int j = 0; j < Cols.size(); j++)
//            {
//                if(i == Cols.get(j)[0])
//                {
//                    contains = true;
//                    break;
//                }
//            }
//            if(contains == true)
//            {
//                continue;
//            }
//            for(int l = 0; l < Arr.length; l++)
//            {
//                Arr[l][index] = Arr[l][i];
//            }
//            index++;
//        }
//
//        for(int i = Arr.length-1, c = Cols.size()-1; i >= Arr.length - Cols.size(); i--, c--)
//        {
//            for(int j = 0; j < Arr.length; j++)
//            {
//                Arr[j][i] = Cols.get(c)[j+1];
//            }
//        }
        int[][] ResArr = new int[Arr.length][Arr[0].length];
        for(int i = 0; i < ColsPos.size(); i++)
        {
            for(int j = 0; j < ColsPos.get(i).length; j++)
            {
                ResArr[j][i] = ColsPos.get(i)[j];
            }
        }
        for(int i = ColsPos.size(), ai = 0; ai < ColsNeg.size(); ai++, i++)
        {
            for(int j = 0; j < ColsNeg.get(ai).length; j++)
            {
                ResArr[j][i] = ColsNeg.get(ai)[j];
            }

        }
        return  ResArr;
    }
}

