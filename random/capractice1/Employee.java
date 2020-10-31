package random.capractice1;

public class Employee {
    private  String firstName;
    private String lastName;

    public Employee(String firstName,String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){return getFirstName() + " " + getLastName();}

    public double earnings(){
        return 0;
    }
}
