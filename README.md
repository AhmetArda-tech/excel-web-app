# Öğrenci Net Sıralama ve Analiz Sistemi (Excel Web Servisi)

Bu proje, belirli bir şablondaki (Ayşeabla Okulları sınav formatı) öğrenci sınav sonuçlarını içeren ham Excel dosyalarını işleyerek, verileri temizleyen ve öğrencileri toplam netlerine göre sıralayıp yepyeni bir rapor halinde sunan bir **Spring Boot** web uygulamasıdır.

## 🚀 Özellikler

* **Veri Temizleme (Data Cleansing):** Excel'deki sınıf ortalamaları ("5A") veya "Tüm Öğrenciler" gibi geçersiz (kirli) satırları algılar ve otomatik olarak filtreleyerek sıralamayı bozmalarını engeller.
* **Detaylı Branş Analizi:** Ham veriler içinden sadece toplam neti değil; Matematik, Fen Bilimleri, Türkçe, Sosyal Bilgiler, DKAB ve İngilizce netlerini de ayrıştırarak yeni rapora dinamik olarak ekler.
* **Akıllı Sıralama:** Öğrencileri toplam net puanlarına göre büyükten küçüğe doğru (descending) sıralar.
* **Kullanıcı Dostu Web Arayüzü:** Karmaşık terminal komutlarına gerek kalmadan, web tarayıcısı üzerinden tek tıkla dosya yükleme ve anında indirme imkanı sunar.
* **RAM Üzerinde İşlem (In-Memory Processing):** Yüklenen dosyalar sunucu diskine kaydedilmeden doğrudan bellek (RAM) üzerinde `byte[]` akışlarıyla işlenir, bu sayede yüksek performans ve güvenlik sağlanır.

## 🛠️ Kullanılan Teknolojiler

* **Backend:** Java 21, Spring Boot
* **Veri İşleme:** Apache POI (OOXML)
* **Frontend:** HTML5, CSS3 
* **Bağımlılık Yönetimi / Paketleme:** Maven

