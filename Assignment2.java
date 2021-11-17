/* Create a complex class with data members real and imaginary as integers. Provide constructor for
initialization of these data members and also a show() function which will print complex number in x+iy
form. Now use array of complex objects and perform the following operations-

Perform addition, subtraction and multiplication of two complex numbers which are dynamically
chosen using the corresponding function and return the result of the respective operation as a
complex object. The sample prototype of one such function as-

complex addition(complex c1, complex c2)

2. Perform summation of all the complex numbers available in the array and return the result as a
complex object. The function prototype for this operation is complex sum(complex c[])

3. Find the largest complex number object existing within the complex object array. The idea for
determining the largest complex number among two are- if c1=x1+iy1 and c2=x2+iy2, then for c1>c2,
the condition is x1+y1>x2+y2. The function prototype is- complex larger(complex c[])

4. Find all the repetition of the complex numbers existing within the array. Print the respective complex
number and also its repeated occurrences in the complex array index. The function protype is- void
repeat (complex c[])

5. One complex number will be taken as input and you need to find the closest complex number of it
existing the array. The idea for finding the closest complex number is- calculate the difference between
two complex numbers c1 and c2 as|(x1+y1)-(x2+y2)|, now find the minimum of such values by tracking
the differences with all complex numbers existing in the array. The function prototype is-

complex close(complex c[], complex c1) */

import java.io.*;
import java.util.Scanner;

class complex {
    int real, img;

    complex(int i, int j) {
        real = i;
        img = j;
    }

    complex() {
        real = 0;
        img = 0;
    }

    complex add(complex c1, complex c2) {
        complex ctemp = new complex();
        ctemp.real = c1.real + c2.real;
        ctemp.img = c1.img + c2.img;
        return ctemp;
    }

    complex subtract(complex c1, complex c2) {
        complex ctemp = new complex();
        ctemp.real = c1.real - c2.real;
        ctemp.img = c1.img - c2.img;
        return ctemp;
    }

    complex multiply(complex c1, complex c2) {
        complex ctemp = new complex();
        ctemp.real = c1.real * c2.real;
        ctemp.img = c1.img * c2.img;
        return ctemp;
    }

    complex sum(complex c[]) {
        complex cadd = new complex();
        for (int i = 0; i < c.length; i++) {
            cadd = cadd.add(cadd, c[i]);
        }
        cadd.show();
        return cadd;
    }

    complex larger(complex c[]) {
        complex large = new complex();
        for (int i = 0; i < c.length; i++) {
            if (c[i].real + c[i].img > large.real + large.img)
                large = c[i];
        }
        large.show();
        return large;
    }

    void repeat(complex c[]) {
        for (int i = 0; i < c.length - 1; i++) {
            int count = 1;
            Boolean repeat = false;
            for (int j = i + 1; j < c.length; j++) {

                if (c[i].real == c[j].real && c[i].img == c[j].img) {
                    repeat = true;
                    System.out.print(j + 1 + " ");
                    count++;
                }

            }
            if (repeat) {
                System.out.print(i + 1 + " ");
                System.out.print("are the indices of repetitions of: ");
                c[i].show();
                System.out.println("The number of repititions are: " + count);
            }
            System.out.println();
        }

    }

    complex close(complex c[], complex c1) {
        complex closest = new complex();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            int currdiff = Math.abs((c1.real + c1.img) - (c[i].real + c[i].img));
            if (currdiff < diff) {
                closest = c[i];
                diff = currdiff;
            }
        }
        closest.show();
        return closest;
    }

    void show() {
        System.out.println(real + "+i" + img);
    }

    void show(complex c[]) {
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i].real + "+i" + c[i].img);
    }
}

public class Assignment2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two Complex Numbers: ");

        System.out.print("Enter real part of First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter imaginary part of First Number: ");
        int b = sc.nextInt();
        complex c1 = new complex(a, b);

        System.out.print("Enter real part of Second Number6: ");
        a = sc.nextInt();
        System.out.print("Enter imaginary part of Second Number: ");
        b = sc.nextInt();
        complex c2 = new complex(a, b);

        complex cres = new complex();
        System.out.println("Performing Addition: ");
        cres = c1.add(c1, c2);
        cres.show();
        System.out.println("Performing Subtraction: ");
        cres = c1.subtract(c1, c2);
        cres.show();
        System.out.println("Performing Multiplication: ");
        cres = c1.multiply(c1, c2);
        cres.show();

        System.out.println("Enter the number of complex Numbers : ");
        int n = sc.nextInt();
        complex c[] = new complex[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter real part : ");
            a = sc.nextInt();
            System.out.print("Enter imaginary part : ");
            b = sc.nextInt();
            c[i] = new complex(a, b);
        }

        System.out.println("The Complex Numbers in the Array are: ");
        complex cshow = new complex();
        cshow.show(c);

        complex csum = new complex();
        csum = csum.sum(c);
        System.out.println("Sum of Array is: ");
        csum.show();

        System.out.println("The largest complex Number in the array is: ");
        complex largest = new complex();
        largest.larger(c);

        System.out.println("The repititions (if any) are:");
        complex crepeat = new complex();
        crepeat.repeat(c);

        System.out.println("Enter a complex Number to find its nearest:");
        System.out.print("Enter real part : ");
        a = sc.nextInt();
        System.out.print("Enter imaginary part : ");
        b = sc.nextInt();
        complex cinput = new complex(a, b);
        cinput.close(c, cinput);

        sc.close();
    }

}
