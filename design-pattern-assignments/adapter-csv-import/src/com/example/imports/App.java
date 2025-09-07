package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Path csv = Path.of("com/example/imports/sample_users.csv");

        // TODO: Implement and use CsvProfileImporter here
        ProfileImporter importer = new CsvProfileImporter(new NaiveCsvReader(), new ProfileService());
        System.out.println();
        int n = importer.importFrom(csv);
        System.out.println("\nImported " + n + " profiles");
    }
}
