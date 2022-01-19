import java.util.Scanner;

public class Dividers {
    public static void main(String[] args) {
        int counter = 0, counterOfDividers = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (n % j == 0)
                    counterOfDividers++;
            }
            counterOfDividers = Math.sqrt(i)%1 == 0? 2 * counterOfDividers - 1: 2 * counterOfDividers;
            if (counterOfDividers%2 == 0) {
                counter++;
                counterOfDividers = 0;
            }
            else
                counterOfDividers = 0;
        }
        System.out.println(counter);
    }
}
