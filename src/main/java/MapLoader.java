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
        for (int i = 0; i < r.nextInt(5)+3; i++) {
            buildings.add(new Building(
                    new PVector(r.nextFloat() * 800, r.nextFloat() * 800)
            ));
        }

        map.buildings = buildings;

        maps.put(x+100*y, map);
    }

    void store(Map current) {
        maps.put(x+100*y, current);
    }

    Map load(int x, int y) {
        this.x = x;
        this.y = y;

        if (!maps.containsKey(x+100*y)) {
            generate(x, y);
        }

        return maps.get(x+100*y);
    }
}
