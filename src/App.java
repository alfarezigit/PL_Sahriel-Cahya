import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double angka1, angka2, hasil = 0;
        char operator;

        System.out.println("--- Kalkulator Sederhana ---");
        System.out.print("Masukkan angka pertama: ");
        angka1 = input.nextDouble();

        System.out.print("Pilih operasi (+, -, *, /): ");
        operator = input.next().charAt(0);

        System.out.print("Masukkan angka kedua: ");
        angka2 = input.nextDouble();

        switch (operator) {
            case '+':
                hasil = angka1 + angka2;
                break;
            case '-':
                hasil = angka1 - angka2;
                break;
            case '*':
                hasil = angka1 * angka2;
                break;
            case '/':
                if (angka2 != 0) {
                    hasil = angka1 / angka2;
                } else {
                    System.out.println("Error: Pembagian dengan nol tidak diizinkan.");
                    input.close();
                    return;
                }
                break;
            default:
                System.out.println("Error: Operator yang dimasukkan tidak valid.");
                input.close();
                return;
        }
        System.out.println("\nHasil Perhitungan:");
        System.out.println(angka1 + " " + operator + " " + angka2 + " = " + hasil);

        input.close();
    }
}