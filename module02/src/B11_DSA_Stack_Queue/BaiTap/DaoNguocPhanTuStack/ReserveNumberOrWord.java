package B11_DSA_Stack_Queue.BaiTap.DaoNguocPhanTuStack;


import java.util.Stack;

public class ReserveNumberOrWord {
    public static void main(String[] args) {
//        int[] integerNumber = {1, 3, 4, 5};
//        Stack<Integer> integerStack = new Stack<>();
//        integerStack.push(integerNumber[0]);
//        integerStack.push(integerNumber[1]);
//        integerStack.push(integerNumber[2]);
//        integerStack.push(integerNumber[3]);
//
//        for(int i = 0; i < integerNumber.length; i++){
//            integerNumber[i] = integerStack.pop();
//        }
//
//        for ( int x : integerNumber){
//            System.out.println(x);
//        }

        Stack<String> stringStack = new Stack<>();
        String string = "Hello Java EE";
        String stringArray[] = string.split("\\s");

        for(int i = 0; i < stringArray.length; i++){
            stringStack.push(stringArray[i]);
        }
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = stringStack.pop();
        }
        for (String x: stringArray) {
            System.out.println(x);
        }

    }
}
