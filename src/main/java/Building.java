import processing.core.PApplet;
import processing.core.PVector;

class Building {
    PVector location;
    PVector size = new PVector(50,50);

    float health;

    Building(PVector location) {
        this.location = location;
    }

    void display(PApplet parent) {
        parent.fill(100, 100, 100);
        parent.rect(location.x, location.y, size.x, size.y);
    }
}
