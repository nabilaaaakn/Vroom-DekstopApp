package Vroom_UAS;


// Inheritance dari class Transaksi
public class Pengembalian extends Transaksi {
    private String tanggalPengembalian;

    public Pengembalian(String nama, String nik, String alamat, String noTelp, String email,
                        String noPolisi, String tglPinjam, String tglKembali,
                        int lamaPinjam, int hargaPerHari) {
        super(nama, nik, alamat, noTelp, email, noPolisi, tglPinjam, tglKembali, lamaPinjam, hargaPerHari);
        this.tanggalPengembalian = null;  
    }

    // Encapsulation ttg Tanggal Pengembalian
    // Getter berfungsi utk ngambil Tanggal Pengembalian
    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    // Setter berfungsi utk memanipulasi Tanggal Pengembalian
    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }
}
