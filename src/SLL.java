public class SLL extends LinkedList<Cashier, Node> {
    Node head;

    public void insert(Cashier cashier) {
        Node node = new Node(cashier);
        if (head == null) {
            head = node;
            head.next = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = null;
        }

    }

    public void remove(Cashier cashier) {
        if (head == null) {
            return;
        }

        if (head.cashier.equals(cashier)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.cashier.equals(cashier)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(
                    temp.cashier.getData().getName() + " = " + temp.cashier.getTransaction().getIncome() + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

/*
 * Kelas "SLL" adalah implementasi dari sebuah linked list (daftar berantai)
 * khusus untuk objek "Cashier." Kelas ini memiliki metode "insert" untuk
 * menambahkan objek "Cashier" ke dalam linked list, "remove" untuk menghapus
 * objek "Cashier," dan "display" untuk menampilkan informasi terkait Cashier.
 * 
 * Dalam metode "insert," jika linked list masih kosong, maka objek "Cashier"
 * dibuat menjadi simpul pertama (head). Jika tidak, maka objek "Cashier"
 * ditambahkan sebagai simpul baru di akhir linked list.
 * 
 * Metode "remove" digunakan untuk menghapus objek "Cashier" dari linked list.
 * Jika objek yang akan dihapus adalah head, maka head diubah ke simpul
 * berikutnya. Jika tidak, maka pencarian dilakukan hingga objek yang sesuai
 * ditemukan, dan simpul yang sebelumnya mengarah ke objek "Cashier" yang
 * dihapus akan dihubungkan dengan simpul yang mengikuti objek tersebut.
 * 
 * Metode "display" digunakan untuk menampilkan informasi Cashier yang ada dalam
 * linked list, termasuk nama dan pendapatan yang terkait dengan setiap Cashier.
 * Ini adalah kelas yang berguna untuk mengelola daftar kasir dan transaksi
 * kasir dalam sistem bisnis.
 */