import processing.core.PApplet;
import processing.core.PVector;

public class Tank {
    PVector velocity = new PVector (0,0);
    PVector location;
    float fuel;
    int rocketAmmo;
    int bulletAmmo;
    Boolean isMovingW = false;
    Boolean isMovingA = false;
    Boolean isMovingS = false;
    Boolean isMovingD = false;
    Boolean isShooting = false;

    public Tank(PVector location, float fuel, int rocketAmmo, int bulletAmmo){
        this.location = location;
        this.fuel = fuel;
        this.rocketAmmo=rocketAmmo;
        this.bulletAmmo=bulletAmmo;
    }

    void shootingTank(PApplet parent) {
        if (parent.keyPressed) {
            if (parent.key == 'o') {
                if (this.rocketAmmo > 0) {
                    if (isShooting = true) {
                        Rocket myRocket = new Rocket(this.location.copy(), this.velocity.copy());
                        System.out.println("It works :)");
                    }
                }
            }
        }
    }

    void fuelCounter() {
        if (isMovingA) {
            this.fuel = fuel - 1;
        }
        if (isMovingD) {
            this.fuel = fuel - 1;
        }
        if (isMovingS) {
            this.fuel = fuel - 1;
        }
        if (isMovingW) {
            this.fuel = fuel - 1;
        }
        if (this.fuel == 0) {
            isMovingA = false;
            isMovingD = false;
            isMovingS = false;
            isMovingW = false;
        }
    }

    void movement(PApplet parent) {
        if (parent.keyPressed) {
            if (parent.key == 'w') {
                this.location.y = location.y - 1;
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 'a') {
                this.location.x = location.x - 1;
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 's') {
                this.location.y = location.y + 1;
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 'd') {
                this.location.x = location.x + 1;
            }
        }
    }
    void display(PApplet parent) {
        parent.fill(0,255,0);
        parent.rect(this.location.x,this.location.y,30,30);
        parent.ellipse(this.location.x+15,this.location.y+15,15,15);
        parent.fill(0);
        parent.text("fuel:  "+this.fuel,this.location.x,this.location.y+50);
    }
    void update(PApplet parent){
        parent.background(255);
        this.shootingTank(parent);
        this.fuelCounter();
        this.movement(parent);
    }
}