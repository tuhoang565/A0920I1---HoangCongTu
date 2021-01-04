package B8_CleanCode_Refactory.DoiTenBien_TachHang;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

        @Test
        @DisplayName("Testing addition")
        void testCalculateAdd() {
            int a = 1;
            int b = 1;
            char ADDITION  = '+';
            int expected = 2;

            int result = Calculator.calculate(a, b, ADDITION );
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing subtraction")
        void testCalculateSub() {
            int a = 2;
            int b = 1;
            char SUBTRACTION   = '-';
            int expected = 1;

            int result = Calculator.calculate(a, b, SUBTRACTION  );
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing multiplication")
        void testCalculateMul() {
            int a = 2;
            int b = 2;
            char MULTIPLICATION  = '*';
            int expected = 4;

            int result = Calculator.calculate(a, b, MULTIPLICATION );
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing division")
        void testCalculateDiv() {
            int a = 6;
            int b = 3;
            char DIVISION  = '/';
            int expected = 2;

            int result = Calculator.calculate(a, b, DIVISION );
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Testing division by zero")
        void testCalculateDivByZero() {
            int a = 2;
            int b = 0;
            char DIVISION  = '/';

            assertThrows(RuntimeException.class,
                    ()-> {Calculator.calculate(a, b, DIVISION );});
        }

        @Test
        @DisplayName("Testing wrong operator")
        void testCalculateWrongOperator() {
            int a = 2;
            int b = 0;
            char o = '=';

            assertThrows(RuntimeException.class,
                    ()-> {Calculator.calculate(a, b, o);});
        }
}
