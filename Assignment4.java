/*Create a department class as outer class with its data members department
name and hod name. Provide constructor for initialization of these data
members.

Now create the inner class student within the outer class department. Now
add student class array of objects as the data member in the department
class along with the earlier declared data members of department name and
hod name.

The student class contains data members as- student roll number, name,
pass out year with all the four year CGPA. Provide constructor for
initialization of these student data members also.

Consider 3 departments as CSE, IT, CT. Consider at least 5 pass out students
in each year of 2019, 2020, 2021 per department. Take keyboard input
accordingly to comply those given conditions. Now based on these given
information, design your nested/inner class structure properly in order to
perform the following operations.

User supplies department name and pass out year such that all the individual
student data for that particular department and year will be displayed.

User supplies department name, pass out year and the particular study year number
such that all the student CGPA for that particular department, study year and pass
out year can be found.

List the top ranked (in terms of highest average CGPA) student data (i.e roll and
name )for a particular pass out year and department where the department name
and pass out year will be supplied as keyboard input.

List the top ranked (in terms of highest average CGPA) student data (i.e roll and
name) for a particular pass out year among all the 3 departments where year of pass
out year will be given as input. Also display the corresponding department name and
hod name for that top ranked student.

Display the list of students (i.e roll, name and department name) who have obtained
average CGPA greater than a certain value for a particular pass out year. Here this
specific threshold value and the pass out year number will be supplied keyboard
input.

Display the students (i.e roll, name, department name hod name) who have
obtained CGPA less than a certain value for two consecutive year of study year. Here
all the department and all the pass out year will be considered, only the threshold
CGPA value will be taken as keyboard input.*/

import java.io.*;
import java.util.*;

class Department {
    private String d_name, hod_name;

    class Student {
        private String roll, s_name;
        private int year;
        private double cgpa1, cgpa2, cgpa3, cgpa4;

        Student(String s1, String s2, Integer i, double cg1, double cg2, double cg3, double cg4) {
            roll = s1;
            s_name = s2;
            year = i;
            cgpa1 = cg1;
            cgpa2 = cg2;
            cgpa3 = cg3;
            cgpa4 = cg4;
        }

        Student() {
        }

        void getStudentInfo() {
            System.out.println("Roll NUmber = " + roll + " Student name = " + s_name + " Passout year = " + year
                    + " CGPA_1 = " + cgpa1 + " CGPA_2 = " + cgpa2 + " CGPA_3 = " + cgpa3 + " CGPA_4 = " + cgpa4);
        }

        void getStudentInfo(int curr_year) {
            if (curr_year == 1)
                System.out.println(
                        "Present CGPA = " + cgpa1 + " Current study year = " + (year - 4) + " Passout year = " + year);
            else if (curr_year == 2)
                System.out.println(
                        "Present CGPA = " + cgpa2 + " Current study year = " + (year - 3) + " Passout year = " + year);
            else if (curr_year == 3)
                System.out.println(
                        "Present CGPA = " + cgpa3 + " Current study year = " + (year - 2) + " Passout year = " + year);
            else
                System.out.println(
                        "Present CGPA = " + cgpa4 + " Current study year = " + (year - 1) + " Passout year = " + year);
        }

        double getAvgCGPA() {
            return (cgpa4 + cgpa3 + cgpa2 + cgpa1) / 4;
        }

        void printRollName() {
            System.out.println("Roll NUmber = " + roll + " Student name = " + s_name);
        }
    }

    Student[] arr = new Student[15];
    Student std = new Student();

