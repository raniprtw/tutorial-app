# Tutorial APAP
## Authors
* Maharani Eka Pratiwi - 1706043626 - B

1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?   
Issue tracker adalah alat yang digunakan secara internal pada Google untuk melakukan track pada bugs dan requests pada produk development.
Issue tracker dapat digunakan untuk menyelesaikan masalah bug pada development ​

2. Apa perbedaan dari merge dan merge --squash?
Merge squash adalah opsi menggabungkan di Git yang akan menghasilkan commit gabungan dengan hanya satu parent. 
File-file tersebut digabungkan persis seperti yang akan ada dalam gabungan normal, tetapi metadata commit diubah untuk menunjukkan
hanya satu dari parent yang commit. Hasilnya adalah commit tunggal pada cabang target dengan semua perubahan dari penggabungan normal.
Sedangkan merge yang basic merging dengan 2 parent

3. Apa itu library & dependency?  
Library: Kumpulan kode yang sebelumnya telah ditulis, kemudian dapat dipanggil ketika kita menjalankan kode kita
Dependecy: Dependency pada OOP artinya setiap perubahan pada base class juga akan mengubah derived classnya

4. Apa itu Maven? Mengapa kita perlu menggunakan Maven? 
Maven adalah sebuah project management dan comprehension tool. Maven perlu digunakan untuk melakukan built, reporting, dan 
documentation terhadap sebuah projek

5. Apa alternatif dari Maven? Gradle, Apache Ant, Team city, dll

## Tutorial 2
 #### Controller
1. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
	http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022

	**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
	Yang terjadi adalah error, karena template untuk add-restoran belum ada

 #### View Template
2. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
	http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
	
	**Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
	Yang terjadi adalah error, karena tidak ada parameter alamat, padahal required. 

3. Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?
	http://localhost:8080/restoran/view/id-restoran/1

4. Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? 
	https://drive.google.com/file/d/1PCnwWfxjZrHGv3Ou81d3aklzu6Z1OhxO/view?usp=sharing
	
## Tutorial 3
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari
method tersebut?
Kegunaan dari method tersebut adalah mengembalikan selurus menu dari restoran yang diminta berdasarkan id-restoran

2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?
yang pertama itu dia GET yang kedua dia POST. yang GET mengambil data dari server dan yang POST memasukkannya ke dalam DB

3. Jelaskan apa kegunaan dari JPA Repository?
Untuk memasukkan data java ke dalam realtional database dan juga untuk memanipulasi data (CURD) yang menggunakan JPA 

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?
Ada di MenuController. Jadi di membuat menu, lalu dicari restoran mana yang id nya sama. ketika ketemu, restoran tersebut akan di-set
sebagai restoran menu tersebut

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
-FetchType.LAZY digunakan untuk relasi one to many. FetchType.LAZY memberitahu kepada Hibernate untuk mengambil entities yang berhubungan
dengan database itu saja. Jadi FetchType.LAZY hanya akan mendapatkan data dari suatu objeect atau tabel yang diminta tanpa mengambil 
data-data dari seetiap tabel yang berlasi dengannya
-CascadeType.All berarti dia akan melakukan semua action (PERSIST, REMOVE, REFRESH, MERGE, DETACH) kepada entity yang berhubungan tersebut.
-FetchType.EAGER untuk nge-load menu with the rest of the fields(eagerly)

## Tutorial 4
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2
Yang saya pelajari dari latihan nomor 2 adalah penggunaan '(brand)' yang bisa kita gunakan untuk menyesuaikan title navbar
pada setiap halamannya dengan cara menabmahkan '(brand='Title Halaman')'
2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
menyelesaikan latihan nomor 3

3. Jelaskan perbedaan th:include dan th:replace
Dengan th:include kita bisa meng-include semua konten dari fragment ke host tag-nya sedangkan th:replace akan
membuat fragments menggantikan host tag-nya. Hal ini dapat membantu kiat dalam grouping fragments ke satu atau lebih halaman
4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
th:object itu untuk menentukan dan meletakkan object apa yang akan dipakai sama di form nya