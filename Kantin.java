/**
 * Manages menu data and completed orders for one campus cafeteria.
 */
public class Kantin {
    private String namaKantin;
    private MenuItem[] daftarMenu;
    private int jumlahMenu;
    private int totalOrderSelesai;

    public Kantin(String namaKantin) {
        if (namaKantin == null || namaKantin.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama kantin tidak boleh kosong.");
        }
        this.namaKantin = namaKantin.trim();
        this.daftarMenu = new MenuItem[50];
        this.jumlahMenu = 0;
        this.totalOrderSelesai = 0;
    }

    public String getNamaKantin() {
        return namaKantin;
    }

    public int getTotalOrderSelesai() {
        return totalOrderSelesai;
    }

    public void tambahMenu(MenuItem item) {
        if (item == null) {
            System.out.println("Menu tidak boleh null.");
            return;
        }
        if (jumlahMenu >= daftarMenu.length) {
            System.out.println("Kapasitas menu penuh. Maksimal 50 item.");
            return;
        }
        daftarMenu[jumlahMenu] = item;
        jumlahMenu++;
    }

    public void tampilkanMenuTersedia() {
        System.out.println("=== MENU TERSEDIA: " + namaKantin + " ===");
        boolean adaMenu = false;
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].isAvailable()) {
                tampilkanBarisMenu(i + 1, daftarMenu[i]);
                adaMenu = true;
            }
        }
        if (!adaMenu) {
            System.out.println("Belum ada menu yang tersedia.");
        }
    }

    public void tampilkanMenuByKategori(String kategori) {
        System.out.println("=== MENU KATEGORI: " + kategori + " ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].isAvailable() && daftarMenu[i].getKategori().equalsIgnoreCase(kategori)) {
                tampilkanBarisMenu(i + 1, daftarMenu[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada menu tersedia pada kategori tersebut.");
        }
    }

    public MenuItem cariMenuByNama(String nama) {
        if (nama == null) {
            return null;
        }
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama().equalsIgnoreCase(nama.trim())) {
                return daftarMenu[i];
            }
        }
        return null;
    }

    public Order buatOrder(String orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void selesaikanOrder(Order order) {
        if (order == null) {
            System.out.println("Order tidak boleh null.");
            return;
        }
        if (order.prosesOrder()) {
            totalOrderSelesai++;
        }
    }

    public void tampilkanRekap() {
        int menuTersedia = 0;
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].isAvailable()) {
                menuTersedia++;
            }
        }
        System.out.println("=== REKAP " + namaKantin + " ===");
        System.out.println("Total menu terdaftar : " + jumlahMenu);
        System.out.println("Menu tersedia        : " + menuTersedia);
        System.out.println("Total order selesai  : " + totalOrderSelesai);
    }

    private void tampilkanBarisMenu(int nomor, MenuItem item) {
        System.out.printf(
            "%d. %s | %s | Rp %,.0f | Stok: %d%n",
            nomor,
            item.getNama(),
            item.getKategori(),
            item.getHarga(),
            item.getStok()
        );
    }
}
