package Config;

public class Config {
    private String browser;
    private String mainPageUrl;
    private long defaultWait;
    private int randomTextLength;
    private int expectedNumberOfWindows;

    public String getBrowser() {
        return browser;
    }

    public String getUrl() {
        return mainPageUrl;
    }

    public long getDefaultWait() {
        return defaultWait;
    }

    public int getRandomTextLength() {
        return randomTextLength;
    }
    public int getExpectedNumberOfWindows() {
        return expectedNumberOfWindows;
    }
}
