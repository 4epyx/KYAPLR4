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

