✈️ Uçak Bileti Rezervasyon Sistemi (Java Konsol Uygulaması)
Bu proje, Java programlama dili ve Nesneye Dayalı Programlama (OOP) ilkeleri kullanılarak geliştirilmiş bir uçak bileti rezervasyon sistemidir. Uygulama, kullanıcıların uçuşları listelemesine, boş koltukları görerek rezervasyon yapmasına ve yapılan rezervasyonları dosyaya kaydetmesine olanak tanır.

🚀 Özellikler
Uçak bilgileri tanımlama ve koltuk kapasitesi takibi

Lokasyon (ülke, şehir, havaalanı) bilgileri

Uçuş oluşturma (nereden nereye, saat, uçak bilgisi)

Koltuk seçmeli rezervasyon yapma

Gerçek zamanlı boş koltuk görüntüleme

Yapılan rezervasyonları listeleme

Rezervasyonları .txt dosyasına kaydetme

🧩 Sınıf Yapısı
Airplane - Uçak
Model, marka, seri numarası, koltuk kapasitesi içerir.

Koltuk doluluk durumunu takip eder.

Location - Lokasyon
Ülke, şehir, havaalanı ve aktif/pasif bilgisi içerir.

Flight - Uçuş
Nereden, nereye, saat ve uçak bilgilerini içerir.

Kalan koltuk sayısını hesaplar.

Reservation - Rezervasyon
Uçuş bilgisi, yolcu adı-soyadı, yaş ve koltuk numarasını içerir.

🖥️ Kullanım
Projeyi Derlemek ve Çalıştırmak İçin
Aşağıdaki komutu kullanarak Main.java dosyasını derleyin:

bash
Kopyala
Düzenle
javac Main.java
Ardından uygulamayı çalıştırın:

bash
Kopyala
Düzenle
java Main
Konsol Menüleri
Uçuşları Listele: Tanımlı tüm uçuşları ve kalan koltuk sayılarını gösterir.

Rezervasyon Yap: Uçuş seçimi, boş koltuk seçimi ve yolcu bilgileri ile rezervasyon işlemi yapılır.

Rezervasyonları Görüntüle: Yapılmış tüm rezervasyonlar listelenir.

Rezervasyonları Kaydet: Tüm rezervasyonlar rezervasyonlar.txt dosyasına kaydedilir.

Çıkış: Uygulamadan çıkılır.

📝 Kayıtlı Dosyalar
rezervasyonlar.txt: Yapılan rezervasyonların saklandığı dosyadır. Her satırda bir rezervasyon bilgisi yer alır.

📌 Notlar
Uygulama sadece 1 uçak ve 2 lokasyon üzerinden örnek veri ile çalışmaktadır.

İsterseniz veriOlustur() metodunu genişleterek daha fazla uçak ve uçuş tanımı ekleyebilirsiniz.

Koltuk numaraları 1’den başlar.

👨‍💻 Geliştirici
Bu proje bir final ödevi kapsamında geliştirilmiştir. Daha fazla geliştirme ve iyileştirme için katkıya açıktır.