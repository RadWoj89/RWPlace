import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Wpisz jakąś liczbę");

        int liczba = scan.nextInt();

        System.out.println("Wpisana liczba to: " + liczba);
    }
}
