package solid_principles.srp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Responsible ONLY for ensuring that the log file exists
class LogFileInitializer {
    public static void initialize(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}

// Responsible ONLY for writing log messages
class FileLogger {
    private final String path;

    public FileLogger(String path) {
        this.path = path;
    }

    public void log(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class SRP {
    static void main(String[] args) {
        try {
            // Separate responsibility: initializing file
            String path = "log.txt";
            LogFileInitializer.initialize(path);

            // Separate responsibility: logging messages
            FileLogger logger = new FileLogger(path);
            logger.log("Application Started...");
            logger.log("Processing data...");
            logger.log("Application Ended.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
