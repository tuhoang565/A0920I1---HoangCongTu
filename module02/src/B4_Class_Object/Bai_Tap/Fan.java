package B4_Class_Object.Bai_Tap;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private int radius;
    private String color;

    public static void main(String[] args) {
        Fan fan1 = new Fan(3, true, 10, "blue");
        Fan fan2 = new Fan();
        fan1.toStringFan(fan1.isOn());
        fan2.toStringFan(fan2.isOn());
    }

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, int radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void toStringFan(boolean status){
        if(status){
            System.out.println("Fan is on");
            System.out.println("Speed: " + this.speed);
            System.out.println("Color: " + this.color);
            System.out.println("Radius: " + this.radius);
        }else {
            System.out.println("Fan is off");
            System.out.println("Speed: " + this.speed);
            System.out.println("Color: " + this.color);
            System.out.println("Radius: " + this.radius);
        }
    }
}
