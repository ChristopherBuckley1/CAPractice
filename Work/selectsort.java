package Work;

import javax.swing.*;
import java.util.Arrays;

import static SelectSort.selectionsort.populateArray;

public class selectsort {
    public static void main(String[] args) {
        double weights[] = new double [10];

        populateArray(weights);

        JOptionPane.showMessageDialog(null,"Unsorted Array is: \n"+ Arrays.toString(weights));

        selectionSort(weights);

        JOptionPane.showMessageDialog(null,"Sorted Array is: \n"+Arrays.toString(weights));
    }

    public static void populateArray(double weights[])
    {
        for(int i = 0; i < weights.length;i++)
            weights[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter weight for person " + (i+1)));
    }

   public static void selectionSort(double weights[])
   {
       double smallest,temp;
       int sub;

       for(int i = 0;i<weights.length-1;i++)
       {
           smallest = weights[i];
           sub = i;

           for(int j=i+1;j<weights.length;j++)
               if(weights[j]<smallest)
               {
                   smallest = weights[j];
                   sub = j;
               }
           temp = weights[i];
            weights[i] = weights[sub];
            weights[sub] = temp;
       }
   }

}
