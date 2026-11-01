
import java.util.*;

public class wordfrequency {

    public static void main(String[] args) {
        String paragraph = "Java is powerful, Java is versatile. Java collections make Java coding easier and faster!";

        String[] words = paragraph.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("=== Word Frequency (Highest First) ===");
        System.out.printf("%-15s | %s%n", "Word", "Frequency");

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%-15s | %d%n", entry.getKey(), entry.getValue());
        }
    }
}
