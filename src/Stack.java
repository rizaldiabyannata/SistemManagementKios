class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        int data = top.dataStack;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getTop() {
        return top.dataStack;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        Node currentNode = top;
        System.out.print("Stack: ");

        while (currentNode != null) {
            System.out.print(currentNode.dataStack + " ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
/*
 * Kode di atas mengimplementasikan struktur data tumpukan (stack) dalam kelas
 * "Stack" menggunakan simpul (node) dengan tiga operasi utama: `push`, `pop`,
 * dan `display`.
 * 
 * - `push(int data)` digunakan untuk menambahkan elemen baru ke atas tumpukan.
 * Saat dipanggil, ia membuat simpul baru dengan nilai `data`, mengatur simpul
 * ini sebagai elemen paling atas tumpukan, dan mengubah referensi `top` ke
 * simpul baru tersebut.
 * 
 * - `pop()` menghapus elemen paling atas tumpukan dan mengembalikan nilainya.
 * Sebelum menghapus, ia memeriksa apakah tumpukan kosong. Jika kosong, akan
 * mencetak pesan kesalahan dan mengembalikan -1.
 * 
 * - `isEmpty()` memeriksa apakah tumpukan kosong dengan menguji apakah
 * referensi `top` adalah null.
 * 
 * - `getTop()` mengembalikan nilai dari elemen paling atas tumpukan tanpa
 * menghapusnya. Ini berguna untuk melihat nilai paling atas tanpa mengubah
 * tumpukan.
 * 
 * - `display()` digunakan untuk menampilkan isi tumpukan saat ini.
 * 
 * Kelas ini dapat digunakan untuk berbagai aplikasi yang memerlukan operasi
 * tumpukan, seperti evaluasi ekspresi matematika, pelacakan riwayat transaksi,
 * atau mengeksekusi perintah dalam urutan terbalik. Tumpukan adalah struktur
 * data yang mengikuti prinsip "last in, first out" (LIFO), yang berarti elemen
 * yang terakhir dimasukkan adalah yang pertama dikeluarkan.
 */