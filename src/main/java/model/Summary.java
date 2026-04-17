package model;

import java.util.HashMap;
import java.util.Map;

public class Summary {

    private final Map<String, Integer> movedPerCategory = new HashMap<>();
    private int skipped = 0;
    private int errors = 0;


    public void incrementCategory(String category) {
        movedPerCategory.put(category, movedPerCategory.getOrDefault(category, 0) + 1);
    }

    public void incrementSkipped() {
        skipped++;
    }

    public void incrementErrors() {
        errors++;
    }

    public void printReport() {
        System.out.println("\n--- Organizing Summary ---");
        System.out.println("Moved:");
        for (Map.Entry<String, Integer> entry : movedPerCategory.entrySet()) {
            System.out.printf("  %s: %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("Skipped: " + skipped);
        System.out.println("Errors: " + errors);
    }
}
