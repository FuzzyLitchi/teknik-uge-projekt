import processing.core.PVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MapLoader {
    int x;
    int y;

    HashMap<Integer, Map> maps = new HashMap<Integer, Map>();

    void generate(int x, int y) {
        Map map = new Map();

        Random r = new Random();

        ArrayList<Building> buildings = new ArrayList<Building>();
        buildings.add(new Building(
                new PVector(r.nextFloat() * 300, r.nextFloat() * 300)
        ));

        map.buildings = buildings;

        maps.put(x+100*y, map);
    }

    void store(Map current) {
        maps.put(x+100*y, current);
    }

    Map load(int x, int y) {
        return maps.get(x+100*y);
    }
}
