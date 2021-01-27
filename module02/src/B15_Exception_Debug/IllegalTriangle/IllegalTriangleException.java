package B15_Exception_Debug.IllegalTriangle;

import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    private int side;

    public IllegalTriangleException(int side) {
        super(side + " is larger than two side combined or <= 0");
    }

    public double getSide() {
        return side;
    }
}
