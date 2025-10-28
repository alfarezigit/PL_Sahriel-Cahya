import java.util.Scanner;

public class CafeMinumanRefactor {

    private static final String[] MENU = {"Kopi Hitam", "Cappuccino", "Es Teh Manis", "Jus Alpukat"};
    private static final int[] HARGA = {8000, 12000, 5000, 10000};

    public static void main(String[] args) {
        tampilkanMenu();
        int[] jumlahPesanan = inputPesanan();
        cetakNota(jumlahPesanan);
    }

    // 1. Menampilkan menu (nama metode lebih jelas)
    public static void tampilkanMenu() {
        System.out.println("=== MENU MINUMAN CAFE ===");
        for (int i = 0; i < MENU.length; i++) {
            System.out.printf("%d. %s - Rp %,d%n", (i + 1), MENU[i], HARGA[i]);
        }
        System.out.println("===========================");
    }

    // 2. Tambah fitur input agar interaktif
    public static int[] inputPesanan() {
        Scanner scanner = new Scanner(System.in);
        int[] jumlah = new int[MENU.length];
        System.out.println("\nMasukkan jumlah pesanan tiap minuman:");
        for (int i = 0; i < MENU.length; i++) {
            System.out.print(MENU[i] + " = ");
            jumlah[i] = scanner.nextInt();
        }
        return jumlah;
    }

    // 3. Pecah proses nota jadi dua method: hitungTotal & tampilNota
    public static void cetakNota(int[] jumlah) {
        int total = hitungTotal(jumlah);
        tampilNota(jumlah, total);
    }

    // 4. Pisahkan perhitungan total agar kode lebih bersih
    private static int hitungTotal(int[] jumlah) {
        int total = 0;
        for (int i = 0; i < MENU.length; i++) {
            total += HARGA[i] * jumlah[i];
        }
        return hitungDiskon(total);
    }

    // 5. Gunakan printf dan format rupiah
    private static void tampilNota(int[] jumlah, int total) {
        System.out.println("\n=== NOTA PEMESANAN ===");
        for (int i = 0; i < MENU.length; i++) {
            if (jumlah[i] > 0) {
                System.out.printf("%-15s x %d = Rp %,d%n", MENU[i], jumlah[i], (HARGA[i] * jumlah[i]));
            }
        }
        System.out.printf("Total Bayar: Rp %,d%n", total);
        System.out.println("=======================");
    }

    // 6. Ubah nama variabel & tambahkan komentar deskriptif
    private static int hitungDiskon(int totalBayar) {
        if (totalBayar > 20000) {
            int diskon = (int) (totalBayar * 0.1);
            System.out.println("Diskon 10%: -Rp " + diskon);
            totalBayar -= diskon;
        }
        return totalBayar;
    }
}
