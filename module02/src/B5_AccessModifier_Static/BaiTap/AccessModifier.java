package B5_AccessModifier_Static.BaiTap;

public class AccessModifier {
    private double radius;
    private String color;

    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        am.color = "red";
        am.radius = 1;

        System.out.println(am.getArea(am.radius));
    }

    public AccessModifier() {
    }

    public AccessModifier(double radius) {
        this.radius = radius;
    }
    public double getArea(double r){
        return Math.PI*r*r;
    }
    public double getRadius(){
        return this.radius;
    }
}
