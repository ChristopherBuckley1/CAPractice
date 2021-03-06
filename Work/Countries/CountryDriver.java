package Work.Countries;

public class CountryDriver {
    public static void main(String[] args) {

        Town t9 = new Town();
        System.out.println(t9.toString());

        Town t1 = new Town("Killarney", 14504, "Kerry");
        Town t2 = new Town("Tralee", 23691, "Kerry");
        Town t3 = new Town("Aglish", 23455, "Waterford");
        Town t4 = new Town("Baltimore", 2345, "Cork");
        Town t5 = new Town("Ardmore", 23453, "Waterford");
        Town t6 = new Town("Ballingeary", 4466, "Cork");
        Town t7 = new Town("Swords", 3248, "Dublin");
        Town t8 = new Town("Tallaght", 76000, "Dublin");

        Town []KerryTowns = new Town[2];
        KerryTowns[0] = t1;
        KerryTowns[1] = t2;

        Town CorkTowns[] = new Town[2];
        CorkTowns[0] = t4;
        CorkTowns[1] = t6;

        Town WaterfordTowns[] = new Town[2];
        WaterfordTowns[0] = t3;
        WaterfordTowns[1] = t5;

        Town DublinTowns[] = new Town[2];
        DublinTowns[0] = t7;
        DublinTowns[1] = t8;


        County Kerry = new County("Kerry", 147707, KerryTowns);
        County Cork = new County("Cork", 23456, CorkTowns);
        County Waterford = new County("Waterford", 34983, WaterfordTowns);
        County Dublin = new County("Dublin", 100000, DublinTowns);


        County counties[] = new County[4];

        counties[0] = Kerry;
        counties[1] = Cork;
        counties[2] = Waterford;
        counties[3] = Dublin;


        Country Ireland = new Country("Ireland", 123456, counties, Dublin);

        System.out.println(Ireland.toString());

        System.out.println("Finding and displaying details of town Killarney");
        int kerryIndex = -1;
        for (int i = 0; i < counties.length; i++) {
            if (counties[i] != null) {
                if (counties[i].getName().equals("Kerry"))
                kerryIndex = i;
                System.out.println("Kerry found!");
                break;
            } else {
                System.out.println("Kerry Not found!");
            }
        }
        Town[] townSearch;
        townSearch = counties[kerryIndex].getTowns();
        if (kerryIndex != -1) {
            for (int j = 0; j < townSearch.length; j++) {
                if (townSearch[j] != null) {
                    if (townSearch[j].getName().equals("Killarney")) {
                        System.out.println("Killarney found!\nNow printing out town details...");
                        System.out.println(townSearch[j].toString());

                    }
                }
            }
        }
        Town allTowns[] = new Town[8];
        allTowns[0] = Kerry.getTowns()[0];
        allTowns[1] = Kerry.getTowns()[1];
        allTowns[2] = Cork.getTowns()[0];
        allTowns[3] = Cork.getTowns()[1];
        allTowns[4] = Dublin.getTowns()[0];
        allTowns[5] = Dublin.getTowns()[1];
        allTowns[6] = Waterford.getTowns()[0];
        allTowns[7] = Waterford.getTowns()[1];


        System.out.println("Now printing the unsorted array of towns..");
        for (int i = 0; i < allTowns.length; i++) {
            if (allTowns[i] != null)
                System.out.println(allTowns[i].toString());

        }
        System.out.println("Now sorting the array of towns");
        selectionSort(allTowns);
        System.out.println("Now printing the sorted list of Towns..\n");
        for(int i=0;i<allTowns.length;i++)
        {
            if(allTowns[i]!=null)
            System.out.println(allTowns[i].toString());
        }


    }

    public static void selectionSort(Town allTowns[]) {
       Town temp,smallest;
       int sub;
       for(int i=0;i<allTowns.length;i++)
       {
           smallest = allTowns[i];
           sub = i;
           for(int j=i+1;j< allTowns.length;j++)
           {
               if(smallest.getPopulation()>allTowns[j].getPopulation())
               {
                   smallest = allTowns[j];
                   sub=j;
               }
           }
           temp = allTowns[i];
           allTowns[i] = allTowns[sub];
           allTowns[sub]=temp;
       }

    }

}

