public class BinarySearchTreeBuku14 {
    private NodeBuku14 root;
    // KONSTRUKTOR UNTUK INISIALISASI TREE
    public BinarySearchTreeBuku14() {
        root = null;
    }
    // METHOD IS EMPTY UNTUK MEMERIKSA APAKAH TREE KOSONG ATAU TIDAK
    public boolean isEmpty() {
        return root == null; // TREE KOSONG JIKA ROOT ADALAH NULL
    }
    // METHOD ADD UNTUK MENAMBAHKAN DATA BUKU KE DALAM TREE
    public void add(Buku14 data) {
        NodeBuku14 newNode = new NodeBuku14(data);
        if (isEmpty()) {
            root = newNode; // JIKA TREE KOSONG, NODE BARU MENJADI ROOT
        } else { // JIKA TREE TIDAK KOSONG, CARI POSISI YANG TEPAT UNTUK NODE BARU
            NodeBuku14 current = root;
            NodeBuku14 parent = null;
            while (true) {
                parent = current;
                int cmp = data.kodeBuku.compareTo(current.data.kodeBuku);
                if (cmp < 0) { // JIKA KODE BUKU BARU LEBIH KECIL, PERGI KE SUBTREE KIRI
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        break;
                    }
                } else if (cmp > 0) { // JIKA KODE BUKU BARU LEBIH BESAR, PERGI KE SUBTREE KANAN
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        break;
                    }
                } else {
                    System.out.println("Buku dengan kode " + data.kodeBuku + " sudah ada.");
                    break;
                }
            }
        }
    }
    // METHOD FIND UNTUK MENCARI BUKU BERDASARKAN KODE BUKU
    public boolean find(String kodeBuku) {
        NodeBuku14 current = root;
        while (current != null) { 
            int cmp = kodeBuku.compareTo(current.data.kodeBuku);
            if (cmp == 0) { // JIKA KODE DITEMUKAN, NILAI KEMBALI TRUE
                return true;
            } else if (cmp < 0) { // JIKA KODE BUKU YANG DICARI LEBIH KECIL, PERGI KE SUBTREE KIRI
                current = current.left;
            } else { // JIKA KODE BUKU YANG DICARI LEBIH BESAR, PERGI KE SUBTREE KANAN
                current = current.right;
            }
        }
        return false;
    }

    // METHOD TRAVERSE IN-ORDER UNTUK MENAMPILKAN DATA BUKU SECARA URUT
    public void traverseInOrder(NodeBuku14 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.data.tampilInformasi();
            System.out.println("---------------------------");
            traverseInOrder(node.right);
        }
    }
    // METHOD TRAVERSE PRE-ORDER UNTUK MENAMPILKAN DATA BUKU SECARA PRE-ORDER
    public void traversePreOrder(NodeBuku14 node) {
        if (node != null) {
            node.data.tampilInformasi();
            System.out.println("---------------------------");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    // METHOD UNTUK MENGHITUNG JUMLAH BUKU DALAM TREE
    public int hitungJumlahBuku(NodeBuku14 node) {
        if (node == null) { // JIKA NODE NULL, KEMBALIKAN 0
            return 0;
        }
        return 1 + hitungJumlahBuku(node.left) + hitungJumlahBuku(node.right); // JUMLAHKAN 1 UNTUK NODE SAAT INI DITAMBAH JUMLAH BUKU DI SUBTREE KIRI DAN KANAN
    }
    // METHOD MENCARI BUKU TERTUA
    public Buku14 cariBukuTertua(NodeBuku14 node) {
        if (node == null) { // JIKA NODE NULL, KEMBALIKAN NULL
            return null;
        }
        Buku14 tertua = node.data;

        Buku14 kiri = cariBukuTertua(node.left); // CARI BUKU TERTUA DI SUBTREE KIRI
        if (kiri != null && kiri.tahunTerbit < tertua.tahunTerbit) {
            tertua = kiri;
        }

        Buku14 kanan = cariBukuTertua(node.right); // CARI BUKU TERTUA DI SUBTREE KANAN
        if (kanan != null && kanan.tahunTerbit < tertua.tahunTerbit) {
            tertua = kanan;
        }
        return tertua;
    }
    // METHOD GETTER UNTUK MENDAPATKAN ROOT DARI TREE
    public NodeBuku14 getRoot() {
        return root;
    }
}