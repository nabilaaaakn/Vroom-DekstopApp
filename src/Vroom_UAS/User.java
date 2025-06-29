package Vroom_UAS;

public class User {
    private String id; //local variable
    private String nama;
    private String username;
    private String password;
    private final String type; //constant variable

    // Constructor untuk inisialisasi data user
    public User(String id, String nama, String username, String password, String type) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    // Getter dan setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }
    
    public String getID() { 
        return id; 
    
    }
    
    public void setID(String ID) {
        this.id = ID;
    }

    
}
