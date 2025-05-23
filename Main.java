// Gelişmiş uçak bileti rezervasyon sistemi
// Java OOP kullanılarak geliştirilmiş konsol uygulaması

import java.util.*;
import java.io.*;

// Uçak sınıfı
class Airplane {
    String model;
    String marka;
    String seriNo;
    int koltukKapasitesi;
    boolean[] koltuklar; // true: dolu, false: boş

    public Airplane(String model, String marka, String seriNo, int koltukKapasitesi) {
        this.model = model;
        this.marka = marka;
        this.seriNo = seriNo;
        this.koltukKapasitesi = koltukKapasitesi;
        this.koltuklar = new boolean[koltukKapasitesi];
    }

    public int kalanKoltukSayisi() {
        int sayac = 0;
        for (boolean koltuk : koltuklar) {
            if (!koltuk) sayac++;
        }
        return sayac;
    }

    public boolean koltukMusaitMi(int no) {
        return !koltuklar[no];
    }

    public void koltuguRezerveEt(int no) {
        koltuklar[no] = true;
    }

    @Override
    public String toString() {
        return marka + " " + model + " (Seri No: " + seriNo + ", Kapasite: " + koltukKapasitesi + ")";
    }
}

// Lokasyon sınıfı
class Location {
    String ulke;
    String sehir;
    String havaalani;
    boolean aktif;

    public Location(String ulke, String sehir, String havaalani, boolean aktif) {
        this.ulke = ulke;
        this.sehir = sehir;
        this.havaalani = havaalani;
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return havaalani + " - " + sehir + ", " + ulke + (aktif ? " (Aktif)" : " (Pasif)");
    }
}

// Uçuş sınıfı
class Flight {
    Location nereden;
    Location nereye;
    String saat;
    Airplane ucak;

    public Flight(Location nereden, Location nereye, String saat, Airplane ucak) {
        this.nereden = nereden;
        this.nereye = nereye;
        this.saat = saat;
        this.ucak = ucak;
    }

    public int kalanKoltuk() {
        return ucak.kalanKoltukSayisi();
    }

    @Override
    public String toString() {
        return nereden.sehir + " -> " + nereye.sehir + " saat " + saat + ", Uçak: " + ucak.model +
                " (Kalan koltuk: " + kalanKoltuk() + ")";
    }
}

// Rezervasyon sınıfı
class Reservation {
    Flight ucus;
    String ad;
    String soyad;
    int yas;
    int koltukNo;

    public Reservation(Flight ucus, String ad, String soyad, int yas, int koltukNo) {
        this.ucus = ucus;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.koltukNo = koltukNo;
    }

    @Override
    public String toString() {
        return ad + " " + soyad + " (" + yas + ") - Uçuş: " + ucus.toString() + ", Koltuk No: " + (koltukNo + 1);
    }
}

// Ana uygulama sınıfı
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Flight> ucuslar = new ArrayList<>();
    static List<Reservation> rezervasyonlar = new ArrayList<>();

    public static void main(String[] args) {
        veriOlustur();
        while (true) {
            System.out.println("\n1. Uçuşları Listele\n2. Rezervasyon Yap\n3. Rezervasyonları Görüntüle\n4. Rezervasyonları Kaydet\n5. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();
            switch (secim) {
                case 1 -> ucuslariListele();
                case 2 -> rezervasyonYap();
                case 3 -> rezervasyonlariGoruntule();
                case 4 -> rezervasyonlariKaydet();
                case 5 -> System.exit(0);
                default -> System.out.println("Geçersiz seçim!");
            }
        }
    }

    public static void veriOlustur() {
        Airplane a1 = new Airplane("737", "Boeing", "SN1234", 10);
        Location l1 = new Location("Türkiye", "İstanbul", "IST", true);
        Location l2 = new Location("Almanya", "Berlin", "BER", true);
        ucuslar.add(new Flight(l1, l2, "10:00", a1));
        ucuslar.add(new Flight(l2, l1, "15:00", a1));
    }

    public static void ucuslariListele() {
        for (int i = 0; i < ucuslar.size(); i++) {
            System.out.println(i + ". " + ucuslar.get(i));
        }
    }

    public static void rezervasyonYap() {
        ucuslariListele();
        System.out.print("Uçuş numarasını seçiniz: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        Flight secilen = ucuslar.get(index);

        if (secilen.kalanKoltuk() <= 0) {
            System.out.println("Boş koltuk kalmamıştır!");
            return;
        }

        System.out.println("Boş koltuklar:");
        for (int i = 0; i < secilen.ucak.koltukKapasitesi; i++) {
            if (secilen.ucak.koltukMusaitMi(i)) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("Koltuk numarası seçiniz: ");
        int koltukNo = scanner.nextInt() - 1;
        scanner.nextLine();
        if (!secilen.ucak.koltukMusaitMi(koltukNo)) {
            System.out.println("Bu koltuk dolu! Rezervasyon iptal.");
            return;
        }

        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("Yaş: ");
        int yas = scanner.nextInt();

        secilen.ucak.koltuguRezerveEt(koltukNo);
        Reservation r = new Reservation(secilen, ad, soyad, yas, koltukNo);
        rezervasyonlar.add(r);
        System.out.println("Rezervasyon başarıyla oluşturuldu!");
    }

    public static void rezervasyonlariGoruntule() {
        for (Reservation r : rezervasyonlar) {
            System.out.println(r);
        }
    }

    public static void rezervasyonlariKaydet() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("rezervasyonlar.txt"))) {
            for (Reservation r : rezervasyonlar) {
                writer.println(r);
            }
            System.out.println("Rezervasyonlar 'rezervasyonlar.txt' dosyasına kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya kaydedilirken hata oluştu: " + e.getMessage());
        }
    }
}
