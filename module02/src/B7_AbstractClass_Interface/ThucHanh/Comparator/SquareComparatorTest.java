package B7_AbstractClass_Interface.ThucHanh.Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square();
        squares[1] = new Square(2);
        squares[2] = new Square(3, "blue", false);

        System.out.println("Pre-sort: ");
        for(Square square : squares){
            System.out.println(square);
        }

        Comparator squareComparator = new SquareComparator();
        Arrays.sort(squares, squareComparator);

        System.out.println("After-sort: ");
        for(Square square : squares){
            System.out.println(square);
        }
    }
}
