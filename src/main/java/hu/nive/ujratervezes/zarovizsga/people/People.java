package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    int getNumberOfMales(String path) {
        int countMale = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[4].equals("Male")) {
                    countMale++;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot load file! Fillename: " + path, e);
        }
        return countMale;
    }
}
