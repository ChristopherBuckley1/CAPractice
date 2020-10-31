package Work.Countries;

public class County {
    private String name;
    private int population;
    private Town towns[];

    public County(String name,int population,Town towns[]){
        setName(name);
        setPopulation(population);
        setTowns(towns);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        int num =0;
        for(int i=0;i<towns.length;i++)
        {
            num += towns[i].getPopulation();
        }
        return num;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Town[] getTowns() {
        return towns;
    }

    public void setTowns(Town[] towns) {
        this.towns = towns;
    }

    public String toString(){
        String str = "\nName: " + getName() +" Population: "+getPopulation()+"\nList of Towns:\n\n";

        if (towns == null) {
            str += "No town specified";
            return str;
        }

        for (int i = 0; i < getTowns().length; i++)
            if (towns[i] != null)
                str += towns[i] + "\n";

        return str;


    }
}
