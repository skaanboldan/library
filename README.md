# Project DOC.
**Uyarı:** proje 9191 portunda ayağa kalkmaktadır.

### Uygulamada olması gereken nesneler
:heavy_check_mark: Kullanıcı 
:heavy_check_mark: Kitap
:heavy_check_mark: Transaction
:heavy_check_mark: Kara Liste
###  Uygulamada olması gereken fonksiyonlar
:heavy_check_mark: Kullanıcı oluşturma
:heavy_check_mark: Kitap ekleme
:heavy_check_mark: Kitap adeti sorgulama
:heavy_check_mark: Kitap ödünç alma ve teslim etme
:heavy_check_mark: İşlem tarihçesi sorgulama
### Uygulamada olması gereken özellikler
:heavy_check_mark: İlgili nesne, tablo ve fonksiyonların oluşturulması
:heavy_check_mark: Rest API üzerinden kullanıcı, transaction ve kitap bilgisi için CRUD işlemlerinin yapılması ve örnek kayıtların eklenmesi
:heavy_check_mark: Bir kitap için aynı anda birden fazla transaction ile kitabı ödünç alma ve teslim etme işlemi yapılabilir olmalıdır.
:heavy_check_mark: Veritabanı sorgularını en aza indirmek (cache kullanımı)
### Notlar
:heavy_check_mark: Geliştirilecek uygulamada veritabanı olarak PostgreSQL kullanılacaktır, bilgiler veritabanında tutulacaktır.
:heavy_check_mark: pom.xml, application.properties ve README.md dosyalarının eklenmesi.
:heavy_check_mark: Uygulamanın docker container üzerinde çalışması sağlanacaktır (“dockercompose up“ komutu ile ayağa kalkması)


### API Bilgileri

# Proje Kütüphane API Dökümantasyonu

# Kitap Yönetimi

### Yeni Kitap Ekleme

Yeni bir kitap eklemek için bu endpoint kullanılır.

- **URL**

  `/book/add`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında eklenmek istenen kitabın bilgileri.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kitap eklediğinde eklenen kitabın detaylarını içeren bir JSON döner.

### Birden Fazla Kitap Ekleme

Birden fazla kitap eklemek için bu endpoint kullanılır.

- **URL**

  `/book/add/multiple`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında eklenmek istenen kitapların listesi.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kitaplar eklediğinde eklenen kitapların detaylarını içeren bir JSON liste döner.

### Tüm Kitapları Listeleme

Tüm kitapları listelemek için bu endpoint kullanılır. Bu endpoint, sonuçları önbelleğe alır.

- **URL**

  `/book/list`

- **Method:**

  `GET`

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde tüm kitaplar listelendiğinde, tüm kitapların detaylarını içeren bir JSON liste döner.

### Belirli Bir Kitabı ID'ye Göre Getirme

Belirli bir kitabı ID'ye göre getirmek için bu endpoint kullanılır. Bu endpoint, sonucu önbelleğe alır.

- **URL**

  `/book/id/{id}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  `id` - Getirilmek istenen kitabın benzersiz kimliği.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirtilen ID'ye sahip kitap bulunduğunda, kitabın detaylarını içeren bir JSON döner.

### Kitap Sayısını Sayma

Mevcut kitap sayısını saymak için bu endpoint kullanılır.

- **URL**

  `/book/count`

- **Method:**

  `GET`

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Kitap sayısı başarıyla sayıldığında, kitap sayısını içeren bir JSON döner.

# Kullanıcı Yönetimi

### Kullanıcı Ekleme

Yeni bir kullanıcı eklemek için bu endpoint kullanılır.

- **URL**

  `/user/add`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında eklenmek istenen kullanıcının bilgileri.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kullanıcı eklediğinde eklenen kullanıcının detaylarını içeren bir JSON döner.

### Birden Fazla Kullanıcı Ekleme

Birden fazla kullanıcı eklemek için bu endpoint kullanılır.

- **URL**

  `/user/add/multiple`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında eklenmek istenen kullanıcıların listesi.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kullanıcılar eklediğinde eklenen kullanıcıların detaylarını içeren bir JSON liste döner.

### Kullanıcı Sayısını Alma

Mevcut kullanıcı sayısını almak için bu endpoint kullanılır.

- **URL**

  `/user/count`

- **Method:**

  `GET`

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Kullanıcı sayısı başarıyla alındığında, kullanıcı sayısını içeren bir JSON döner.

### Tüm Kullanıcıları Getirme

Tüm kullanıcıları getirmek için bu endpoint kullanılır.

- **URL**

  `/user/list`

- **Method:**

  `GET`

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Tüm kullanıcılar başarıyla getirildiğinde, tüm kullanıcıların detaylarını içeren bir JSON liste döner.

### Belirli Bir ID'ye Sahip Kullanıcıyı Getirme

Belirli bir ID'ye sahip kullanıcıyı getirmek için bu endpoint kullanılır.

- **URL**

  `/user/id/{id}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  `id` - Getirilmek istenen kullanıcının benzersiz kimliği.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirtilen ID'ye sahip kullanıcı bulunduğunda, kullanıcının detaylarını içeren bir JSON döner.

### İsimle Kullanıcıyı Getirme

İsme göre kullanıcıyı getirmek için bu endpoint kullanılır.

