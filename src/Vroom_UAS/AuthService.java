package Vroom_UAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 *
 * @author arg
 */
public class AuthService {
    //atribut/variabel constant
    private final ArrayList<User> userList = new ArrayList<>();

    //default constructor
    public AuthService() {
        // Daftar user diset dari awal menggunakan array
        userList.add(new User("id", "Admin", "admin", "admin123", "Admin"));
        userList.add(new User("id", "Staff", "staff", "staff123", "Staff"));
    }

    // Method untuk validasi login
    public User login(String username, String password) {
        for (User u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u; // Login berhasil, return objek user
            }
        }
        return null; // Gagal login
}
}
