import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class IOController
{
    public static int[][] readArr(String inputFile)
    {
        ArrayList<String> n = new ArrayList<String>();
        try (FileReader reader = new FileReader(inputFile))
        {
            Scanner scan  = new Scanner(reader);
            while (scan.hasNextLine())
            {
                n.add(scan.nextLine());
            }
        }
        catch (IOException e)
        {
            System.err.println("Не найден файл");
            System.exit(228);
        }
        String[] f = n.get(0).split(" ");
        int[][] Arr = new int[n.size()][f.length];

        for(int i = 0; i < n.size(); i++)
        {
            String[] a = n.get(i).split(" ");
            for(int j = 0; j < a.length; j++)
            {
                Arr[i][j] = Integer.parseInt(a[j]);
            }
        }

        return Arr;
    }

    public static void writeArr(int[][] Arr, String outputFile)
    {
        try(FileWriter writer = new FileWriter(outputFile))
        {
            for(int i = 0; i < Arr.length; i++)
            {
                for(int j = 0; j < Arr[i].length; j++)
                {
                    writer.write(Arr[i][j] + " ");
                }
                writer.write('\n');
            }
        }catch (IOException e)
        {
            System.err.println("Не найден файл для записи");
            System.exit(228);
        }
    }


}
