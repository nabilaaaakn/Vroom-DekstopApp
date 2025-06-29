package Vroom_UAS;

import java.util.List;

public interface MobilService {
    void tambahMobil(Mobil mobil);
    List<Mobil> getAllMobil();
    Mobil getMobilByNomorPolisi(String nopol);  
}


