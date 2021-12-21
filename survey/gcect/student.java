package survey.gcect;

public class student {
    int roll_no, sem, project_id;
    String name, departmentName;

    public student(int r, int s, int pid, String nm, String dp) {
        roll_no = r;
        sem = s;
        project_id = pid;
        name = nm;
        departmentName = dp;
    }

    public student() {
        roll_no = 0;
        sem = 0;
        project_id = 0;
        name = "";
        departmentName = "";

    }

    public void show_details(student s[], int roll) {
        for (int i = 0; i < s.length; i++) {
            if (roll == s[i].roll_no)
                System.out.println(
                        "Name: " + s[i].name + " Roll: " + s[i].roll_no + " Department: " + s[i].departmentName
                                + "Project ID:" + s[i].project_id);

        }
    }

    public int display_project_id(student s[], int roll) {
        for (int i = 0; i < s.length; i++) {
            if (roll == s[i].roll_no) {
                return s[i].project_id;
            }
        }
        return 0;
    }

    public void show_students(student s[], int pid) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].project_id == pid) {
                System.out.println(s[i].name);
            }
        }
    }
}
