
---
# Vroom - Aplikasi Manajemen Penyewaan Mobil 🚗

**Vroom** adalah aplikasi desktop sederhana untuk manajemen penyewaan mobil yang dikembangkan menggunakan **Java** dan menerapkan konsep **Object-Oriented Programming (OOP)**. Aplikasi ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Berorientasi Objek (OOP)**.

---

## 🧠 Konsep OOP yang Diterapkan

- Class & Packages
- Variabel & Metode
- Access Modifiers
- Constructors
- Inheritance
- Encapsulation
- Polymorphism
- Abstraction

---

## 🧰 Teknologi yang Digunakan

- Java (NetBeans IDE)
- Java Swing (GUI dengan JFrame)
- JCalendar (untuk memilih tanggal)
- Manual Array dan JTable (karena belum semua bagian connect database)

---

## 🗂️ Fitur Aplikasi

### 👥 Login
- Terdapat dua role: **Admin** dan **Staff**
- Admin memiliki akses penuh termasuk menambah user
- Staff memiliki akses terbatas ke fitur transaksi dan pengembalian

### 🏠 Menu Utama
- Tampilan menu berbeda untuk Admin dan Staff

### 🚘 Form Tambah Mobil
- Menambahkan data mobil menggunakan array manual (dan sebagian sudah terhubung ke database dengan fitur insert)

### 👤 Form Tambah User
- Admin dapat menambahkan akun user baru (sudah connect ke database)

### 📝 Form Peminjaman Mobil
- Input data peminjam

### 💳 Form Transaksi Mobil
- Data peminjam otomatis muncul dari form sebelumnya
- Pilih mobil dan lama pinjam
- Hitung otomatis biaya berdasarkan hari

### 🔁 Form Pengembalian Mobil
- Klik nama untuk mengembalikan mobil
- Data otomatis hilang dari tabel setelah pengembalian

---

## 📌 Alur Penggunaan Aplikasi

1. **Run project** di NetBeans (rekomendasi)
2. **Login** sebagai Admin atau Staff
3. **Tambahkan mobil terlebih dahulu**
4. Masuk ke **menu peminjaman**, input data diri
5. Setelah klik “Next”, data otomatis masuk ke **form transaksi**
6. Pilih mobil, durasi pinjam, dan klik tombol **Hitung**
7. Tambah transaksi (tampil di tabel bawah)
8. Untuk mengembalikan mobil, masuk ke **form pengembalian**, pilih nama, lalu klik “Kembalikan”

> **Catatan:**  
> - Sebagian fitur (seperti Tambah Mobil & Tambah User) sudah connect ke database (hanya fitur insert/create).  
> - Data yang menggunakan array akan tetap tampil selama program berjalan, sedangkan data non-array hanya tersimpan sementara.

---

## 👨‍💻 Struktur Kode

Kode dibagi menjadi dua bagian utama:
- **Kode OOP** (class Java biasa)
- **Kode GUI** (form JFrame)

---

## 👥 Tim Pengembang

| Nama                        | Kontribusi                                                                 |
|----------------------------|---------------------------------------------------------------------------|
| **Nabila Khairun Nisa**     | Form Home Login, Menu (Admin & Staff), AuthService, Member, User, Mobil |
| **Hafizhah Dea Az Zahrah**  | Form Peminjaman, Peminjam                                                |
| **Rara Kholilah**           | Form Transaksi, Transaksi                                                |
| **Rheva Alfarera**          | Form Pengembalian, Pengembalian                                          |
| **Baptista Yohana Vallen**  | Form Tambah Mobil & Tambah User, Mobil Manager, Mobil Service, User Manager, User Service |

---

## Catatan

Aplikasi ini masih dalam tahap pengembangan dan belum sempurna. Beberapa fitur masih menggunakan array karena belum sepenuhnya terhubung ke database.

---

## Cara Menjalankan

1. Buka project di **NetBeans**
2. Pastikan sudah menginstal plugin **JCalendar**
3. Jalankan file utama (form login)
4. Username dan password sesuai yang ditentukan di `AuthService.java`
