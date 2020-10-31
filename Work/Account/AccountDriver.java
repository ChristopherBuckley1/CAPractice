package Work.Account;

import javax.swing.*;
import java.awt.*;

public class AccountDriver {
    public static void main(String[] args) {
        String text = "";
        Account a1 = new Account("Reptoid", "Password", 0001);
        Account a2 = new Account("Test","Test",0002);
        Account a3 = new Account("Test","Test",0003);
        Account a4 = new Account("Test","Test",0004);
        Account a5 = new Account("Test","Test",0005);


        URL[] URLStore = new URL[5];
        URL u1 = new URL("www.reddit.com/u/0001", "Normal", a1);
        URL u2 = new URL("www.reddit.com/u/0002", "Normal", a2);
        URL u3 = new URL("www.reddit.com/u/0003", "Normal", a3);
        URL u4 = new URL("www.reddit.com/u/0004", "Normal", a4);
        URL u5 = new URL("www.reddit.com/u/0005", "Moderator", a5);
        URLStore[0] = u1;
        URLStore[1] = u2;
        URLStore[2] = u3;
        URLStore[3] = u4;
        URLStore[4] = u5;




        JTextArea textArea = new JTextArea();

        Font font = new Font("Monospaced", Font.PLAIN, 12);

        textArea.setFont(font);

        textArea.append(text);






        //make u0003 moderator

        int accountIndex = -1;

        for(int i=0;i< URLStore.length;i++)
        {
            if(URLStore[i]!=null)
            {
                if (URLStore[i].getAccount().getUsername().equals("Reptoid")) {

                    accountIndex = i;
                    URLStore[accountIndex].setType("Moderator");
                    System.out.println("\nReptoid Found and changed!\n");
                    break;
                } else
                    System.out.println("\n\nReptoid Not found!");
            }else break;
        }
        text+= "\n\n\n";

        System.out.println("Printing the account details again...");

        for (int i = 0; i < URLStore.length; i++) {
            if (URLStore[i] != null)
                text += String.format("%-25s", URLStore[i].toString());
            else
                break;
        }

        System.out.println(text);

    }
}
