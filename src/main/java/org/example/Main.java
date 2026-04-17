package org.example;

import model.Summary;
import orgnizer.CategoryResolver;
import orgnizer.FileOrganizer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("=== Java File Organizer CLI ===");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path to organize: ");
        String pathStr = scanner.nextLine().trim();
        Path sourceDir = Paths.get(pathStr);

        CategoryResolver resolver = new CategoryResolver();
        Summary summary = new Summary();
        FileOrganizer organizer = new FileOrganizer(resolver, summary);

        organizer.organize(sourceDir);

        summary.printReport();
        System.out.println("Done!");

    }
}
