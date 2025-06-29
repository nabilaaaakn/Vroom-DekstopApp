package Vroom_UAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arg
 */
// class abstract untuk peminjam dan transaksi
public abstract class Member {
    public String nama; //global
    protected String nik; //instance variabel
    protected String alamat;
    protected String noTelp;
    protected String email;
    
    //parameterized constructor
    public Member(String nama, String nik, String alamat, String noTelp, String email) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
    }
  

    // Method abstrak 
    public abstract String getIdentitas();

}
