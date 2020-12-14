package B6_KeThua.BaiTap.Circle_Cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder("orange", 3, 2);
        System.out.println(cylinder);
        System.out.println("Volume: " + cylinder.getVolume());

        cylinder = new Cylinder("white", 5, 6);
        System.out.println(cylinder);
        System.out.println("volume: " + cylinder.getVolume());


    }
}
