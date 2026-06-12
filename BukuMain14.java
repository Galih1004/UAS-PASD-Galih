public class BukuMain14 {
    public static void main(String[] args) {

        BinarySearchTreeBuku14 bst = new BinarySearchTreeBuku14(); // MEMBUAT OBJEK BST UNTUK MENYIMPAN DATA BUKU

        bst.add(new Buku14("BK105", "Struktur Data",     "Andi",  2020));
        bst.add(new Buku14("BK102", "Algoritma Dasar",   "Budi",  2019));
        bst.add(new Buku14("BK108", "Basis Data",        "Citra", 2021));
        bst.add(new Buku14("BK101", "Pemrograman Java",  "Dewi",  2018));
        bst.add(new Buku14("BK104", "Sistem Operasi",    "Eka",   2022));
        bst.add(new Buku14("BK107", "Jaringan Komputer", "Fajar", 2017));

        System.out.println("  DATA BUKU - IN-ORDER TRAVERSAL  ");
        bst.traverseInOrder(bst.getRoot()); // MEMANGGIL METHOD IN-ORDER UNTUK MENAMPILKAN DATA BUKU SECARA URUT BERDASARKAN KODE BUKU
;
        System.out.println("  DATA BUKU - PRE-ORDER TRAVERSAL ");
        bst.traversePreOrder(bst.getRoot()); // MEMANGGIL METHOD PRE-ORDER UNTUK MENAMPILKAN DATA BUKU SECARA PRE-ORDER
 

        System.out.println("---- PENCARIAN BUKU ----");
        String cari1 = "BK104";
        boolean hasil1 = bst.find(cari1);
        System.out.println("Pencarian " + cari1 + ": " + (hasil1 ? "ditemukan" : "tidak ditemukan"));

        String cari2 = "BK110";
        boolean hasil2 = bst.find(cari2);
        System.out.println("Pencarian " + cari2 + ": " + (hasil2 ? "ditemukan" : "tidak ditemukan"));

        System.out.println("---- DATA JUMLAH BUKU ----");
        int jumlah = bst.hitungJumlahBuku(bst.getRoot());
        System.out.println("Jumlah buku: " + jumlah);

        System.out.println("---- DATA BUKU TERTUA ----");
        Buku14 tertua = bst.cariBukuTertua(bst.getRoot());
        if (tertua != null) {
            tertua.tampilInformasi();
        } else {
            System.out.println("Tree kosong.");
        }
    }
}