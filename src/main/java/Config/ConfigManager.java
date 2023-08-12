package Config;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager {
    static Gson gson = new Gson();
    private static final Config configData;
    private static final Config testData;

    static {
        try {
            configData = gson.fromJson(Files.readString(Paths.get(".\\src\\test\\resources\\config_data.json")), Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Config getConfigData() {
        return configData;
    }

    static {
        try {
            testData = gson.fromJson(Files.readString(Paths.get(".\\src\\test\\resources\\test_data.json")), Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Config getTestData() {
        return testData;
    }
}
