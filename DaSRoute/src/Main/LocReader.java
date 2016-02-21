package Main;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Model.Location;

/**
 * a class for reading the input file to work with the main method
 */
public class LocReader {
    public static Location[] parseFile(Readable readable) {
        Scanner scanner = new Scanner(readable);
        Location[] parsed = new Location[2];
        for (int i = 0; i <= 1; i++) {
            String level = scanner.nextLine();
            for (Location l: Location.values()) {
                if (level.equalsIgnoreCase(l.getName())) {
                   parsed[i] = l;
                }
            }
        }
        if (parsed[0] == null || parsed[1] == null) {
            throw new NoSuchElementException("invalid input");
        } else {
            return parsed;
        }
    }
}