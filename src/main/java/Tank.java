import processing.core.PApplet;
import processing.core.PVector;
import java.lang.Math;
import java.util.ArrayList;

class Tank {
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

    float rocketCoolDown = 0.5f; // in seconds
    float rocketTimer = 0.0f;

    public Tank(PVector location, float fuel, int rocketAmmo, int bulletAmmo) {
        this.location = location;
        this.fuel = fuel;
        this.rocketAmmo = rocketAmmo;
        this.bulletAmmo = bulletAmmo;
    }

    void fireRocket(ArrayList<Rocket> rockets) {
        if (rocketTimer > 0f || rocketAmmo <= 0) {
            return;
        }

        rockets.add(
            new Rocket(
                this.location.copy(),
                new PVector(300,0).rotate(rotation),
                rotation
            )
        );
        rocketTimer = rocketCoolDown;
        rocketAmmo--;
    }

    final static int W = 87;
    final static int A = 65;
    final static int S = 83;
    final static int D = 68;
    final static int SPACE = 32;
    void handleKeyPress(int keyCode, Main main) {
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
            case SPACE:
                fireRocket(main.rockets);
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
        rocketTimer -= 1f/60;

        if (isMovingA) {
            rotation -= 0.05f;
        }
        if (isMovingD) {
            rotation += 0.05f;
        }

        if (isMovingW) {
            location.add(new PVector(3,0).rotate(rotation));
            fuel -= 0.005f;
        }
        if (isMovingS) {
            location.add(new PVector(-3,0).rotate(rotation));
            fuel -= 0.005f;
        }
    }
}