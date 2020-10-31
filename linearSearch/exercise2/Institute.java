package linearSearch.exercise2;

public class Institute {
    private String name;
    private Department departments[];

    public Institute(String name,Department departments[])
    {
        setDepartments(departments);
        setName(name);
    }

    public void setDepartments(Department departments[]) {this.departments = departments;
    }

    public void setName(String name) {this.name = name;
    }

    public Department[] getDepartments(){
        return departments;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        String str = "Name: " + getName() + "\n\nDepartments:";

        if(departments==null)
        {
            str+="No department specified";
            return str;
        }

        for(int i=0; i<getDepartments().length; i++)
            if(departments[i]!=null)
                str+=departments[i];

        return str;

    }

    public int getTotalStudents()
    {
        int noOfStudents = 0;
        Student[] students;

        for(int i=0; i< departments.length; i++) {

            if(departments[i] != null) {
                students = departments[i].getStudents();

                for(int j=0; j<students.length; j++) {

                    if(students[j] != null)
                        noOfStudents++;
                }
            }
        }
        return noOfStudents;
    }
}

