/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vroom_UAS;

/**
 *
 * @author arg
 */
public class Transaksi extends Member {
    private String noPolisi;
    public String tglPinjam;
    public String tglKembali;
    private int lamaPinjam;
    private int hargaPerHari;
    private int total;

    public Transaksi(String nama, String nik, String alamat, String noTelp, String email,
                     String noPolisi, String tglPinjam, String tglKembali, int lamaPinjam, int hargaPerHari) {
        super(nama, nik, alamat, noTelp, email);
        this.noPolisi = noPolisi;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.lamaPinjam = lamaPinjam;
        this.hargaPerHari = hargaPerHari;
        this.total = hargaPerHari * lamaPinjam;
    }

    // Getter
    public String getNoPolisi() { 
        return noPolisi; 
    }
    public int getLamaPinjam() { 
        return lamaPinjam; 
    }
    public int getHargaPerHari() { 
        return hargaPerHari; 
    }
    public int getTotal() { 
        return total; 
    }

    @Override
    public String getIdentitas() {
        return "Transaksi atas nama:" + nama + "Total: Rp" + total;
    }
}
