package random.capractice1;

public final class SelfEmployedWorker extends Employee{
    private double estimatedIncome;

    public SelfEmployedWorker(String firstName,String lastName,double estimatedIncome)
    {
        super(firstName,lastName);
        setEstimatedIncome(estimatedIncome);
    }

    public void setEstimatedIncome(double estimatedIncome){
        int upperBound = 900;
        int lowerBound = 400;
        double number = lowerBound + (int)(Math.random() * ((upperBound - lowerBound)+1));
        estimatedIncome = number;
        this.estimatedIncome = estimatedIncome;
    }
    public double earnings(){return estimatedIncome;}
    public String toString() {
        return "Self employed worker's name is " + super.toString();
    }

}
