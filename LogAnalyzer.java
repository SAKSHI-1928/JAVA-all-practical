
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class LogAnalyzer {

    public static void main(String[] args) throws IOException {
        Path logDir = Paths.get("logs");
        Files.createDirectories(logDir);

        Path log1 = logDir.resolve("app.log");
        Path log2 = logDir.resolve("db.log");

        Files.write(log1, List.of(
                "INFO Application booted",
                "ERROR Failed to load configuration",
                "INFO Retrying configuration load"
        ));

        Files.write(log2, List.of(
                "INFO Database connected",
                "ERROR Connection timed out",
                "ERROR Transaction rolled back",
                "INFO Shutting down"
        ));

        String keyword = "ERROR";
        long totalLines = 0;
        long totalKeywordMatches = 0;

        List<Path> logFiles = List.of(log1, log2);

        System.out.println("=== File Details & Search ===");
        for (Path file : logFiles) {

            long sizeInBytes = Files.size(file);
            System.out.printf("File: %-10s | Size: %d bytes%n", file.getFileName(), sizeInBytes);

            try (Stream<String> lines = Files.lines(file)) {
                List<String> lineList = lines.toList();
                totalLines += lineList.size();

                long matches = lineList.stream()
                        .filter(line -> line.contains(keyword))
                        .count();
                totalKeywordMatches += matches;
            }
        }

        System.out.println("\n=== Summary Across All Log Files ===");
        System.out.println("Total lines read: " + totalLines);
        System.out.println("Total occurrences of '" + keyword + "': " + totalKeywordMatches);
    }
}
