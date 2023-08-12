package Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerManager {
    private final Logger logger = LoggerFactory.getLogger(LoggerManager.class);

    public void info(String name) {
        logger.info("Info: {}", name);
    }

    public void debug(String name) {
        logger.debug("Debug: {}", name);
    }

    public void warning(String name) {
        logger.warn("Warning: {}", name);
    }
}
