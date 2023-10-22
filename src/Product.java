public class Product {
    private String productName;
    private double purchasePrice;
    private double sellingPrice;
    private int stock;

    public Product(String productName, double sellingPrice, double purchasePrice, int stock) {
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    public void sell(int quantity) {
        if (quantity > 0 && stock <= quantity) {
            stock -= quantity;
        } else {
            System.out.println("Stok product tidak mencukupi");
        }
    }
}
/*
 * kelas "Product" adalah representasi dari produk dalam sistem yang mencakup
 * atribut seperti nama produk, harga beli, harga jual, dan stok. Dua
 * konstruktor memungkinkan inisialisasi produk dengan atau tanpa harga beli,
 * harga jual, dan stok awal. Metode getter dan setter digunakan untuk mengakses
 * atau mengubah nilai-nilai atribut produk.
 * 
 * Metode "addStock" digunakan untuk menambahkan stok produk dengan memeriksa
 * apakah kuantitas yang ditambahkan positif. Metode "sell" digunakan untuk
 * menjual produk dengan mengurangkan stok berdasarkan kuantitas yang dijual,
 * dengan memeriksa apakah stok cukup. Ini adalah komponen penting dalam
 * manajemen produk dan stok dalam bisnis, memungkinkan penambahan dan penjualan
 * produk dengan validasi yang sesuai.
 */