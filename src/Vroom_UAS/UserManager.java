package Vroom_UAS;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {

    private static final List<User> userList = new ArrayList<>();

    @Override
    public void tambahUser(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
