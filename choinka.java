import java.util.Scanner;

public class choinka {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Z ilu wierszy ma się składać choinka?");

        int liczba = scan.nextInt();

        int i, j;
        int ileWierszy = liczba;
        int ileGwiazdek = 1;

        while (ileWierszy > 0) {

            for (i = ileWierszy - 1; i > 0; i--) {
                System.out.print(" ");
            }

            for (j = ileGwiazdek; j > 0; j--)
                System.out.print("*");

            System.out.println();
            ileWierszy--;
            ileGwiazdek += 2;

        }
    }
}
