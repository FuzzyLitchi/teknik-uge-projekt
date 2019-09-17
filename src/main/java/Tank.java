import processing.core.PApplet;
import processing.core.PVector;

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
        parent.fill(0,255,0);
        parent.rect(this.location.x,this.location.y,30,30);
        parent.ellipse(this.location.x+15,this.location.y+15,15,15);
        parent.fill(0);
        parent.text("fuel:  "+this.fuel,this.location.x,this.location.y+50);
    }
    void update(PApplet parent){
        parent.background(255);
        this.shootingTank(parent);
        //this.fuelCounter();

        if (isMovingA) {
            rotation -= 0.1f;
        }
        if (isMovingD) {
            rotation += 0.1f;
        }

        if (isMovingW) {
            location.add(new PVector(3,0).rotate(rotation));
        }
        if (isMovingS) {
            location.add(new PVector(-3,0).rotate(rotation));
        }
    }
}