import java.util.Scanner;

class driver{
    public int no_sim;
    public boolean sim_truk;
    public boolean sim_bus;

    public driver(int no_sim, boolean sim_truk, boolean sim_bus) {
        this.no_sim = no_sim;
        this.sim_truk = sim_truk;
        this.sim_bus = sim_bus;
    }
}

class Penumpang {
    public String nama;

    public Penumpang(String nama) {
        this.nama = nama;
    }
}

class kendaraan{
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    public driver supir;
    private Penumpang [] penumpang;

    public kendaraan(String pn, String m, int max){
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;
        this.penumpang = new Penumpang[max];

        System.out.println("Kendaraan dengan plat nomor : " + this.platNomor);
        cekPenumpang();
    }

    public void cekPenumpang(){
        System.out.println("Penumpang saat ini: "+this.jumlahPenumpang);
        System.out.println("Daftar Penumpang:");
        for (Penumpang p : penumpang) {
            if (p != null) {
                System.out.println("- " + p.nama);
            }
        }
    }

    public void penumpangNaik(String nama){
        System.out.println("Penumpang " + nama + " ingin naik");
        if (this.jumlahPenumpang < this.maxPenumpang) {
            this.penumpang[this.jumlahPenumpang] = new Penumpang(nama);
            this.jumlahPenumpang++;
            System.out.println("Penumpang " + nama + " berhasil naik");
        } else {
            System.out.println("Maaf, penumpang melebihi kapasitas");
        }
        cekPenumpang();
    }

    public void penumpangTurun(String nama){
        boolean found = false;
        for (int i = 0; i < this.jumlahPenumpang; i++) {
            if (this.penumpang[i] != null && this.penumpang[i].nama.equals(nama)) {
                found = true;
                this.penumpang[i] = null;
                this.jumlahPenumpang--;
                System.out.println("Penumpang " + nama + " berhasil turun");
                break;
            }
        }
        if (!found) {
            System.out.println("Penumpang " + nama + " tidak ditemukan di dalam kendaraan");
        }
        cekPenumpang();
    }

    public void maju(){
        System.out.println(this.merk + " " + this.platNomor +" Maju");
    }

    public void mundur(){
        System.out.println(this.merk + " " + this.platNomor+ " Mundur");
    }

    public void belok(){
        System.out.println(this.merk + " " + this.platNomor+ " Belok");
    }

    public void berhenti(){
        System.out.println(this.merk + " " + this.platNomor+ " Berhenti");
    }

    public void showSIM(){
        System.out.println(this.supir.no_sim);
    }
    
}

class truk extends kendaraan{
    int kapasitasMuatan;
    public boolean sim_bus;

    public truk(String pn, String m, int max){
        super(pn, m, max);
    }

    public void setKapasitas(int kapasitas){
        this.kapasitasMuatan = kapasitas;
    }
    
    public void muatBarang(int berat, int kapasitasMuatan) {
        System.out.println("Muatan yang ingin dinaikan: " + berat + " kg");
        if (berat <= kapasitasMuatan) {
            System.out.println("Barang berhasil dimuat ke dalam truk.");
        } else {
            System.out.println("Kapasitas muatan truk tidak mencukupi. Silahkan turunkan muatan terlebih dahulu");
        }
    }
    public void setDriver(driver supir) {
        if (supir.sim_truk) {
            this.supir = supir;
            System.out.println("Driver memiliki SIM truk yang valid.");
        } else {
            System.out.println("Maaf, driver tidak memiliki SIM truk.");
        }
    
}
}

class bus extends kendaraan{
    boolean toiletDigunakan;
    public boolean sim_bus;
    public bus(String pn, String m, int max){
        super(pn, m, max);
        this.toiletDigunakan = false;
    }
    public void toiletDipakai() {
        toiletDigunakan=true;
        System.out.println("Toilet lagi dipakai");
    }

    public void toiletKosong() {
        toiletDigunakan=false;
        System.out.println("Toilet lagi kosong");
    }

    public void cekToilet() {
        if (toiletDigunakan) {
            System.out.println("Toilet sedang digunakan.");
        } else {
            System.out.println("Toilet sedang tidak digunakan.");
        }
    }
    
        public boolean setDriver(driver supir) {
            if (supir.sim_bus) {
                this.supir = supir;
                System.out.println("Driver memiliki SIM bus yang valid.");
            } else {
                System.out.println("Maaf, driver tidak memiliki SIM bus.");
            }
            return sim_bus;
        }

}

class motor extends kendaraan{
    int standar;
    public motor(String pn, String m, int max){
        super(pn, m, max);
    }
}
class penumpang {

}
public class tugas {
     public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int pilihan =0;
        int pilihanBus = 0;
        bus b1 = new bus("B 1234 YY","Mercedes", 20);
        
        /*truk t1 = new truk("N 1234 YY", "HINO", 3);
        t1.setKapasitas(500);
        System.out.println("Masukan berat barang yang akan dibawa : ");
        int berat = scanner.nextInt();
        t1.muatBarang(berat,500);*/

        driver b1Driver = new driver(1234,false,true);
        b1.setDriver(b1Driver);
        if (b1.sim_bus) {
            System.out.println("Program Berhenti.");
        }/*else if (!t1.sim_bus){
            System.out.println("Program Berhenti.");
        } */
        else {
            while (pilihan != 4) {
                System.out.println("Menu:");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Keluar");
        
                System.out.print("Pilih menu (masukkan angka): ");
                pilihan = scanner.nextInt();
        
                switch (pilihan) {
                    case 1:
                        System.out.println("Masukkan nama penumpang yang ingin naik:");
                        String namaNaik = scanner.next();
                        b1.penumpangNaik(namaNaik);
                        break;
                    case 2:
                        System.out.println("Masukkan nama penumpang yang ingin turun:");
                        String namaTurun = scanner.next();
                        b1.penumpangTurun(namaTurun);
                        break;
                    case 3:
                        b1.cekPenumpang();
                        break;
                    case 4:
                        System.out.println("Terima kasih. Program berhenti.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }
        }
            
            while (pilihanBus != 4){
                System.out.println("1. Gunakan Toilet");
                System.out.println("2. Keluar Toilet");
                System.out.println("3. Cek Toilet");
                System.out.println("4. Keluar menu");
                System.out.print("Pilih menu (masukkan angka): ");
                pilihanBus = scanner.nextInt();
        
                switch (pilihanBus){
                    case 1:
                        b1.toiletDipakai();
                        break;
                    case 2:
                        System.out.println("Keluar dari toilet");
                        b1.toiletKosong();
                        break;
                    case 3:
                        b1.cekToilet();
                        break;
                    case 4:
                        System.out.println("Terima kasih. Lanjutannya");
                        break;
                    default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }
    
            scanner.close();
        }
       

}

// rafie ramadhan al aziz zein
// 235150700111035
