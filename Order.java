/**
 * Represents a single customer ordering session with at most ten menu items.
 */
public class Order {
    private String orderId;
    private Customer customer;
    private MenuItem[] items;
    private int jumlahItem;
    private String status;

    public Order(String orderId, Customer customer) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID tidak boleh kosong.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer tidak boleh null.");
        }

        this.orderId = orderId.trim();
        this.customer = customer;
        this.items = new MenuItem[10];
        this.jumlahItem = 0;
        this.status = "MENUNGGU";
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public int getJumlahItem() {
        return jumlahItem;
    }

    public boolean tambahItem(MenuItem item) {
        if (!status.equals("MENUNGGU")) {
            System.out.println("Item tidak dapat ditambah karena order tidak berstatus MENUNGGU.");
            return false;
        }
        if (item == null) {
            System.out.println("Item tidak boleh null.");
            return false;
        }
        if (jumlahItem >= items.length) {
            System.out.println("Order penuh. Maksimal 10 item.");
            return false;
        }
        if (!item.isAvailable()) {
            System.out.println("Item " + item.getNama() + " sedang tidak tersedia.");
            return false;
        }
        if (hitungItemDalamOrder(item) + 1 > item.getStok()) {
            System.out.println(
                "Item " + item.getNama() + " tidak dapat ditambah karena jumlah pesanan melebihi stok tersedia."
            );
            return false;
        }

        items[jumlahItem] = item;
        jumlahItem++;
        return true;
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < jumlahItem; i++) {
            total += items[i].getHarga();
        }
        return total;
    }

    public boolean prosesOrder() {
        if (!status.equals("MENUNGGU")) {
            System.out.println("Order " + orderId + " tidak dapat diproses. Status: " + status + ".");
            return false;
        }
        if (jumlahItem == 0) {
            System.out.println("Order " + orderId + " belum memiliki item.");
            return false;
        }

        MenuItem itemStokTidakCukup = cariItemStokTidakCukup();
        if (itemStokTidakCukup != null) {
            System.out.println(
                "Order " + orderId + " tidak dapat diproses karena stok "
                    + itemStokTidakCukup.getNama() + " tidak mencukupi."
            );
            return false;
        }

        double total = hitungTotal();
        if (!customer.bayar(total)) {
            return false;
        }

        for (int i = 0; i < jumlahItem; i++) {
            if (!items[i].kurangiStok()) {
                // This path is unreachable in the single-threaded console flow because
                // all required stock was revalidated before payment.
                throw new IllegalStateException("Stok berubah saat order sedang diproses.");
            }
        }
        customer.tambahPoin(jumlahItem);
        status = "SELESAI";
        System.out.println("Order " + orderId + " berhasil diproses.");
        return true;
    }

    public void batalkanOrder() {
        if (status.equals("SELESAI")) {
            System.out.println("Order " + orderId + " sudah selesai dan tidak bisa dibatalkan.");
            return;
        }
        if (status.equals("DIBATALKAN")) {
            System.out.println("Order " + orderId + " sudah dibatalkan sebelumnya.");
            return;
        }
        status = "DIBATALKAN";
        System.out.println("Order " + orderId + " berhasil dibatalkan.");
    }

    public void displayOrder() {
        System.out.println("----------------------------------------");
        System.out.println("Order ID : " + orderId);
        System.out.println("Customer : " + customer.getNama());
        System.out.println("Status   : " + status);
        System.out.println("Items:");
        if (jumlahItem == 0) {
            System.out.println("- Belum ada item.");
        } else {
            for (int i = 0; i < jumlahItem; i++) {
                System.out.printf("%d. %s — Rp %,.0f%n", i + 1, items[i].getNama(), items[i].getHarga());
            }
        }
        System.out.printf("Total    : Rp %,.0f%n", hitungTotal());
        System.out.println("----------------------------------------");
    }

    private int hitungItemDalamOrder(MenuItem target) {
        int jumlah = 0;
        for (int i = 0; i < jumlahItem; i++) {
            if (items[i] == target) {
                jumlah++;
            }
        }
        return jumlah;
    }

    private MenuItem cariItemStokTidakCukup() {
        for (int i = 0; i < jumlahItem; i++) {
            MenuItem item = items[i];
            if (hitungItemDalamOrder(item) > item.getStok()) {
                return item;
            }
        }
        return null;
    }
}