- **URL**

  `/user/name/{firstName}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  `firstName` - Getirilmek istenen kullanıcının adı.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirtilen isimle eşleşen kullanıcı bulunduğunda, kullanıcının detaylarını içeren bir JSON döner.

### Kullanıcı Güncelleme

Mevcut bir kullanıcıyı güncellemek için bu endpoint kullanılır.

- **URL**

  `/user/update`

- **Method:**

  `PUT`

- **Request Body:**

  JSON formatında güncellenmek istenen kullanıcının bilgileri.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Kullanıcı başarıyla güncellendiğinde, güncellenen kullanıcının detaylarını içeren bir JSON döner.

### Kullanıcı Silme

Mevcut bir kullanıcıyı silmek için bu endpoint kullanılır.

- **URL**

  `/user/delete/{id}`

- **Method:**

  `DELETE`

- **Path Parametreleri:**

  `id` - Silinmek istenen kullanıcının benzersiz kimliği.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Kullanıcı başarıyla silindiğinde, bir başarı mesajı döner.

## Hata Durumları

- **500 Internal Server Error**

  - İşlem sırasında bir hata oluştuğunda döner.

  Örnek Hata Yanıtı:

  ```json
  {
    "error": "An error occurred while processing your request."
  }


# İşlem Yönetimi

### Tüm İşlemleri Listeleme

Tüm işlemleri listelemek için bu endpoint kullanılır.

- **URL**

  `/transactions/list/all`

- **Method:**

  `GET`

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde tüm işlemler listelendiğinde, tüm işlemlerin detaylarını içeren bir JSON liste döner.

### Başlangıç Tarihinden İtibaren İşlemleri Listeleme

Belirtilen başlangıç tarihinden itibaren işlemleri listelemek için bu endpoint kullanılır.

- **URL**

  `/transaction/list/{startDate}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  `startDate` - Başlangıç tarihi

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirtilen başlangıç tarihinden itibaren olan işlemler listelendiğinde, işlemlerin detaylarını içeren bir JSON liste döner.

### Belirli Bir Tarih Aralığındaki İşlemleri Listeleme

Belirli bir başlangıç ve bitiş tarihleri arasındaki işlemleri listelemek için bu endpoint kullanılır.

- **URL**

  `/transaction/list/{startDate}/{endDate}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  - `startDate` - Başlangıç tarihi
  - `endDate` - Bitiş tarihi

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirtilen tarih aralığındaki işlemler listelendiğinde, işlemlerin detaylarını içeren bir JSON liste döner.

### Belirli Bir Kullanıcıya Ait İşlemleri Listeleme

Belirli bir kullanıcıya ait işlemleri listelemek için bu endpoint kullanılır.

- **URL**

  `/transaction/list/userId/{userId}`

- **Method:**

  `GET`

- **Path Parametreleri:**

  `userId` - Kullanıcı kimliği

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Belirli bir kullanıcıya ait işlemler listelendiğinde, işlemlerin detaylarını içeren bir JSON liste döner.

## Hata Durumları

- **500 Internal Server Error**

  - İşlem sırasında bir hata oluştuğunda döner.

  Örnek Hata Yanıtı:

  ```json
  {
    "error": "An error occurred while processing your request."
  }

# Kitap Ödünç Alma İşlemleri

### Kitap Ödünç Alma

Kullanıcıya bir kitabı ödünç almak için bu endpoint kullanılır.

- **URL**

  `/book/borrow`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında ödünç alınacak kitabın ve kullanıcının bilgileri.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kitap ödünç alındığında "Succesfully borrowed..." mesajı döner.
  
  - `403 Forbidden` - Kullanıcı kara listede olduğunda "Cant borrow this book, user in blacklist!!" mesajı döner.

### Ödünç Alınan Kitabı Geri Verme

Kullanıcı tarafından ödünç alınan bir kitabı geri vermek için bu endpoint kullanılır.

- **URL**

  `/book/return`

- **Method:**

  `POST`

- **Request Body:**

  JSON formatında geri verilecek kitabın ve kullanıcının bilgileri.

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kitap geri verildiğinde "Succesfully returned..." mesajı döner.

## Hata Durumları

- **403 Forbidden**

  - Kullanıcı kara listede olduğunda veya belirtilen kitap ödünç alınamadığında döner.

  Örnek Hata Yanıtı:

  ```json
  {
    "error": "Cant borrow this book, user in blacklist!!"
  }

# Kara Liste Yönetimi

### Kullanıcıyı Kara Listeye Ekleme

Kullanıcıyı kara listeye almak için bu endpoint kullanılır.

- **URL**

  `/blacklist/add/{userId}`

- **Method:**

  `POST`

- **URL Parametreleri:**

  `userId` - Kara listeye alınacak kullanıcının benzersiz kimliği

- **Başarı Durumu ve Dönen Veri:**

  - `200 OK` - Başarılı bir şekilde kullanıcı kara listeye alındığında kara liste detaylarını içeren bir JSON döner.

- **Örnek Kullanım:**

  ```bash
  curl -X POST http://example.com/blacklist/add/1234

{
  "userId": 1234,
  "addedAt": "2024-05-02T12:00:00Z"
}

Hata Durumları
404 Not Found
Belirtilen kullanıcı bulunamadığında veya geçersiz bir URL parametresi girildiğinde döner.
Örnek Hata Yanıtı:
{
  "error": "Kullanıcı bulunamadı"
}