    Department(String s1, String s2) {
        d_name = s1;
        hod_name = s2;
        System.out.println("Enter the details of the " + d_name + " Department Students: ");
        for (int k = 0; k < 5; k++) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("\nEnter the roll number: ");
            s1 = sc.nextLine();
            System.out.printf("Enter the name of the student: ");
            s2 = sc.nextLine();
            System.out.printf("Enter the passout year: ");
            Integer i = sc.nextInt();
            System.out.printf("Enter the CGPA_1: ");
            double d1 = sc.nextDouble();
            System.out.printf("Enter the CGPA_2: ");
            double d2 = sc.nextDouble();
            System.out.printf("Enter the CGPA_3: ");
            double d3 = sc.nextDouble();
            System.out.printf("Enter the CGPA_4: ");
            double d4 = sc.nextDouble();
            arr[k] = new Student(s1, s2, i, d1, d2, d3, d4);
            sc.close();
        }
    }

    String getDname() {
        return d_name;
    }

    double getMaxCGPA(int y) {
        double max = 0;
        for (int i = 0; i < 15; i++)
            if (arr[i].year == y && arr[i].getAvgCGPA() >= max) {
                max = arr[i].getAvgCGPA();
                std = arr[i];
            }
        return max;
    }

    void rollNameDeptHOD() {
        std.printRollName();
        System.out.println("Department name = " + d_name + " name of the HOD = " + hod_name);
    }

    void method1(int y) {
        for (int i = 0; i < 5; i++)
            if (arr[i].year == y)
                arr[i].getStudentInfo();
    }

    void method2(int y, int curr_year) {
        for (int i = 0; i < 15; i++)
            if (arr[i].year == y)
                arr[i].getStudentInfo(curr_year);
    }

    void method3(int y) {
        Student st = new Student();
        double max = 0;
        for (int i = 0; i < 15; i++)
            if (arr[i].year == y && arr[i].getAvgCGPA() >= max) {
                max = arr[i].getAvgCGPA();
                st = arr[i];
            }
        st.printRollName();
    }

    void method5(double d, int y) {
        for (int i = 0; i < 15; i++)
            if (arr[i].year == y && arr[i].getAvgCGPA() > d) {
                arr[i].printRollName();
                System.out.println("Department name = " + getDname());
            }
    }

    void method6(double d) {
        for (int i = 0; i < 15; i++) {
            if ((d > arr[i].cgpa1 && d > arr[i].cgpa2) || (d > arr[i].cgpa2 && d > arr[i].cgpa3)
                    || (d > arr[i].cgpa3 && d > arr[i].cgpa4)) {
                arr[i].printRollName();
                System.out.println("Department name = " + d_name + " Name of the HOD = " + hod_name);
            }
        }
    }
}

public class Assignment4 {
    public static void main(String[] args) throws IOException {
        Department d1 = new Department("CSE", "KS");
        Department d2 = new Department("IT", "MM");
        Department d3 = new Department("CT", "RS");
        Scanner sc = new Scanner(System.in);
        System.out.printf("\nEnter the department name: ");
        String s = sc.nextLine();
        System.out.printf("Enter the passout year: ");
        int y = sc.nextInt();
        System.out.println();
        if (s.equals(d1.getDname()))
            d1.method1(y);
        else if (s.equals(d2.getDname()))
            d2.method1(y);
        else
            d3.method1(y);

        System.out.println();
        System.out.printf("\nEnter the department name: ");
        String s1 = sc.nextLine();
        System.out.printf("Enter the passout year: ");
        int y1 = sc.nextInt();
        System.out.printf("Enter the current study year: ");
        Integer curr_year = sc.nextInt();
        System.out.println();
        if (s1.equals(d1.getDname())) {
            System.out.println("Department name: " + s);
            d1.method2(y1, curr_year);
        } else if (s1.equals(d2.getDname())) {
            System.out.println("Department name: " + s);
            d2.method2(y1, curr_year);
        } else {
            System.out.println("Department name: " + s);
            d3.method2(y1, curr_year);
        }

        System.out.println();
        System.out.printf("\nEnter the department name: ");
        String s2 = sc.nextLine();
        System.out.printf("Enter the passout year: ");
        int y2 = sc.nextInt();
        System.out.println();
        if (s2.equals(d1.getDname()))
            d1.method3(y2);
        else if (s2.equals(d2.getDname()))
            d2.method3(y2);
        else
            d3.method3(y2);

        System.out.println();
        System.out.printf("\nEnter the passout year: ");
        int y3 = sc.nextInt();
        System.out.println();
        if (d1.getMaxCGPA(y3) >= d2.getMaxCGPA(y3) && d1.getMaxCGPA(y3) >= d3.getMaxCGPA(y3))
            d1.rollNameDeptHOD();
        else if (d2.getMaxCGPA(y3) >= d1.getMaxCGPA(y3) && d2.getMaxCGPA(y3) >= d3.getMaxCGPA(y3))
            d2.rollNameDeptHOD();
        else if (d3.getMaxCGPA(y3) >= d2.getMaxCGPA(y3) && d3.getMaxCGPA(y3) >= d1.getMaxCGPA(y3))
            d3.rollNameDeptHOD();

        System.out.println();
        System.out.printf("\nEnter the CGPA value: ");
        double d = sc.nextDouble();
        System.out.printf("Enter the passout year: ");
        int y4 = sc.nextInt();
        System.out.println();
        d1.method5(d, y4);
        d2.method5(d, y4);
        d3.method5(d, y4);

        System.out.println();
        System.out.printf("\nEnter the CGPA value: ");
        double dd1 = sc.nextDouble();
        System.out.println();
        d1.method6(dd1);
        d2.method6(dd1);
        d3.method6(dd1);

        sc.close();
    }
}