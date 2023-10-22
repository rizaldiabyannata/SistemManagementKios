public class Node {
    Product product;
    Cashier cashier;
    Finance finance;
    int dataStack;
    Node next;
    Node prev;
    Node tail;

    public Node(Product product) {
        this.product = product;
    }

    public Node(Cashier cashier) {
        this.cashier = cashier;
    }

    public Node(Finance finance) {
        this.finance = finance;
    }

    public Node(Product product, Node next, Node prev) {
        this.product = product;
        this.next = next;
        this.prev = prev;
    }

    public Node(Cashier cashier, Node next) {
        this.cashier = cashier;
        this.next = next;
    }

    public Node(Finance finance, Node next) {
        this.finance = finance;
        this.next = next;
    }

    public Node(int data) {
        this.dataStack = data;
        this.next = null;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getDataStack() {
        return dataStack;
    }

    public void setDataStack(int dataStack) {
        this.dataStack = dataStack;
    }
}
/*
 * Kode tersebut mendefinisikan sebuah kelas Java yang disebut "Node," yang
 * digunakan untuk membuat simpul (node) dalam berbagai jenis struktur data.
 * Kelas Node memiliki beberapa atribut yang dapat berisi objek Product,
 * Cashier, Finance, atau data integer, tergantung pada konstruktor yang
 * digunakan. Node juga memiliki referensi ke simpul berikutnya (next) dan
 * simpul sebelumnya (prev), yang memungkinkan penggunaan Node ini dalam
 * struktur data seperti linked list.
 * 
 * Setiap objek Node dapat menyimpan data yang sesuai dengan jenis atribut yang
 * ada dalam konstruktor yang digunakan. Misalnya, jika konstruktor Node(Product
 * product) digunakan, Node akan mengandung objek Product. Metode getter dan
 * setter digunakan untuk mengakses atau mengubah nilai atribut dalam Node.
 * 
 * Node ini tampaknya dirancang untuk mendukung berbagai struktur data yang
 * memerlukan simpul, seperti linked lists atau struktur data berantai lainnya.
 * Dengan variasi konstruktor, Node dapat digunakan dalam berbagai konteks,
 * memungkinkan penyimpanan dan pengelolaan data yang berbeda dalam satu simpul.
 */