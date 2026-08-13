/**
 * Represents one food, beverage, or snack available in GarudaEats.
 */
public class MenuItem {
    private String nama;
    private double harga;
    private String kategori;
    private int stok;

    public MenuItem(String nama, double harga, String kategori) {
        this(nama, harga, kategori, 0);
    }

    public MenuItem(String nama, double harga, String kategori, int stok) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga menu tidak boleh negatif.");
        }
        if (!kategoriValid(kategori)) {
            throw new IllegalArgumentException("Kategori harus Makanan, Minuman, atau Snack.");
        }
        if (stok < 0) {
            throw new IllegalArgumentException("Stok menu tidak boleh negatif.");
        }

        this.nama = nama.trim();
        this.harga = harga;
        this.kategori = normalisasiKategori(kategori);
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setHarga(double hargaBaru) {
        if (hargaBaru < 0) {
            System.out.println("Harga baru tidak boleh negatif.");
            return;
        }
        harga = hargaBaru;
    }

    public void tambahStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah stok tambahan harus lebih dari nol.");
            return;
        }
        stok += jumlah;
    }

    public boolean kurangiStok() {
        if (!isAvailable()) {
            return false;
        }
        stok--;
        return true;
    }

    public boolean isAvailable() {
        return stok > 0;
    }

    public void displayInfo() {
        System.out.println("Nama     : " + nama);
        System.out.printf("Harga    : Rp %,.0f%n", harga);
        System.out.println("Kategori : " + kategori);
        System.out.println("Stok     : " + stok);
    }

    private boolean kategoriValid(String nilaiKategori) {
        return nilaiKategori != null
            && (nilaiKategori.equalsIgnoreCase("Makanan")
            || nilaiKategori.equalsIgnoreCase("Minuman")
            || nilaiKategori.equalsIgnoreCase("Snack"));
    }

    private String normalisasiKategori(String nilaiKategori) {
        if (nilaiKategori.equalsIgnoreCase("Makanan")) {
            return "Makanan";
        }
        if (nilaiKategori.equalsIgnoreCase("Minuman")) {
            return "Minuman";
        }
        return "Snack";
    }
}
