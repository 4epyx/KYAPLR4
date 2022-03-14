import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame{
    private JTable input;
    private JTextArea output;
    private JCheckBox fileInput;
    private JCheckBox fileOutput;
    private JTextField iFile;
    private JTextField oFile;
    private JButton start1;
    private JPanel panel;
    private JCheckBox tableToFile;
    private JTextField tablePath;
    private JLabel toFole;
    private JButton start2;

    public Main()
    {
        setTitle("Lr 4");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(512, 512);
        setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        for(int i = 0; i < 10; i++)
        {
            model.addColumn(" ");
        }

        for(int i = 0; i < 10; i++)
        {
            model.addRow(new Object[] {"", "", "", "", "", "", "", "", "", ""});
        }

        input.setModel(model);
        input.setVisible(true);
        input.setGridColor(Color.BLUE);

        start1.addActionListener(new t4Listener());
        start2.addActionListener(new t4t2Listener());
    }

    public static void main(String[] args)
    {
        Main app = new Main();
        app.setVisible(true);
    }

    private void createUIComponents() {
    }

    public static void arrToTable(int[][] Arr, JTable input)
    {
        for(int i = 0; i < Arr.length && i < input.getModel().getRowCount(); i++)
        {
            for(int j = 0; j < Arr[i].length && i < input.getModel().getColumnCount(); j++)
            {
                input.getModel().setValueAt(Arr[i][j], i, j);
            }
        }
    }

    public static void arrToArea(int[][] arr, JTextArea output)
    {
            for(int i = 0; i < arr.length; i++)
            {
                String res = "";
                for(int j = 0; j < arr[i].length; j++)
                {
                    res += arr[i][j] + " ";
                }
                output.append(res + "\n");
            }
    }

    public static ArrayList<ArrayList<Integer>> getArr(JTable input)
    {
            ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < input.getModel().getRowCount(); i++)
            {
                ArrayList<Integer> rows = new ArrayList<>();
                for(int j = 0; j < input.getModel().getColumnCount(); j++)
                {
                    Object value = input.getModel().getValueAt(i, j);

                    if(value.toString() != "")
                    {
                        try {
                            rows.add(Integer.parseInt(value.toString()));
                        } catch (NumberFormatException e)
                        {

                        }
                    }
                }
                if(rows.size()!= 0) {
                    arr.add(rows);
                }
            }
            return arr;

    }

    class t4Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            int[][] res;
            output.setText("");
            if(fileInput.isSelected())
            {
                int[][] arr = IOController.readArr(iFile.getText());
                arrToTable(arr, input);
                res = Task1.Relation(arr);
            }
            else
            {
                ArrayList<ArrayList<Integer>> a = getArr(input);
                int[][] Arr = new int[a.size()][a.get(0).size()];

                for(int i = 0; i < Arr.length; i++)
                {
                    for(int j = 0; j < Arr[i].length; j++)
                    {
                        Arr[i][j] = a.get(i).get(j);
                    }
                }
                res = Task1.Relation(Arr);
                if(tableToFile.isSelected())
                {
                    IOController.writeArr(Arr, tablePath.getText());
                    output.append("Данные из таблицы записаны в файл " + tablePath.getText() + "\n");
                }
            }
            if(!fileOutput.isSelected())
            {
                arrToArea(res, output);
            }
            else
            {
                IOController.writeArr(res, oFile.getText());
                output.setText("Результат записан в файл " + oFile.getText());
            }
        }

    }
    class t4t2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            int[][] res;
            output.setText("");
            if(fileInput.isSelected())
            {
                int[][] arr = IOController.readArr(iFile.getText());
                arrToTable(arr, input);
                res = Task2.Relation(arr);
            }
            else
            {
                ArrayList<ArrayList<Integer>> a = getArr(input);
                int[][] Arr = new int[a.size()][a.get(0).size()];

                for(int i = 0; i < Arr.length; i++)
                {
                    for(int j = 0; j < Arr[i].length; j++)
                    {
                        Arr[i][j] = a.get(i).get(j);
                    }
                }
                res = Task2.Relation(Arr);
                if(tableToFile.isSelected())
                {
                    IOController.writeArr(Arr, tablePath.getText());
                    output.append("Данные из таблицы записаны в файл " + tablePath.getText() + "\n");
                }
            }
            if(!fileOutput.isSelected())
            {
                arrToArea(res, output);
            }
            else
            {
                IOController.writeArr(res, oFile.getText());
                output.setText("Результат записан в файл " + oFile.getText());
            }
        }
        }
    }
