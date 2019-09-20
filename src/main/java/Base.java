import processing.core.PApplet;
import processing.core.PVector;

public class Base {
    PVector location;
    float HP;
    float ammoRegenRockets;
    float ammoRegenBullets;
    Boolean alive;
    Boolean isHome;
    Boolean hitReg;
    Tank tank;

    public Base(PVector location, float HP, float ammoRegenRockets, float ammoRegenBullets, Tank tank) {
        this.location = location;
        this.HP = HP;
        this.ammoRegenRockets = ammoRegenRockets;
        this.ammoRegenBullets = ammoRegenBullets;
        this.tank = tank;
    }

    void pitStop(PApplet parent) {
        if (alive = true) {
            if (Math.pow(this.location.x - tank.location.x, 2) <= Math.sqrt(2500) && Math.pow(this.location.x - tank.location.x, 2) <= Math.sqrt(2500)){
                tank.rocketAmmo = 10;
                tank.bulletAmmo = 100;
                tank.fuel = 100;
            }
        }
    }

    void healthChecker(PApplet parent) {


        if (HP <= 0) {
            alive = false;
        } else {
            alive = true;
        }
    }

    void display(PApplet parent) {
        parent.fill(125);
        parent.rect(this.location.x, this.location.y, 20, 100);
        parent.fill(0, 0, 100);
        parent.rect(this.location.x + 25, this.location.y, 20, 20);
        parent.fill(0);
        parent.text("HP" + this.HP, this.location.x, this.location.y + 70);
    }

    void update(PApplet parent) {
        if (alive = true) {
            pitStop(parent);
            healthChecker(parent);
        }
    }
}
