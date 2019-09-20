import processing.core.PApplet;
import processing.core.PVector;

public class Bullets {
    PVector location;
    PVector velocity;

    float width = 3;
    float height = 3;

    Bullets(PVector location, PVector velocity, float rotation) {
        this.location = location;
        this.velocity = velocity;
    }

    void update() {
        float dt = 1f/60;

        location.add(velocity.copy().mult(dt));
    }

    void display(PApplet parent) {
        parent.fill(255,255,0);
        parent.ellipse(location.x, location.y, width, height);
    }

    boolean intersects(Building other) {
        return location.x+width > other.location.x
                && location.x < other.location.x + other.size.x
                && location.y+height > other.location.y
                && location.y < other.location.y + other.size.y;
    }
}

