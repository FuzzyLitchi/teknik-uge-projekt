import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet{
    Tank tank;
    ArrayList<Building> buildings = new ArrayList<Building>();
    ArrayList<Rocket> rockets = new ArrayList<Rocket>();

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(120,50,240);
        tank = new Tank( new PVector(0,0), 100, 10, 50);

        buildings.add(new Building(new PVector(100,100)));
        rockets.add(new Rocket(
                new PVector(200, 100),
                new PVector(-40, 10)
        ));
    }

    public void draw(){
        // Update logic
        tank.update(this);
        for (Rocket rocket : rockets) {
            rocket.update();
            for (int i = buildings.size(); i-- > 0; ) {
                if (rocket.intersects(buildings.get(i))) {
                    buildings.remove(i);
                }
            }
        }

        // Drawing
        for (Building building : buildings) {
            building.display(this);
        }

        tank.display( this);

        for (Rocket rocket : rockets) {
            rocket.display(this);
        }
    }

}