package random.capractice1;

public final class HourlyWorker extends Employee {

    private double wage;
    private double hours;

    public HourlyWorker(String firstName,String lastName,double wage, double hours){
        super(firstName,lastName);
        setWage(wage);
        setHours(hours);
    }

    public void setWage(double wage){
        if(wage>0)
            this.wage=wage;
        else
            this.wage=0;
    }

    public void setHours(double hours){
        if(hours>0)
            this.hours=hours;
        else
            this.hours = 0;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    public double earnings(){return getWage()*getHours();}

    public String toString() {
        return  "Hourly worker's name is " + super.toString() +
                ", hours worked were " + getHours() +
                ", wage is " + String.format("€%.2f",getWage());
    }
}
