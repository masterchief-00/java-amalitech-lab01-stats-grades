import java.util.Scanner;

public class Main {
    public static void graphProcessor(int[] stats) {
        // find labels for the graphs -> max value for y-axis,values for x-axis
        int y_max = 0;
        for (int stat : stats) {
            if (stat > y_max) y_max = stat;
        }

        // plot
        for (int i = y_max; i > 0; i--) {
            System.out.print("\n" + i + " > ");
            for (int value : stats) {
                System.out.print(value >= i ? " #######  " : "          ");
            }
        }

        System.out.println("\n  +-----------+--------+---------+---------+--------+");
        System.out.println("  I   0-20    I  21-40 +  41-60  I  61-80  I 81-100 I");

    }

    public static void scoreProcessor(int N) {

        // read the scores into the array
        int[] scores = new int[N];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            System.out.println("Enter score (range 0->100) " + i + ": ");
            int temp = scanner.nextInt();
            if (temp >= 0 && temp <= 100) scores[i] = temp;
            else {
                System.out.println("Invalid score!");
                break;
            }
        }

        // get the max, min and avg score
        int max = 0, min = scores[0], sum = 0;
        float avg;
        int[] stats = {0, 0, 0, 0, 0};

        for (int score : scores) {
            if (score > max) max = score;
            if (score < min) min = score;

            // classify the scores according to the ranges
            if (score >= 0 && score <= 20) stats[0]++;
            else if (score >= 21 && score <= 40) stats[1]++;
            else if (score >= 41 && score <= 60) stats[2]++;
            else if (score >= 61 && score <= 80) stats[3]++;
            else if (score >= 81 && score <= 100) stats[4]++;

            sum += score;
        }
        avg = (float) (sum / N);

        System.out.println("Values:");
        System.out.println("\nThe minimum grade is " + min);
        System.out.println("The maximum grade is " + max);
        System.out.println("The average grade is " + avg);

        // create graph
        graphProcessor(stats);
    }

    public static void main(String[] args) {
        int num_scores;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Specify the number of scores you need to enter: ");
        num_scores = scanner.nextInt();

        if (num_scores > 1) scoreProcessor(num_scores);

    }
}