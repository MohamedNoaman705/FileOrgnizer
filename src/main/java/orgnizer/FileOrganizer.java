package orgnizer;

import model.Summary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileOrganizer {
    private final CategoryResolver resolver;
    private final Summary summary;

    public FileOrganizer(CategoryResolver resolver, Summary summary) {
        this.resolver = resolver;
        this.summary = summary;
    }

    public void organize(Path sourceDir) {
        if (!Files.isDirectory(sourceDir)) {
            System.err.println("Provided path is not a directory: " + sourceDir);
            return;
        }

        try (Stream<Path> paths = Files.list(sourceDir)) {
            paths.forEach(this::processFile);
        } catch (IOException e) {
            System.err.println("Could not list files in directory: " + e.getMessage());
        }
    }

    private void processFile(Path file) {
        try {
            if (Files.isDirectory(file)) {
                summary.incrementSkipped();
                return;
            }
            String filename = file.getFileName().toString();
            String ext = getExtension(filename);
            String category = resolver.resolveCategory(ext);
            Path targetDir = file.getParent().resolve(category);
            if (!Files.exists(targetDir)) {
                Files.createDirectory(targetDir);
            }
            Path targetFile = targetDir.resolve(filename);
            if (Files.exists(targetFile)) {
                summary.incrementSkipped();
                System.out.println("Skipped (already exists): " + filename);
                return;
            }
            Files.move(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
            summary.incrementCategory(category);
            System.out.println("Moved: " + filename + " -> " + category + "/");
        } catch (Exception e) {
            summary.incrementErrors();
            System.err.println("Error moving file: " + file + " - " + e.getMessage());
        }
    }

    private String getExtension(String filename) {
        int idx = filename.lastIndexOf(".");
        if (idx != -1 && idx < filename.length() - 1) {
            return filename.substring(idx + 1);
        }
        return null;
    }
}
