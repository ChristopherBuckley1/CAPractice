package random.capractice1;

public class TestPolymorphism {
    public static void main(String[] args) {
        Employee employees[] = new Employee[3];

        Employee employeeRef;

        Boss b1 = new Boss("Joe","Smith",750.50);
        HourlyWorker hw1 = new HourlyWorker("Mary","O'Neill",8.5,49.5);
        SelfEmployedWorker sw1 = new SelfEmployedWorker("Chris","Buckley",0);

        employeeRef=b1;
        employees[0] = employeeRef;
        System.out.println(employeeRef.toString() + " and the earnings were €" + String.format("%.2f",employeeRef.earnings()));
        employees[1] = hw1;
        System.out.println("\n" + employeeRef.toString() + " and the earnings were €" + String.format("%.2f",employeeRef.earnings()));
        employeeRef = sw1;
        employees[2] = employeeRef;
        System.out.println("\n"+employeeRef.toString() +" amd his earnings were: €" + String.format("%.2f",employeeRef.earnings()));
        for(int i = 0; i< employees.length;i++)
        {
            System.out.println(employees[i].toString()+" and the earnings were: $"+String.format("%.2f",employees[i].earnings()));
        }

    }
}
