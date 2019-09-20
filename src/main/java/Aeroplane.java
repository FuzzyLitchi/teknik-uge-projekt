import processing.core.PApplet;
import processing.core.PVector;
import java.lang.Math;
import java.util.ArrayList;
public class Aeroplane {
    float rotation;
    float bulletCoolDown = 0.5f; // in seconds
    float bulletTimer = 0.0f;
    PVector location;
    int bulletAmmo;
    float fuel;
    boolean isMovingWA = false;
    boolean isMovingAA = false;
    boolean isMovingSA = false;
    boolean isMovingDA = false;

    public Aeroplane(PVector location, float fuel, int bulletAmmo){
        this.location=location;
        this.fuel=fuel;
        this.bulletAmmo=bulletAmmo;
    }

    void fireBullet(ArrayList<Bullets> bullets){
        if (bulletTimer > 0f || bulletAmmo <= 0) {
            return;
        }

        bullets.add(
                new Bullets(
                        this.location.copy(),
                        new PVector(300,0).rotate(rotation),
                        rotation
                )
        );
        bulletTimer = bulletCoolDown;
        bulletAmmo--;
    }
    final static int VK_UP = 38;
    final static int VK_LEFT = 37;
    final static int VK_DOWN = 40;
    final static int VK_RIGHT = 39;
    final static int K = 75;
    void handleKeyPress(int keyCode, Main main) {
        System.out.println(keyCode);
        switch (keyCode) {
            case VK_DOWN:
                this.isMovingWA = true;
                break;
            case VK_LEFT:
                this.isMovingAA = true;
                break;
            case VK_UP:
                this.isMovingSA = true;
                break;
            case VK_RIGHT:
                this.isMovingDA = true;
                break;
            case K:
                fireBullet(main.bullets);
        }
    }
    void handleKeyRelease(int keyCode) {
        switch (keyCode) {
            case VK_DOWN:
                this.isMovingWA = false;
                break;
            case VK_LEFT:
                this.isMovingAA = false;
                break;
            case VK_UP:
                this.isMovingSA = false;
                break;
            case VK_RIGHT:
                this.isMovingDA = false;
                break;
        }
    }
    void display(PApplet parent) {
        parent.pushMatrix();
        parent.translate(this.location.x, this.location.y);
        parent.text("fuel:  " + this.fuel, 0, 50);
        parent.rotate(rotation);
        parent.fill(100, 255, 100);
        parent.ellipse(-0,-25,18,5);
        parent.ellipse(-0,12,18,5);
        parent.ellipse(-18,-10,15,10);
        parent.rect(-15, -15, 52, 11);
        parent.rect(0,-38,7,61);
        parent.triangle(27,-10,45,8,45,-28);
        parent.fill(0);
        parent.popMatrix();
    }
    void update(PApplet parent) {
        bulletTimer -= 1f/20;

        if (this.isMovingAA) {
            rotation -= 0.05f;
        }
        if (this.isMovingDA) {
            rotation += 0.05f;
        }

        if (this.isMovingWA) {
            location.add(new PVector(3,0).rotate(rotation));
            fuel -= 0.005f;
        }
        if (this.isMovingSA) {
            location.add(new PVector(-3,0).rotate(rotation));
            fuel -= 0.005f;
        }
    }
}
