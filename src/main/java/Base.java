import processing.core.PApplet;
import processing.core.PVector;

public class Base {
    PVector location;
    float hp;
    float ammoRegenRockets;
    float ammoRegenBullets;
    Boolean alive;
    Boolean isHome;
    Boolean hitReg;
    Tank tank;

    public Base(PVector location, float hp, float ammoRegenRockets, float ammoRegenBullets, Tank tank) {
        this.location = location;
        this.hp = hp;
        this.ammoRegenRockets = ammoRegenRockets;
        this.ammoRegenBullets = ammoRegenBullets;
        this.tank = tank;
    }

    void pitstop(PApplet parent) {
        if (this.location == location) {
            tank.rocketAmmo = 10;
            tank.bulletAmmo = 100;
            tank.fuel = 100;
        }
    }

   void hitReg() {
        if (((((this.location.x-enemyBulletlocation.x)^2) <= 0) && ((this.locaiton.y-enemyBulletlocation.y)^2) <= 0 )){
         hp = hp -1;
       }
   }

    void display(PApplet parent) {
        parent.fill(125);
        parent.rect(this.location.x, this.location.y, 20, 100);
        parent.fill(0, 0, 100);
        parent.rect(this.location.x + 25, this.location.y, 20, 20);
    }
}
