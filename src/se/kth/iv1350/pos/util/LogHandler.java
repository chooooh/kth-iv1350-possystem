package se.kth.iv1350.pos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * This class logs all exceptions
 */
public class LogHandler {
    private static final String FILE_NAME = "log.txt";
    private PrintWriter file;

    public LogHandler() throws IOException {
        this.file = new PrintWriter(new FileWriter(FILE_NAME), true);
    }

    /**
     * Writes into file about which exception occured
     * @param e The exception that occured.
     */
    public void logException(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(new Date().toString());
        sb.append(", Following exception was thrown: ");
        sb.append(e.getMessage());
        file.println(sb);
        e.printStackTrace(file);
    }
}
