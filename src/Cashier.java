public class Cashier {
    private Product data;
    private Finance transaction;

    public Cashier(Product data, Finance transaction) {
        this.data = data;
        this.transaction = transaction;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public Finance getTransaction() {
        return transaction;
    }

    public void setTransaction(Finance transaction) {
        this.transaction = transaction;
    }

    /*
     * Kode tersebut merupakan implementasi dari sebuah kelas Java yang disebut
     * "Cashier" (kasir). Kelas ini memiliki dua atribut pribadi: "data" yang
     * merupakan objek dari kelas "Product" dan "transaction" yang merupakan objek
     * dari kelas "Finance." Konstruktor kelas ini menerima dua parameter, yaitu
     * objek Product dan Finance, yang digunakan untuk menginisialisasi
     * atribut-atribut kelas.
     * 
     * Kelas "Cashier" memiliki empat metode akses (getter dan setter) untuk atribut
     * "data" dan "transaction," yang memungkinkan akses dan perubahan nilai-nilai
     * atribut tersebut dari luar kelas. Kelas ini sejauh ini tampaknya dirancang
     * untuk mengelola data produk dan transaksi keuangan dalam konteks kasir.
     */

}