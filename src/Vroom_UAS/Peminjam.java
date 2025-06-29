package Vroom_UAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author arg
 */
public class Peminjam extends Member {
    public Peminjam(String nama, String nik, String alamat, String noTelp, String email) {
        super(nama, nik, alamat, noTelp, email);
    }

    @Override
    public String getIdentitas() {
        return "Peminjam: " + nama + "NIK: " + nik;
    }
}
