public class DLL extends LinkedList<Product, Node> {
    private Node head;

    public void insert(Product data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        updateIndices(head);
    }

    public void insertLast(Product data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            node.prev = null;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
        }
        updateIndices(head);
    }

    public void insertAtPosition(Product data, int position) {
        Node newNode = new Node(data);
        if (position <= 0) {
            System.out.println("Posisi tidak valid.");
            return;
        }
        if (position == 1 || head == null) {
            newNode.next = head;
            newNode.prev = null;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;

            updateIndices(head);
            return;
        }

        Node node = head;
        int nodePosition = 1;

        while (nodePosition < position - 1 && node.next != null) {
            node = node.next;
            nodePosition++;
        }

        if (nodePosition != position - 1) {
            System.out.println("Posisi tidak valid.");
            return;
        }

        newNode.next = node.next;
        newNode.prev = node;
        if (node.next != null) {
            node.next.prev = newNode;
        }
        node.next = newNode;

        updateIndices(newNode);
    }

    private void updateIndices(Node startNode) {
        Node node = startNode;
        while (node != null) {
            node = node.next;
        }
    }

    public void removeByName(String productName) {
        Node node = head;

        if (node != null && node.product.getName().equalsIgnoreCase(productName)) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (node != null && !node.product.getName().equalsIgnoreCase(productName)) {
            node = node.next;
        }

        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        } else {
            System.out.println("Produk dengan nama " + productName + " tidak ditemukan.");
        }

        updateIndices(node);
    }

    public void sortByName() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head.next;

        while (current != null) {
            Node insertNode = current;
            String key = current.product.getName();
            Node prev = current.prev;

            while (prev != null && key.compareTo(prev.product.getName()) < 0) {
                current = prev;
                prev = prev.prev;
            }

            if (prev == null) {
                insertNode.next = head;
                insertNode.prev = null;
                head.prev = insertNode;
                head = insertNode;
            } else {
                insertNode.next = prev.next;
                insertNode.prev = prev;
                if (prev.next != null) {
                    prev.next.prev = insertNode;
                }
                prev.next = insertNode;
            }

            current = current.next;
        }

        updateIndices(head);
    }

    public void sortBySellingPrice() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head.next;

        while (current != null) {
            Node insertNode = current;
            double key = current.product.getSellingPrice();
            Node prev = current.prev;

            while (prev != null && key > prev.product.getSellingPrice()) {
                current = prev;
                prev = prev.prev;
            }

            if (prev == null) {
                insertNode.next = head;
                insertNode.prev = null;
                head.prev = insertNode;
                head = insertNode;
            } else {
                insertNode.next = prev.next;
                insertNode.prev = prev;
                if (prev.next != null) {
                    prev.next.prev = insertNode;
                }
                prev.next = insertNode;
            }

            current = current.next;
        }
        updateIndices(head);
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.println("\nNama: " + node.product.getName() + "\nHarga: "
                    + node.product.getSellingPrice());
            node = node.next;
        }
    }

    public void getDetail(String name) {
        Node node = head;
        while (node != null && !node.product.getName().equalsIgnoreCase(name)) {
            node = node.next;
        }
        System.out.println("Nama: " + node.product.getName());
        System.out.println("Harga Jual: " + node.product.getSellingPrice());
        System.out.println("Harga Beli: " + node.product.getPurchasePrice());
        System.out.println("Stok Barang: " + node.product.getStock());
    }

    public Product search(String name) {
        Node node = head;
        while (node != null && !node.product.getName().equalsIgnoreCase(name)) {
            node = node.next;
        }
        if (node != null) {
            return node.product;
        }
        return null;
    }

    public boolean booleanSearch(String name) {
        Node node = head;
        while (node != null) {
            if (node.product.getName().equalsIgnoreCase(name)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void remove(Product dataToRemove) {
        if (head == null) {
            System.out.println("Daftar kosong. Tidak ada data yang bisa dihapus.");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.product.equals(dataToRemove)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    current.prev.next = current.next;
                }
                updateIndices(head);
                System.out.println("Data berhasil dihapus.");
                return;
            }
            current = current.next;
        }

        System.out.println("Data tidak ditemukan dan tidak dapat dihapus.");
    }

}
