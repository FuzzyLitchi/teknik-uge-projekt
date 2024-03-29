import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Civilians {
    PVector location;
    int numChild;
    int numAdults;
    int numElderly;
    int point;
    Rocket rockets;

    public Civilians(PVector location, int numChild, int numAdults, int numElderly, int point, ArrayList<Rocket> rocket) {
        this.location = location;
        this.numChild = numChild;
        this.numAdults = numAdults;
        this.numElderly = numElderly;
        this.point = point;
        this.rockets = rockets;
    }

    void civilianGenerator(PApplet parent) {
        numChild = (int) parent.random(1, 5);
        numAdults = (int) parent.random(1, 5);
        numElderly = (int) parent.random(1, 5);
    }

    void setPoint() {
        if (Math.pow(this.location.x - rockets.location.x, 2) <= Math.sqrt(196) && Math.pow(this.location.x - rockets.location.x, 2) <= Math.sqrt(196)) {
            point = (numChild * 10) + point;
            point = (numAdults * 5) + point;
            point = (numElderly * 2) + point;
        }
    }

    void display(PApplet parent) {
        parent.pushMatrix();
        parent.translate(location.x, location.y);
        parent.fill(139, 69, 19);
        parent.ellipse(0, 0, 5, 5);
        parent.fill(255, 255, 0);
        parent.ellipse(10, 10, 9, 9);
        parent.fill(125);
        parent.ellipse(0, 12, 7, 7);
        parent.popMatrix();
    }

    void update(PApplet parent){
        setPoint();
        civilianGenerator(parent);
    }
}
