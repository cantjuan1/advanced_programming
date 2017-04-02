package co.edu.utadeo.programacion.avanzada.taller;

import java.util.Date;

/**
 * UVA Uggly Numbers
 * @author Juan Cantor
 *
 */
public class UglyNumbers {

    public static boolean isUglyNumber(int number) {
        if (number == 1)
            return true;
        if (number % 2 == 0) {
            number = number / 2;
            return isUglyNumber(number);
        }
        if (number % 3 == 0) {
            number = number / 3;
            return isUglyNumber(number);
        }
        if (number % 5 == 0) {
            number = number / 5;
            return isUglyNumber(number);
        }
        return false;
    }

    public static boolean isUglyNumberNoRecursion(int number) {
        while (true) {
            if (number == 1) {
                return true;
            }
            else if (number % 2 == 0) {
                number = number / 2;
            }
            else if (number % 3 == 0) {
                number = number / 3;
            }
            else if (number % 5 == 0) {
                number = number / 5;
            }
            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("1500'th ugly number no recursion");
        int countUN = 1;
        int number = 1;
        System.out.println(new Date());
        while (countUN != 1500) {
            if (isUglyNumberNoRecursion(number) && countUN != 1500) {
                countUN++;
            }
            number++;
        }
        System.out.println("The 1500'th ugly number is " + number);
        System.out.println(new Date());
        System.out.println("1500'th ugly number recursion");
        countUN = 1;
        number = 1;
        System.out.println(new Date());
        while (countUN != 1500) {
            if (isUglyNumber(number) && countUN != 1500) {
                countUN++;
            }
            number++;
        }
        System.out.println("The 1500'th ugly number is " + number);
        System.out.println(new Date());
    }
}
