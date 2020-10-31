package linearSearch.exercise2;

public class testCollegeApp {
    public static void main(String[] args) {
        Student student1 = new Student(154345,"Jake","Computing");
        Student student2 = new Student(234532,"Mary","Creative media");
        Student student3 = new Student(453726,"Tommy","Computing");
        Student student4 = new Student(623456,"Peter","Creative media");

        Student computingStudents[] = new Student[10];
        computingStudents[0] = student1;
        computingStudents[1] = student3;

        Student mediaStudents[] = new Student[10];
        mediaStudents[0] = student2;
        mediaStudents[1] = student4;

        Department computing = new Department("Computing",computingStudents);
        Department media = new Department("Creative Media",mediaStudents);

        Department departments[] = new Department[5];
        departments[0] = computing;
        departments[1] = media;

        Institute itTralee = new Institute("Intstitute of technology Tralee",departments);

        System.out.println(itTralee.toString());

        System.out.println("Total students in the institute: " + itTralee.getTotalStudents());

        System.out.println("\nMoving Jake to Creative Media department!");

        int mediaSub=-1,compSub=-1;
        Student[] studentSearch;

        for(int i = 0;i< departments.length;i++){
            if(departments[i]!=null)
            {
                if(departments[i].getName().equals("Computing"))
                    compSub=i;
                if(departments[i].getName().equals("Creative Media"))
                    mediaSub=i;
            }
        }
        if(compSub!=-1&&mediaSub!=-1){
            studentSearch = departments[compSub].getStudents();
            for(int j=0;j<studentSearch.length;j++)
            {
                if(studentSearch[j]!=null)
                {
                    if(studentSearch[j].getId()==154345)
                    {
                        System.out.println("\n\nJake Found!");
                        studentSearch[j].setDepartment("Creative Media");
                        departments[mediaSub].getStudents()[2]=studentSearch[j];
                        studentSearch[j] = null;
                        break;
                    }
                    else System.out.println("\n\nJake Not Found! ");
                }
            }
        }

        System.out.println("\n\n"+itTralee.toString());
    }
}
