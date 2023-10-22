public abstract class LinkedList<T, NodeT> {
    protected NodeT head;

    public abstract void insert(T data);

    public abstract void remove(T data);

    public abstract void display();
}

/*
 * Kode tersebut adalah kerangka dasar untuk kelas abstrak "LinkedList." Ini
 * memiliki atribut "head" yang merupakan titik awal dalam linked list. Kelas
 * ini mendefinisikan tiga metode abstrak: "insert" untuk menambahkan data,
 * "remove" untuk menghapus data, dan "display" untuk menampilkan isi linked
 * list. Implementasinya harus diberikan oleh kelas turunan sesuai tipe data
 * yang diinginkan.
 */
