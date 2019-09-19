import processing.core.PApplet;
import processing.core.PVector;

import java.lang.Math;
import java.util.ArrayList;

public class Main extends PApplet {
    Tank tank;
    Base base;
    Enemy enemy;

    MapLoader mapLoader = new MapLoader();
    Map map;

    ArrayList<Rocket> rockets = new ArrayList<Rocket>();


    final static int SCREEN_WIDTH = 800;
    final static int SCREEN_HEIGHT = 800;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(SCREEN_WIDTH,SCREEN_HEIGHT);
    }

    public void setup() {
        fill(120, 50, 240);
        tank = new Tank( new PVector(400,400), 100, 30, 50);
        base = new Base(new PVector(width / 2, (float) (height * 0.1)), 1000, 10, 100, tank);
        enemy = new Enemy(new PVector(500, random(100, 500)), new PVector(1, 1), new PVector(1, 1), 1, 100, base);
        mapLoader.generate(0, 0);
        map = mapLoader.load(0, 0);


        base = new Base(
                new PVector(100, 10),
                100f,
                100f,
                100f,
                tank
        );
    }

    public void draw() {
        // Update logic
        tank.update(this);

        if (tank.location.x > SCREEN_WIDTH) {
            mapLoader.store(map);
            map = mapLoader.load(mapLoader.x+1, mapLoader.y);

            tank.location.x -= SCREEN_WIDTH;
        }
        if (tank.location.x < 0) {
            mapLoader.store(map);
            map = mapLoader.load(mapLoader.x-1, mapLoader.y);

            tank.location.x += SCREEN_WIDTH;
        }

        if (tank.location.y > SCREEN_HEIGHT) {
            mapLoader.store(map);
            map = mapLoader.load(mapLoader.x, mapLoader.y+1);

            tank.location.y -= SCREEN_HEIGHT;
        }
        if (tank.location.y < 0) {
            mapLoader.store(map);
            map = mapLoader.load(mapLoader.x, mapLoader.y-1);

            tank.location.y += SCREEN_HEIGHT;
        }

        for (Rocket rocket : rockets) {
            rocket.update();
            for (int i = map.buildings.size(); i-- > 0; ) {
                if (rocket.intersects(map.buildings.get(i))) {
                    map.buildings.remove(i);
                }
            }
        }

        // DrawingR
        background(255);

        for (Building building : map.buildings) {
            building.display(this);
        }
        tank.display(this);
        for (Rocket rocket : rockets) {
            rocket.display(this);
        }
        base.display(this);
    }

    public void keyPressed() {
        tank.handleKeyPress(keyCode, this);
    }

    public void keyReleased() {
        tank.handleKeyRelease(keyCode);
    }
}