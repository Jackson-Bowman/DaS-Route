package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Model.Location;
import Model.Lordran;

public class Route {
    public static void main(String args[]) {
        Lordran world = new Lordran();
        Location[] inputs = new Location[2];
        inputs[0] = Location.FLink;
        inputs[1] = Location.Anor;
        try {
            inputs = LocReader.parseFile(new FileReader(new File("input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        world.routing(inputs[0], inputs[1]);
    }
}
