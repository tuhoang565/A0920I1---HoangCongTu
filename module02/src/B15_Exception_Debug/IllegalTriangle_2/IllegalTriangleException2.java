package B15_Exception_Debug.IllegalTriangle_2;

public class IllegalTriangleException2 extends Exception{
    private int side;

    public IllegalTriangleException2(int side) {
        super(side + " is greater than 2 side combine");
    }

    public int getSide() {
        return side;
    }


}
