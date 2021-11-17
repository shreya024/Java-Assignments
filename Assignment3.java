/*Create a student class with roll_no, name, department name and 4 years CGPA.
Create another class as teacher with teacher name, dept name and project name
as the data members. Provide constructor and suitable show() functions for both
these classes. Now establish relationships between both these classes
(association/aggregation) and perform the following queries with array of
objects.

1. List all the students (roll_no and name) who are studying in the CSE dept.

2. List all the students (roll_no and name, dept name) who obtained CGPA >8.0 in
4th year.

3. Teacher name will be taken as input and list all the students (roll_no, name,
dept name) who are carrying out projects under that teacher.

4. List the teachers (teacher name, dept name) who are guiding projects on a
specific topic taken as keyboard input

5. List the students (roll_no and name, dept name) who are carrying out projects
on a specific topic taken as keyboard input*/

import java.io.*;
import java.util.*;

class student {
    int roll_no;
    int[] four_year_cgpa = new int[4];;
    String name, departmentName, projectName;

    student(int r, int[] cgpa, String nm, String dp, String pn) {
        roll_no = r;
        for (int i = 0; i < 4; i++) {
            four_year_cgpa[i] = cgpa[i];
        }

        name = nm;
        departmentName = dp;
        projectName = pn;
    }

    student() {
        roll_no = 0;
        for (int i = 0; i < 4; i++) {
            four_year_cgpa[i] = 0;
        }
        name = "";
        departmentName = "";
        projectName = "";
    }

    void show() {
        System.out.println(roll_no);
        for (int i = 0; i < 4; i++) {
            System.out.println(four_year_cgpa[i]);
        }

        System.out.println(name);
        System.out.println(departmentName);
        System.out.println(projectName);
    }

    void show_cse(student s[]) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].departmentName.equals("CSE")) {
                System.out.println("Name: " + s[i].name + " Roll: " + s[i].roll_no);
            }
        }
    }

    void show_cgpa(student s[]) {
        for (int i = 0; i < s.length; i++) {

            if (s[i].four_year_cgpa[3] > 8) {
                System.out.println(
                        "Name: " + s[i].name + " Roll: " + s[i].roll_no + " Department: " + s[i].departmentName);
            }

        }
    }

    void show_teacher(student s[]) {
        for (int i = 0; i < s.length; i++) {

            System.out.println("Name: " + s[i].name + " Roll: " + s[i].roll_no + " Department: " + s[i].departmentName);

        }
    }

    void show_topic(student s[], String topic) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].projectName.equals(topic))
                System.out.println(
                        "Name: " + s[i].name + " Roll: " + s[i].roll_no + " Department: " + s[i].departmentName);

        }
    }
}

class teacher {
    String name, departmentName, projectName;

    teacher(String nm, String dp, String pn) {
        name = nm;
        departmentName = dp;
        projectName = pn;

    }

    teacher() {
        name = "";
        departmentName = "";
        projectName = "";
    }

    void show() {
        System.out.println(name);
        System.out.println(departmentName);
        System.out.println(projectName);
    }

    void show_topic(teacher t[], String topicName) {
        for (int i = 0; i < t.length; i++) {
            if (t[i].projectName.equals(topicName)) {
                System.out.println("Name: " + t[i].name + " Department: " + t[i].departmentName);
            }
        }
    }

}

public class Assignment3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of Students : ");
        int n = sc.nextInt();
        student s[] = new student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number : ");
            int a = sc.nextInt();
            int[] cgpa = new int[4];
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter CGPA of year " + j + ": ");
                cgpa[j] = sc.nextInt();
            }
            System.out.print("Enter Name: ");
            String nm = "";
            nm = br.readLine();
            System.out.print("Enter Department Name: ");
            String dp = "";
            dp = br.readLine();
            System.out.print("Enter Project Name: ");
            String pn = "";
            pn = br.readLine();
            s[i] = new student(a, cgpa, nm, dp, pn);

        }

        student cse = new student();
        System.out.println("\n Students in CSE: ");
        cse.show_cse(s);
        System.out.println("\n Students with more than 8 CGPA: ");
        cse.show_cgpa(s);

        System.out.println("Enter the number of Teachers : ");
        int tn = sc.nextInt();
        teacher t[] = new teacher[tn];
        for (int i = 0; i < tn; i++) {

            System.out.print("Enter Name: ");
            String nm = "";
            nm = br.readLine();
            System.out.print("Enter Department Name: ");
            String dp = "";
            dp = br.readLine();
            System.out.print("Enter Project Name: ");
            String pn = "";
            pn = br.readLine();
            t[i] = new teacher(nm, dp, pn);

        }

        System.out.println("\n\nEnter the name of the teacher: ");
        String teach = br.readLine();
        System.out.println("Students under this teacher " + teach + ": ");
        for (int i = 0; i < tn; i++) {
            if (teach.equals(t[i].name)) {
                for (int j = 0; j < n; j++) {
                    if (t[i].projectName.equals(s[j].projectName))
                        s[j].show_teacher(s);
                }

            }

        }

        System.out.println("\n\nEnter the Topic: ");
        String project = br.readLine();
        teacher topic = new teacher();
        System.out.println("Teachers under this topic: ");
        topic.show_topic(t, project);

        System.out.println("\n\nEnter the Project: ");
        project = br.readLine();
        student pn = new student();
        System.out.println("Students performing this project: ");
        pn.show_topic(s, project);

        sc.close();
    }
}
