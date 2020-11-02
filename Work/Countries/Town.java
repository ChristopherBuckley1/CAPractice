package Work.Countries;

public class Town {
    private String name;
    private int population;
    private String county;

    public Town(String name,int population, String county){
        setName(name);
        setPopulation(population);
        setCounty(county);

    }
    public Town()
    {
        setName("No NAme");
        setPopulation(0);
        setCounty("Dublin");
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String toString()
    {   String populationFormatted = String.format("%,d",getPopulation());
        return "Town Name: "+getName()+"\nPopulation: "+populationFormatted+"\nCounty: "+getCounty()+"\n";
    }
}
