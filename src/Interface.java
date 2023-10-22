import java.util.Scanner;

public class Interface {
    private Stack menuStack;

    /*
     * code "private Stack menuStack;" adalah atribut dari kelas Interface yang
     * di-set sebagai private sehingga kelas lain tidak dapat menggakses atribut
     * tersebut. atribut tersebut menggunakan tipe data Stack dan di beri nama
     * menuStack
     */

    public Interface() {
        menuStack = new Stack();
        menuStack.push(0);
    }

    /*
     * code "public Interface()" adalah konstraktor dari kelas Interface yang
     * berisikan inisialisati tipe data Stack dan pemanggilan fungsi pada kelas
     * Stack yaitu push() dengan di set pada parameter 0
     */

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        /*
         * kode "public void run()" adalah sebuah fungsi dengan tipe void. kode
         * "Scanner scanner = new Scanner(System.in);" adalah insialisasi tipe data
         * Scanner yang di gunaakan sebagai fungsi inputan pada sistem. kode
         * "boolean exit = false;" adalah sebagai ini inisialisasi variabel exit dengan
         * tipe data boolean dan di set sebagai false
         */

        while (!exit) {
            int currentMenu = menuStack.getTop();
            displayMenu(currentMenu);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    menuStack.pop();
                    break;
                case 1:
                    if (currentMenu == 0) {
                        menuStack.push(1);
                    } else if (currentMenu == 1) {
                        cashierMenu(1);
                    } else if (currentMenu == 3) {
                        keuanganKios(1);
                    } else if (currentMenu == 2) {
                        managementItemKios(1);
                    }
                    break;

                case 2:
                    if (currentMenu == 0) {
                        menuStack.push(2);
                    } else if (currentMenu == 1) {
                        cashierMenu(2);
                    } else if (currentMenu == 2) {
                        managementItemKios(2);
                    } else if (currentMenu == 3) {
                        keuanganKios(2);
                    }
                    break;

                case 3:
                    if (currentMenu == 0) {
                        menuStack.push(3);

                    } else if (currentMenu == 2) {
                        managementItemKios(3);
                    } else if (currentMenu == 3) {
                        keuanganKios(3);
                    }
                    break;

                case 4:
                    if (currentMenu == 2) {
                        managementItemKios(4);
                    }
                    break;
                case 5:
                    if (currentMenu == 2) {
                        managementItemKios(5);
                    }
                    break;
                case 8:
                    exit = true;
                    scanner.close();
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    scanner.close();
                    break;
            }
        }
    }

    public void displayMenu(int menu) {
        switch (menu) {
            case 0:
                System.out.println("Selamat datang di KiosKoe");
                System.out.println("Menu Utama");
                System.out.println("1. KASIR");
                System.out.println("2. MANAGEMENT ITEM KIOS");
                System.out.println("3. KEUANGAN KIOS");
                System.out.println("0. Keluar");
                System.out.print("Pilih: ");
                break;

            case 1:
                System.out.println("Menu Kasir");
                System.out.println("1. Beli");
                System.out.println("2. Cancel Beli");
                System.out.println("0. Kembali");
                System.out.print("Pilih: ");
                break;

            case 2:
                System.out.println("Menu Manajemen Item Kios");
                System.out.println("1. Masukkan Barang");
                System.out.println("2. Hapus Barang");
                System.out.println("3. Lihat Daftar Barang");
                System.out.println("4. Masukkan Barang Berdasarkan Lokasi");
                System.out.println("5. Melihat Detail Barang");
                System.out.println("0. Kembali");
                System.out.print("Pilih: ");
                break;

            case 3:
                System.out.println("Menu Keuangan Kios");
                System.out.println("1. Tampilkan Transaksi");
                System.out.println("2. Hapus Transaksi");
                System.out.println("3. Sort Transaksi");
                System.out.println("0. Kembali");
                System.out.print("Pilih: ");
                break;
        }
    }

    public void cashierMenu(int choice) {
        Scanner scanner = new Scanner(System.in);
        SLL listCashier = new SLL();
        DLL productList = new DLL();
        CLL transactionList = new CLL();
        int pilih;
        switch (choice) {
            case 1:
                while (true) {
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = scanner.next();
                    System.out.print("Masukkan Jumlah Barang: ");
                    int jumlahBarang = scanner.nextInt();
                    if (productList.search(namaBarang) != null) {
                        System.out.print("1. Komfirmasi\n2.Batalkan");
                        pilih = scanner.nextInt();
                        switch (pilih) {
                            case 1:
                                Finance transaction = new Finance(productList.search(namaBarang), jumlahBarang);
                                Cashier cashier = new Cashier(productList.search(namaBarang), transaction);
                                listCashier.insert(cashier);
                                transactionList.insertByCashier(cashier);
                                break;
                            case 2:
                                break;
                        }
                    } else {
                        System.out.println("Item tidak ada");
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Masukkan Nama Barang Yang dicancel: ");
                String namaBarang = scanner.next();
                System.out.print("Masukkan Jumlah Barang Yang dicancel: ");
                int jumlahBarang = scanner.nextInt();
                if (productList.search(namaBarang) != null) {
                    transactionList.cancelTransaction(namaBarang, jumlahBarang);
                }
                break;
            default:
                System.out.println("Input Salah!");
                scanner.close();
                break;
        }
    }

    public void managementItemKios(int choice) {
        Scanner scanner = new Scanner(System.in);
        DLL productList = new DLL();
        CLL transactionList = new CLL();
        switch (choice) {
            case 1:
                boolean lanjut = false;
                do {
                    int jumlahBarang;
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = scanner.next();
                    if (productList.booleanSearch(namaBarang)) {
                        System.out.println("Nama barang sudah terdaftar\nMasukkan tambahan Stock barang: ");
                        jumlahBarang = scanner.nextInt();
                        Product currentProduct = productList.search(namaBarang);
                        currentProduct.setStock(currentProduct.getStock() + jumlahBarang);
                        Finance finance = new Finance(currentProduct, jumlahBarang);
                        transactionList.insert(finance);
                    } else {
                        System.out.print("Masukkan Jumlah Barang: ");
                        jumlahBarang = scanner.nextInt();
                        System.out.print("Masukkan Harga Beli Barang: ");
                        double hargaBeli = scanner.nextDouble();
                        System.out.print("Masukkan Harga Jual Barang: ");
                        double hargaJual = scanner.nextDouble();
                        Product newProduct = new Product(namaBarang, hargaBeli, hargaJual, jumlahBarang);
                        productList.insert(newProduct);
                        Finance finance = new Finance(hargaBeli, hargaJual, jumlahBarang, newProduct);
                        transactionList.insert(finance);
                    }
                    System.out.print("Lanjut mengisi [y/n]:");
                    String isi = scanner.next();
                    if (isi.equals("y") || isi.equals("Y")) {
                        lanjut = true;
                    } else {
                        lanjut = false;
                    }
                } while (lanjut);

                break;
            case 2:
                int jumlahHapus;
                System.out.print("Masukkan Nama Barang: ");
                String namaBarangDiHapus = scanner.next();
                if (productList.booleanSearch(namaBarangDiHapus)) {
                    System.out.println("Nama barang sudah terdaftar\nMasukkan pengurangan Stock barang: ");
                    jumlahHapus = scanner.nextInt();
                    Product currentProduct = productList.search(namaBarangDiHapus);
                    currentProduct.setStock(currentProduct.getStock() - jumlahHapus);
                    Finance finance = transactionList.searchByName(namaBarangDiHapus);
                    finance.setOutcome(
                            finance.getOutcome() - currentProduct.getStock() * currentProduct.getPurchasePrice());
                } else {
                    System.out.println("Barang yang anda cari tidak ada di dalam list.");
                }
                break;
            case 3:
                productList.display();
                break;
            case 4:
                productList.display();
                System.out.println("==========================");
                System.out.print("Masukkan Nama Barang: ");
                String namaBarangDiTambah = scanner.next();
                if (!productList.booleanSearch(namaBarangDiTambah)) {
                    System.out.println("Nama Barang Sudah Terdaftar");
                    break;
                }
                System.out.print("Masukkan Jumlah Barang: ");
                int jumlahBarang = scanner.nextInt();
                System.out.print("Masukkan Harga Beli Barang: ");
                double hargaBeli = scanner.nextDouble();
                System.out.print("Masukkan Harga Jual Barang: ");
                double hargaJual = scanner.nextDouble();
                Product newProduct = new Product(namaBarangDiTambah, hargaBeli, hargaJual, jumlahBarang);
                System.out.print("Masukkan Posisi Barang: ");
                int posisi = scanner.nextInt();
                productList.insertAtPosition(newProduct, posisi);
                break;
            case 5:
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();
                System.out.println("=====================");
                productList.getDetail(namaBarang);
                break;
            default:
                System.out.println("Pilihan anda tidak ada");
                scanner.close();
                break;
        }
    }

    public void keuanganKios(int choice) {
        Scanner scanner = new Scanner(System.in);
        CLL transactionList = new CLL();
        switch (choice) {
            case 1:
                transactionList.display();
                break;
            case 2:
                transactionList.display();
                System.out.println("=====================");
                System.out.print("Masukkan Nama Transaksi yang Akan di Hapus: ");
                String namaTransaksi = scanner.nextLine();
                transactionList.remove(transactionList.searchByName(namaTransaksi));
            case 3:
                transactionList.sortByIncome();
                transactionList.display();
            default:
                System.out.println("Pilihan anda tidak ada");
                scanner.close();
                break;
        }
    }
}
/*
 * Kode ini adalah implementasi dari sebuah program yang mengelola
 * operasi-operasi terkait bisnis pada suatu kios. Program ini menggunakan
 * struktur menu yang dapat berpindah-pindah antara tiga menu utama: "Kasir,"
 * "Manajemen Item Kios," dan "Keuangan Kios." User dapat memilih operasi yang
 * ingin dilakukan dalam masing-masing menu dengan memasukkan angka yang sesuai.
 * 
 * Pada menu "Kasir," user dapat memasukkan pembelian barang, yang akan
 * menghasilkan transaksi keuangan yang direkam. User juga dapat membatalkan
 * pembelian.
 * 
 * Pada menu "Manajemen Item Kios," user dapat mengelola daftar barang yang
 * tersedia di kios, termasuk menambahkan barang baru, mengubah stok barang, dan
 * menghapus barang dari daftar.
 * 
 * Pada menu "Keuangan Kios," user dapat melihat dan mengelola transaksi
 * keuangan yang telah terjadi di kios, termasuk menampilkan transaksi,
 * menghapus transaksi, dan mengurutkan transaksi berdasarkan pendapatan.
 * 
 * Dalam implementasi ini, terdapat struktur data seperti linked list yang
 * digunakan untuk mengorganisir data, seperti daftar barang, transaksi, dan
 * lainnya. Kode ini juga menggunakan objek dari kelas "Finance" dan "Cashier"
 * untuk mengelola informasi keuangan dan transaksi pembelian.
 * 
 * Selain itu, kode ini juga memberikan kontrol terhadap stok dan harga barang
 * serta mencatat transaksi yang berhubungan dengan barang-barang tersebut. User
 * dapat melakukan operasi-operasi seperti menambah atau mengurangi stok barang,
 * menginput data barang baru, serta melihat detail barang tertentu.
 * 
 * Kode ini mengorganisir menu-menu dan aksi-aksi yang terkait dalam tiga metode
 * terpisah: "cashierMenu," "managementItemKios," dan "keuanganKios." Ini
 * memisahkan logika bisnis dari tampilan menu, yang diatur dalam metode
 * "displayMenu."
 * 
 * Penting untuk memastikan bahwa kode ini bekerja dengan baik dan telah diuji
 * dengan baik untuk mengelola data dan transaksi bisnis pada kios. Kode ini
 * juga memanfaatkan struktur data dan objek kelas untuk mencapai fungsionalitas
 * yang diinginkan.
 */