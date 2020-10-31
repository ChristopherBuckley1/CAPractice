package Work.Countries;

public class Country {
    private String name;
    private int population;
    private County counties[];
    private County capital;

    public Country(String name,int population,County counties[],County capital){
        setName(name);
        setPopulation(population);
        setCounties(counties);
        setCapital(capital);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public County[] getCounties() {
        return counties;
    }

    public void setCounties(County[] counties) {
        this.counties = counties;
    }

    public County getCapital() {
        return capital;
    }

    public void setCapital(County capital) {
        this.capital = capital;
    }

    public String toString(){
        String str = "Name: "+getName()+" \nCapital: "+getCapital().getName()+" \n\nNow printing list of counties.... \n";
        for(int i =0; i < counties.length;i++)
        {
            str += counties[i]+"\n";
        }
        return str;
    }
}
