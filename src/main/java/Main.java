import processing.core.PApplet;
import processing.core.PVector;

public class Main extends PApplet{
    Tank tank;
    Base base;


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(120,50,240);
        tank = new Tank( new PVector(0,0), 100, 10, 50);

        base = new Base(tank);
    }

    public void draw(){
        ellipse(width/2,height/2,second(),second());
        tank.update(this);
        tank.display( this);
    }

}