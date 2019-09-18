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
	https://github.com/raniprtw/tutorial-app/issues/1#issuecomment-532763377