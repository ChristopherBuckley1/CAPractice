package random.capractice1;

public final class Boss extends Employee{
    private double weeklySalary;

    public Boss(String firstName,String lastName, double weeklySalary)
    {
        super(firstName,lastName);
        setWeeklySalary(weeklySalary);
    }
    public void setWeeklySalary(double weeklySalary)
    {
        if(weeklySalary > 0)
            this.weeklySalary=weeklySalary;
        else
            this.weeklySalary = 0;
    }

    public double earnings(){return weeklySalary;}

    public String toString(){return "Boss' name is "+ super.toString();}
}
