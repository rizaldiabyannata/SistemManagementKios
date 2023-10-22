public class Finance {
    private double income;
    private double outcome;
    private int total;
    private Product data;

    public Finance(Product data, int total) {
        this.data = data;
        this.total = total;
        this.income = data.getSellingPrice() * total;
    }

    public Finance(double income, double outcome, int total, Product data) {
        this.income = income;
        this.outcome = outcome;
        this.total = total;
        this.data = data;
    }

    public Product getData() {
        return data;
    }

    public double getIncome() {
        return income;
    }

    public double getOutcome() {
        return outcome;
    }

    public int getTotal() {
        return total;
    }

    public void setData(Product data) {
        this.data = data;
        this.income = data.getSellingPrice() * total;
        this.outcome = data.getPurchasePrice() * total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.income = data.getSellingPrice() * total;
        this.outcome = data.getPurchasePrice() * total;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    /*
     * Kode tersebut mendefinisikan sebuah kelas Java yang disebut "Finance" yang
     * digunakan untuk mengelola data keuangan, terutama pendapatan dan pengeluaran
     * dalam sebuah bisnis. Kelas "Finance" memiliki beberapa atribut pribadi,
     * termasuk "income" (pendapatan), "outcome" (pengeluaran), "total" (total item
     * yang terlibat), dan "data" (objek dari kelas "Product" yang berkaitan dengan
     * transaksi keuangan).
     * 
     * Kelas "Finance" memiliki dua konstruktor. Yang pertama menerima objek
     * "Product" dan total item, dan menghitung pendapatan berdasarkan harga jual
     * produk dan total. Konstruktor kedua menginisialisasi atribut-atribut dengan
     * nilai yang diberikan.
     * 
     * Kelas ini juga memiliki metode akses (getter) dan metode mutasi (setter)
     * untuk mengakses dan mengubah nilai atribut-atributnya. Setter "setData" dan
     * "setTotal" juga memperbarui pendapatan dan pengeluaran berdasarkan perubahan
     * data produk atau total item. Kelas ini digunakan untuk melacak dan mengelola
     * informasi keuangan dalam konteks bisnis, seperti menghitung pendapatan dan
     * pengeluaran berdasarkan transaksi yang melibatkan produk tertentu.
     */
}
