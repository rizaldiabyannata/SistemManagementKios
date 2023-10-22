public class CLL extends LinkedList<Finance, Node> {
    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(Finance data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(Finance financeToRemove) {
        if (head == null) {
            System.out.println("CLL kosong. Tidak ada data yang bisa dihapus.");
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.finance.equals(financeToRemove)) {
                if (current == head) {
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                System.out.println("Data berhasil dihapus.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Data tidak ditemukan dan tidak dapat dihapus.");
    }

    public void insertByCashier(Cashier cashier) {
        insert(new Finance(cashier.getData(), cashier.getTransaction().getTotal()));
    }

    public void cancelTransaction(String name, int amount) {
        Finance cancelFinance = searchByName(name);
        if (cancelFinance != null && cancelFinance.getData().getStock() >= amount) {
            cancelFinance.getData().setStock(cancelFinance.getData().getStock() + amount);
            cancelFinance.setIncome(cancelFinance.getIncome() - amount * cancelFinance.getData().getSellingPrice());
            if (cancelFinance.getIncome() <= 0) {
                remove(cancelFinance);
            }
        }
    }

    public void insertAtPosition(Finance data, int position) {
        if (position <= 0) {
            System.out.println("Posisi tidak valid.");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1 || head == null) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            tail.next = head;
        } else {
            Node current = head;
            int currentPosition = 1;

            while (currentPosition < position - 1 && current.next != head) {
                current = current.next;
                currentPosition++;
            }

            newNode.next = current.next;
            current.next = newNode;

            if (current == tail) {
                tail = newNode;
            }
        }
    }

    public void insertFirst(Finance data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
    }

    public void sortByIncome() {
        if (head == null || head.next == head) {
            return;
        }

        boolean swapped;
        Node current;
        Node last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.finance.getIncome() < current.next.finance.getIncome()) {
                    Finance tempData = current.finance;
                    current.finance = current.next.finance;
                    current.next.finance = tempData;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }

    public Finance searchByName(String name) {
        if (head == null) {
            System.out.println("CLL kosong. Tidak ada data yang bisa dicari.");
            return null;
        }

        Node current = head;

        do {
            if (current.finance.getData().getName().equalsIgnoreCase(name)) {
                return current.finance;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Data dengan nama '" + name + "' tidak ditemukan.");
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("CLL kosong. Tidak ada data yang ditampilkan.");
            return;
        }

        Node current = head;
        int index = 1;

        do {
            Finance finance = current.finance;
            System.out.println("Index: " + index + "\tNama: " + finance.getData().getName()
                    + "\tIncome: " + finance.getIncome() + "\tOutcome: " + finance.getOutcome());
            current = current.next;
            index++;
        } while (current != head);
    }
}
