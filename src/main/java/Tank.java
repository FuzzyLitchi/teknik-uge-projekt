import processing.core.PApplet;
import processing.core.PVector;
import java.lang.Math;

public class Tank {
    PVector velocity = new PVector(0, 0);
    PVector location;
    float fuel;
    float angle;
    int rocketAmmo;
    int bulletAmmo;
    Boolean isMovingW = false;
    Boolean isMovingA = false;
    Boolean isMovingS = false;
    Boolean isMovingD = false;
    Boolean isShooting = false;

    public Tank(PVector location, float fuel, int rocketAmmo, int bulletAmmo) {
        this.location = location;
        this.fuel = fuel;
        this.rocketAmmo = rocketAmmo;
        this.bulletAmmo = bulletAmmo;
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
        } else {
            this.fuel = fuel;
        }
        if (isMovingD) {
            this.fuel = fuel - 1;
        } else {
            this.fuel = fuel;
        }
        if (isMovingS) {
            this.fuel = fuel - 1;
        } else {
            this.fuel = fuel;
        }
        if (isMovingW) {
            this.fuel = fuel - 1;
        } else {
            this.fuel = fuel;
        }
        if (this.fuel <= 0) {
            isMovingA = false;
            isMovingD = false;
            isMovingS = false;
            isMovingW = false;
        }
    }

    void movement(PApplet parent) {
        if (parent.keyPressed) {
            if (parent.key == 'w') {
                this.isMovingW = true;
                if (this.isMovingW = true) {
                    this.location.y = location.y + (float) (location.y*Math.sin(angle/(2*3.1415)*360));
                    this.location.x = location.x + (float) (location.x*Math.cos(angle/(2*3.1415)*360));
                } else {
                    this.isMovingW = false;
                }
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 'a') {
                this.isMovingA = true;
                this.angle = (float) (angle + 0.01);
            } else {
                this.isMovingA = false;
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 's') {
                this.location.y = location.y + 1;
                this.isMovingS = true;
            } else {
                this.isMovingS = false;
            }
        }
        if (parent.keyPressed) {
            if (parent.key == 'd') {
                this.isMovingD = true;
                this.angle = (float) (angle-0.01);
            } else {
                this.isMovingD = false;
            }
        }
    }

    void display(PApplet parent) {
        parent.pushMatrix();
        parent.translate(this.location.x, this.location.y);
        parent.text("fuel:  " + this.fuel, 0, 50);
        parent.rotate(angle);
        parent.fill(0, 255, 0);
        parent.rect(0, 0, 30, 30);
        parent.ellipse(15, 15, 15, 15);
        parent.fill(0);
        parent.popMatrix();
    }


    void update(PApplet parent) {
        parent.background(255);
        this.shootingTank(parent);
        this.fuelCounter();
        this.movement(parent);
    }
}