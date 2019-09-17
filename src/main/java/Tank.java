import processing.core.PApplet;
import processing.core.PVector;
import java.lang.Math;

public class Tank {
    PVector location;
    float rotation = 0;
    float fuel;
    int rocketAmmo;
    int bulletAmmo;
    boolean isMovingW = false;
    boolean isMovingA = false;
    boolean isMovingS = false;
    boolean isMovingD = false;
    boolean isShooting = false;

    public Tank(PVector location, float fuel, int rocketAmmo, int bulletAmmo) {
        this.location = location;
        this.fuel = fuel;
        this.rocketAmmo = rocketAmmo;
        this.bulletAmmo = bulletAmmo;
    }

    void shootingTank(PApplet parent) {
        if (parent.keyPressed) {
            if (parent.key == 'o') {
                isShooting = true;
                if (this.rocketAmmo > 0) {
                    if (isShooting = true) {
                        Rocket myRocket = new Rocket(this.location.copy(), new PVector(0,0));
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

    final static int W = 87;
    final static int A = 65;
    final static int S = 83;
    final static int D = 68;
    void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case W:
                isMovingW = true;
                break;
            case A:
                isMovingA = true;
                break;
            case S:
                isMovingS = true;
                break;
            case D:
                isMovingD = true;
                break;
        }
    }
    void handleKeyRelease(int keyCode) {
        switch (keyCode) {
            case W:
                isMovingW = false;
                break;
            case A:
                isMovingA = false;
                break;
            case S:
                isMovingS = false;
                break;
            case D:
                isMovingD = false;
                break;
        }
    }

    void display(PApplet parent) {
        parent.pushMatrix();
        parent.translate(this.location.x, this.location.y);
        parent.text("fuel:  " + this.fuel, 0, 50);
        parent.rotate(rotation);
        parent.fill(0, 255, 0);
        parent.rect(-15, -15, 30, 30);
        parent.ellipse(0, 0, 15, 15);
        parent.fill(0);
        parent.popMatrix();
    }


    void update(PApplet parent) {
        parent.background(255);
        this.shootingTank(parent);
        //this.fuelCounter();

        if (isMovingA) {
            rotation -= 0.05f;
        }
        if (isMovingD) {
            rotation += 0.05f;
        }

        if (isMovingW) {
            location.add(new PVector(3,0).rotate(rotation));
        }
        if (isMovingS) {
            location.add(new PVector(-3,0).rotate(rotation));
        }
    }
}