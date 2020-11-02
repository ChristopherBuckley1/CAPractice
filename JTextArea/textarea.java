package JTextArea;

import javax.swing.*;
import java.awt.*;

public class textarea {
    public static void main(String[] args) {
        int[] weights = new int[]{120,253,173,164,290};
        selectSort(weights);



        TextArea textArea = new TextArea();
        Font font = new Font("Monospaced",Font.PLAIN,11);
        textArea.setFont(font);
        String text = String.format("%12s%14s","Person","Weight\n");
        for(int i=0;i< weights.length;i++)
        {
            text += String.format("%12d%14s",i+1,weights[i]+"\n");
        }
        textArea.append(text);
        JOptionPane.showMessageDialog(null,textArea,"Data",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void selectSort(int weights[])
    {
       int smallest,temp,sub;

       for(int i=0;i< weights.length-1;i++)
       {
           smallest = weights[i];
           sub = i;

           for(int j=i+1;j< weights.length;j++)
           {
               if(smallest>weights[j])
               {
                   smallest = weights[j];
                   sub = j;
               }
           }
           temp = weights[i];
           weights[i]=weights[sub];
           weights[sub]=temp;
       }
    }
}
