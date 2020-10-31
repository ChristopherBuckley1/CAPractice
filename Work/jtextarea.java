package Work;

import javax.swing.*;
import java.awt.*;

public class jtextarea {
    public static void main(String[] args) {

        String Array[] = new String[5];
        Array[0] = "Jack";
        Array[1] = "John";
        Array[2] = "Billy";



        JTextArea textArea = new JTextArea();

       Font font = new Font("Blablabla",Font.PLAIN,12);

       textArea.setFont(font);



       String text = "";

       for(int i = 0;i< Array.length;i++)
       {
           if(Array[i]!=null)
               text += String.format("%-25s",Array[i]);
       }
       textArea.append(text);
       JOptionPane.showMessageDialog( null, textArea, "Names", JOptionPane.INFORMATION_MESSAGE);
    }
}
