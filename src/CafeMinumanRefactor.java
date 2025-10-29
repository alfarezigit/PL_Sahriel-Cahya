import java.util.Scanner;
//SAHRIEL
/**
 * Kelas CafeMinumanRefactor digunakan untuk mensimulasikan sistem pemesanan minuman di sebuah kafe.
 * Program ini menampilkan daftar menu, menerima input jumlah pesanan dari pengguna,
 * menghitung total harga termasuk diskon, dan mencetak nota pemesanan.
 *
 * <p>Fitur utama:
 * <ul>
 *   <li>Menampilkan daftar menu minuman beserta harga</li>
 *   <li>Menerima input jumlah pesanan dari pengguna</li>
 *   <li>Menghitung total harga dan diskon</li>
 *   <li>Mencetak nota pemesanan secara terformat</li>
 * </ul>
 *
 * @author
 * Sahriel Cahya Alfarezi
 * @version 1.0
 * @since 2025-10-29
 */
public class CafeMinumanRefactor {

    /** Daftar nama minuman yang tersedia */
    private static final String[] MENU = {"Kopi Hitam", "Cappuccino", "Es Teh Manis", "Jus Alpukat"};

    /** Harga dari setiap minuman dalam daftar MENU (urutan sesuai) */
    private static final int[] HARGA = {8000, 12000, 5000, 10000};

    /**
     * Method utama (entry point) dari program.
     * Menampilkan menu, menerima input pesanan, dan mencetak nota pembelian.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        tampilkanMenu();
        int[] jumlahPesanan = inputPesanan();
        cetakNota(jumlahPesanan);
    }

    /**
     * Menampilkan daftar menu minuman beserta harga ke layar.
     * Menggunakan format terstruktur agar mudah dibaca.
     */
    public static void tampilkanMenu() {
        System.out.println("=== MENU MINUMAN CAFE ===");
        for (int i = 0; i < MENU.length; i++) {
            System.out.printf("%d. %s - Rp %,d%n", (i + 1), MENU[i], HARGA[i]);
        }
        System.out.println("===========================");
    }

    /**
     * Meminta pengguna untuk memasukkan jumlah pesanan untuk setiap minuman.
     * Menggunakan {@link Scanner} untuk membaca input dari keyboard.
     *
     * @return array integer yang berisi jumlah pesanan untuk tiap menu
     */
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

    /**
     * Menggabungkan proses perhitungan total dan pencetakan nota pemesanan.
     *
     * @param jumlah array yang berisi jumlah pesanan untuk setiap minuman
     */
    public static void cetakNota(int[] jumlah) {
        int total = hitungTotal(jumlah);
        tampilNota(jumlah, total);
    }

    /**
     * Menghitung total harga pesanan berdasarkan jumlah dan harga menu.
     * Setelah itu, dilakukan perhitungan diskon jika memenuhi syarat.
     *
     * @param jumlah array jumlah pesanan tiap menu
     * @return total harga setelah diskon (jika ada)
     */
    private static int hitungTotal(int[] jumlah) {
        int total = 0;
        for (int i = 0; i < MENU.length; i++) {
            total += HARGA[i] * jumlah[i];
        }
        return hitungDiskon(total);
    }

    /**
     * Menampilkan nota pemesanan berisi daftar item yang dipesan,
     * jumlah, subtotal, dan total pembayaran.
     *
     * @param jumlah array jumlah pesanan tiap menu
     * @param total total pembayaran akhir setelah diskon
     */
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

    /**
     * Menghitung diskon 10% jika total harga melebihi Rp20.000.
     *
     * @param totalBayar total harga sebelum diskon
     * @return total harga setelah potongan diskon (jika memenuhi syarat)
     */
    private static int hitungDiskon(int totalBayar) {
        if (totalBayar > 20000) {
            int diskon = (int) (totalBayar * 0.1);
            System.out.println("Diskon 10%: -Rp " + diskon);
            totalBayar -= diskon;
        }
        return totalBayar;
    }
}
