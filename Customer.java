/**
 * Represents a student customer with a digital balance and loyalty points.
 */
public class Customer {
    private String nama;
    private String nim;
    private double saldo;
    private int poin;

    public Customer(String nama, String nim) {
        this(nama, nim, 0);
    }

    public Customer(String nama, String nim, double saldoAwal) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama customer tidak boleh kosong.");
        }
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
        }
        if (saldoAwal < 0) {
            throw new IllegalArgumentException("Saldo awal tidak boleh negatif.");
        }

        this.nama = nama.trim();
        this.nim = nim.trim();
        this.saldo = saldoAwal;
        this.poin = 0;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getPoin() {
        return poin;
    }

    public void topUpSaldo(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Top up gagal: jumlah harus lebih dari nol.");
            return;
        }
        saldo += jumlah;
        System.out.printf("Top up berhasil. Saldo %s: Rp %,.0f%n", nama, saldo);
    }

    public boolean bayar(double jumlah) {
        if (jumlah < 0) {
            System.out.println("Nominal pembayaran tidak valid.");
            return false;
        }
        if (saldo < jumlah) {
            System.out.println("Saldo tidak cukup");
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void tambahPoin(int jumlahPoin) {
        if (jumlahPoin > 0) {
            poin += jumlahPoin;
        }
    }

    public void displayInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + nim);
        System.out.printf("Saldo : Rp %,.0f%n", saldo);
        System.out.println("Poin  : " + poin);
    }
}
