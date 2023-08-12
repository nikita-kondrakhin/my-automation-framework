package User;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class UserManager {
    private List<User> users;

    public UserManager() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(".\\src\\test\\resources\\user_data.json")) {
            users = Arrays.asList(gson.fromJson(reader, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        return users;
    }
}