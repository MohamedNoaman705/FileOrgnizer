package orgnizer;

import java.util.HashMap;
import java.util.Map;

public class CategoryResolver {

    private final Map<String, String> extensionToCategory;

    public CategoryResolver(){
        extensionToCategory = new HashMap<>();

        extensionToCategory.put("jpg", "IMAGES");
        extensionToCategory.put("jpeg", "IMAGES");
        extensionToCategory.put("png", "IMAGES");
        extensionToCategory.put("gif", "IMAGES");
        extensionToCategory.put("webp", "IMAGES");
        extensionToCategory.put("pdf", "DOCUMENTS");
        extensionToCategory.put("doc", "DOCUMENTS");
        extensionToCategory.put("docx", "DOCUMENTS");
        extensionToCategory.put("txt", "DOCUMENTS");
        extensionToCategory.put("md", "DOCUMENTS");
        extensionToCategory.put("xls", "SPREADSHEETS");
        extensionToCategory.put("xlsx", "SPREADSHEETS");
        extensionToCategory.put("csv", "SPREADSHEETS");
        extensionToCategory.put("zip", "ARCHIVES");
        extensionToCategory.put("rar", "ARCHIVES");
        extensionToCategory.put("7z", "ARCHIVES");
        extensionToCategory.put("mp3", "AUDIO");
        extensionToCategory.put("wav", "AUDIO");
        extensionToCategory.put("flac", "AUDIO");
        extensionToCategory.put("m4a", "AUDIO");
        extensionToCategory.put("mp4", "VIDEOS");
        extensionToCategory.put("mkv", "VIDEOS");
        extensionToCategory.put("mov", "VIDEOS");
        extensionToCategory.put("avi", "VIDEOS");
        extensionToCategory.put("java", "CODE");
        extensionToCategory.put("py", "CODE");
        extensionToCategory.put("js", "CODE");
        extensionToCategory.put("ts", "CODE");
        extensionToCategory.put("html", "CODE");
        extensionToCategory.put("css", "CODE");
        extensionToCategory.put("json", "CODE");
        extensionToCategory.put("xml", "CODE");
    }


    public String resolveCategory(String extension) {
        if (extension == null)
            return "OTHERS";
        return extensionToCategory.getOrDefault(extension.toLowerCase(), "OTHERS");
    }
}
