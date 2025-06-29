package Vroom_UAS;

import java.util.ArrayList;
import java.util.List;

//interface
public class MobilManager implements MobilService {
    private static MobilManager instance; //static variable
    private final List<Mobil> daftarMobil; //encap

    private MobilManager() {
        daftarMobil = new ArrayList<>();
    }

    public static MobilManager getInstance() {
        if (instance == null) {
            instance = new MobilManager();
        }
        return instance;
    }

    @Override
    public void tambahMobil(Mobil mobil) {
        daftarMobil.add(mobil);
    }

    @Override
    public List<Mobil> getAllMobil() {
        return daftarMobil;
    }

    @Override
    public Mobil getMobilByNomorPolisi(String nopol) {
        for (Mobil m : daftarMobil) {
            if (m.getNomorPolisi().equalsIgnoreCase(nopol)) {
                return m;
            }
        }
        return null;
    }
}
