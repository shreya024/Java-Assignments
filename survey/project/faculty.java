package survey.project;

public class faculty {
    String name, departmentName, projectTopic;
    int project_id;

    public faculty(String nm, String dp, String pt, int pid) {
        name = nm;
        departmentName = dp;
        projectTopic = pt;
        project_id = pid;

    }

    public faculty() {
        name = "";
        departmentName = "";
        projectTopic = "";
        project_id = 0;
    }

    public void show_faculty(faculty f[], int pid) {
        for (int i = 0; i < f.length; i++) {
            if (f[i].project_id == pid) {
                System.out.println("Name: " + f[i].name + " Department: " + f[i].departmentName);
            }
        }
    }

    public void show_faculty_name(faculty f[], String projectName) {
        for (int i = 0; i < f.length; i++) {
            if (f[i].projectTopic.equals(projectName)) {
                System.out.println("Name: " + f[i].name);
            }
        }
    }

    public void show_project_name(faculty f[], String facultyName) {
        for (int i = 0; i < f.length; i++) {
            if (f[i].name.equals(facultyName)) {
                System.out.println("Project Topic: " + f[i].projectTopic);
            }
        }
    }

    public int show_projectid(faculty f[], String facultyName) {
        for (int i = 0; i < f.length; i++) {
            if (f[i].name.equals(facultyName)) {
                return f[i].project_id;
            }
        }
        return 0;
    }

}
