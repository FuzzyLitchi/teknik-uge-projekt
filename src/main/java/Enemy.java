import processing.core.PApplet;
import processing.core.PVector;

public class Enemy {
    PVector location;
    PVector enemyBulletlocation;
    PVector velocity;
    float damageOutput;
    float hp;
    Base base;
    Tank tank;
    Rocket rocket;
    Boolean rangeCheckerY;
    Boolean rangeCheckerX;
    Boolean alive;

    public Enemy(PVector location, PVector enemyBulletlocation, PVector velocity, float damageOutput, float hp, Base base) {
        this.location = location;
        this.velocity = velocity;
        this.enemyBulletlocation = enemyBulletlocation;
        this.damageOutput = damageOutput;
        this.hp = hp;
        this.base = base;
    }

    void movementAI() {
        if (this.location.y - base.location.y < -50) {
            this.location.y = location.y + 1;
        }
        if (this.location.x - base.location.x > 50) {
            this.location.x = location.x - 1;
        }
        if (this.location.y - base.location.y > 50) {
            this.location.y = location.y - 1;
        }
        if (this.location.x - base.location.x < -50) {
            this.location.x = location.x + 1;
        }
    }

    void rangeChecker() {
        if (this.location.y - base.location.y <= 50 && this.location.y >= 150) {
            rangeCheckerY = true;
        } else {
            rangeCheckerY = false;
        }
        //if (this.location.y - base.location.y >= -50 && this.location.y <= 150) {
        //rangeCheckerY = true;
        if (this.location.x - base.location.x <= 50 && this.location.x >= 150) {
            rangeCheckerX = true;
        } else {
            rangeCheckerX = false;
        }
    }
    //if (this.location.x - base.location.x >= -50 && this.location.x <= 150){
    //rangeCheckerX = true;


    void shooting() {
        if ((this.rangeCheckerX = true) && (this.rangeCheckerY = true)) {
            base.hp = (float) (base.hp - 0.01);
        }
    }

    void display(PApplet parent) {
        if (alive = true)
            parent.fill(255, 0, 0);
        parent.ellipse(this.location.x, this.location.y, 8, 8);
        parent.fill(224, 223, 213);
        parent.rect(this.location.x + 4, this.location.y, 2, 4);
    }

    void killCheck() {
        if (Math.pow(this.location.x - rocket.location.x, 2) <= Math.sqrt(100) && Math.pow(this.location.x - rocket.location.x, 2) <= Math.sqrt(100)) {
            alive = false;
        } else {
            alive = true;
        }
    }

    void update(PApplet parent) {
        shooting();
        rangeChecker();
        movementAI();
    }
}
