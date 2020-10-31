package MinMaxAvg;
import java.util.*;

public class minmaxavg {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int count = 0, num;

        System.out.println("Please enter the number of numbers you wish to evaluate:");

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i < 5; ++i) {
            num = scan.nextInt();
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }

        double average = sum / 5.0d;

        System.out.println("Your average is: " + average);
        System.out.println("The sum is: " + sum);

        System.out.println("Your maximum number is: " + max);
        System.out.println("Your minimum number is: " + min);

    }
}
