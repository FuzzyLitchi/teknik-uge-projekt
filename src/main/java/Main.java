import processing.core.PApplet;
import processing.core.PVector;
import java.lang.Math;
import java.util.ArrayList;

public class Main extends PApplet{
    Tank tank;
    Base base;

    MapLoader mapLoader = new MapLoader();
    Map map;

    ArrayList<Rocket> rockets = new ArrayList<Rocket>();

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(800,800);
    }

    public void setup(){
        fill(120,50,240);
        tank = new Tank( new PVector(0,0), 100, 10, 50);
        base = new Base( new PVector (150,150), 1000, 10, 100, tank);

        mapLoader.generate(0,0);
        map = mapLoader.load(0,0);

        rockets.add(new Rocket(
                new PVector(200, 100),
                new PVector(-40, 10)
        ));

        base = new Base(
                new PVector(100, 10),
                100f,
                100f,
                100f,
                tank
        );
    }

    public void draw(){
        // Update logic
        tank.update(this);
        for (Rocket rocket : rockets) {
            rocket.update();
            for (int i = map.buildings.size(); i-- > 0; ) {
                if (rocket.intersects(map.buildings.get(i))) {
                    map.buildings.remove(i);
                }
            }
        }

        // Drawing
        for (Building building : map.buildings) {
            building.display(this);
        }
        tank.display(this);
        for (Rocket rocket : rockets) {
            rocket.display(this);
        }
    }

    public void keyPressed() {
        tank.handleKeyPress(keyCode);
    }

    public void keyReleased() {
        tank.handleKeyRelease(keyCode);
    }
}