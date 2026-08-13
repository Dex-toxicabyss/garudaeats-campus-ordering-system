/**
 * Demonstrates all mandatory GarudaEats assignment scenarios.
 */
public class Main {
    public static void main(String[] args) {
        Kantin kantin = new Kantin("GarudaEats Tel-U");

        MenuItem nasiGoreng = new MenuItem("Nasi Goreng Spesial", 15000, "Makanan", 10);
        MenuItem ayamBakar = new MenuItem("Ayam Bakar Madu", 16000, "Makanan", 8);
        MenuItem esTeh = new MenuItem("Es Teh Manis", 5000, "Minuman", 20);
        MenuItem jusAlpukat = new MenuItem("Jus Alpukat", 12000, "Minuman", 10);
        MenuItem keripikSingkong = new MenuItem("Keripik Singkong", 7000, "Snack", 15);
        MenuItem rotiBakar = new MenuItem("Roti Bakar Cokelat", 8000, "Snack");
        rotiBakar.tambahStok(12);

        kantin.tambahMenu(nasiGoreng);
        kantin.tambahMenu(ayamBakar);
        kantin.tambahMenu(esTeh);
        kantin.tambahMenu(jusAlpukat);
        kantin.tambahMenu(keripikSingkong);
        kantin.tambahMenu(rotiBakar);

        Customer raffata = new Customer("Raffata Izacky Yuargya Aletama", "102042500123", 60000);
        Customer alvin = new Customer("Alvin Isatoni", "102042500124");
        alvin.topUpSaldo(10000);

        System.out.println();
        kantin.tampilkanMenuTersedia();
        System.out.println();
        kantin.tampilkanMenuByKategori("Minuman");
        System.out.println();

        MenuItem hasilPencarian = kantin.cariMenuByNama("Ayam Bakar Madu");
        if (hasilPencarian != null) {
            System.out.println("Hasil pencarian menu:");
            hasilPencarian.displayInfo();
        }

        System.out.println();
        System.out.println("=== ORDER 1: BERHASIL ===");
        Order order1 = kantin.buatOrder("ORD-001", raffata);
        order1.tambahItem(ayamBakar);
        order1.tambahItem(esTeh);
        order1.tambahItem(keripikSingkong);
        order1.displayOrder();
        kantin.selesaikanOrder(order1);
        order1.displayOrder();

        System.out.println();
        System.out.println("=== ORDER 2: SALDO TIDAK CUKUP ===");
        Order order2 = kantin.buatOrder("ORD-002", alvin);
        order2.tambahItem(ayamBakar);
        order2.tambahItem(jusAlpukat);
        order2.displayOrder();
        kantin.selesaikanOrder(order2);
        order2.displayOrder();

        System.out.println();
        System.out.println("=== ORDER 3: DIBATALKAN ===");
        Order order3 = kantin.buatOrder("ORD-003", alvin);
        order3.tambahItem(rotiBakar);
        order3.batalkanOrder();
        order3.displayOrder();

        System.out.println();
        kantin.tampilkanRekap();
        System.out.println();
        System.out.println("=== INFO CUSTOMER ===");
        raffata.displayInfo();
        System.out.println();
        alvin.displayInfo();
    }
}
