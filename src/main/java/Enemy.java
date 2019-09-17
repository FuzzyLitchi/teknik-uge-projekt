import processing.core.PApplet;
import processing.core.PVector;

public class Enemy {
    PVector location;
    PVector enemyBulletlocation;
    float damageOutput;
    float hp;
    Base base;
    Boolean rangeCheckerY;
    Boolean rangeCheckerX;

    public Enemy(PVector location, PVector enemyBulletlocation, float damageOutput, float hp, Base base) {
        this.location = location;
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
        }
        if (this.location.y - base.location.y >= -50 && this.location.y <= 150) {
            rangeCheckerY = true;
        }
        if (this.location.x - base.location.x <= 50 && this.location.x >= 150) {
            rangeCheckerX = true;
        }
        if (this.location.x - base.location.x >= -50 && this.location.x <= 150){
            rangeCheckerX = true;
        }
    }
    void display(PApplet parent) {
        parent.fill(255,0,0);
        parent.ellipse(this.location.x, this.location.y,8,8);
        parent.fill(224,223,213);
        parent.rect(this.location.x+4, this.location.y, 2,4);
    }
}
