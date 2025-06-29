/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vroom_UAS;

/**
 *
 * @author HP
 */

public class Mobil {
    private String id; //local variable
    private String merek;
    private String tipe;
    private int tahun;
    private String nomorPolisi;
    private double harga;
    private String status;

    public Mobil(String id, String merek, String tipe, int tahun, String nomorPolisi, double harga, String status) {
        this.id = id;
        this.merek = merek;
        this.tipe = tipe;
        this.tahun = tahun;
        this.nomorPolisi = nomorPolisi;
        this.harga = harga;
        this.status = status;
    }

    // Getter
    public String getId() { 
        return id; 
    }
    public String getMerek() { 
        return merek; 
    }
    public String getTipe() { 
        return tipe; 
    }
    public int getTahun() { 
        return tahun; 
    }
    public String getNomorPolisi() {
        return nomorPolisi; 
    }
    public double getHarga() {
        return harga; 
    }
    public String getStatus() {
        return status; 
    }
}

