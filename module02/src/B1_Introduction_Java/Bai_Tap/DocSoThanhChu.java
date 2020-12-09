package B1_Introduction_Java.Bai_Tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        int hundreds = num/100;
        int tens = num%100;
        tens = tens/10;
        int ones = num%10;


        if(num > 0 && num < 1000){
            switch (hundreds){
                case 1:
                    System.out.print("one hundred ");
                    break;
                case 2:
                    System.out.print("two hundred ");
                    break;
                case 3:
                    System.out.print("three hundred ");
                    break;
                case 4:
                    System.out.print("four hundred ");
                    break;
                case 5:
                    System.out.print("five hundred ");
                    break;
                case 6:
                    System.out.print("six hundred ");
                    break;
                case 7:
                    System.out.print("seven hundred ");
                    break;
                case 8:
                    System.out.print("eight hundred ");
                    break;
                case 9:
                    System.out.print("nine hundred ");
                    break;
            }

            switch (tens){
                case 1:
                    switch (ones){
                        case 1:
                            System.out.print("eleven");
                            break;
                        case 2:
                            System.out.print("twelve");
                            break;
                        case 3:
                            System.out.print("thirdteen");
                            break;
                        case 4:
                            System.out.print("fourteen");
                            break;
                        case 5:
                            System.out.print("fifthteen");
                            break;
                        case 6:
                            System.out.print("sixteen");
                            break;
                        case 7:
                            System.out.print("seventeen");
                            break;
                        case 8:
                            System.out.print("eighteen");
                            break;
                        case 9:
                            System.out.print("nineteen");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Twenty ");
                    break;
                case 3:
                    System.out.print("Thirdty ");
                    break;
                case 4:
                    System.out.print("Fourty ");
                    break;
                case 5:
                    System.out.print("Fifty ");
                    break;
                case 6:
                    System.out.print("Sixty ");
                    break;
                case 7:
                    System.out.print("Seventy ");
                    break;
                case 8:
                    System.out.print("Eighty ");
                    break;
                case 9:
                    System.out.print("Ninety ");
                    break;
            }

            if(ones != 1){
                switch (ones){
                    case 1:
                        System.out.print("One");
                        break;
                    case 2:
                        System.out.print("Two");
                        break;
                    case 3:
                        System.out.print("Three");
                        break;
                    case 4:
                        System.out.print("Four");
                        break;
                    case 5:
                        System.out.print("Five");
                        break;
                    case 6:
                        System.out.print("Six");
                        break;
                    case 7:
                        System.out.print("Seven");
                        break;
                    case 8:
                        System.out.print("Eight");
                        break;
                    case 9:
                        System.out.print("Night");
                        break;
                }
            }
        }else {
            System.out.println("out of ability");
        }
    }
}
