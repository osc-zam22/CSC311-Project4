import java.lang.Exception;
public class City implements Comparable<City> 
{
    // private field that holds info
    private String name;
    private double longitude, latitude;
    private int population;

    // default constructor
    public City(){}

    public City(String name , double longitude , double latitude , int population)
    {
        this.setName(name);
        this.setLongitude(longitude);
        this.setLatitude(latitude);
        try {
            this.setPop(population);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Not a valid population, must be equal to or greater than 0");
        }
    }

    // setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setLongitude(double longitude) 
    {
        this.longitude = longitude;
    }
    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }
    public void setPop(int pop) throws Exception
    {
        if(pop < 0){
            throw new Exception();
        }

        this.population = pop;
    }

    // getters
    public String getName()
    {
        return this.name;
    }

    public double getLatitude()
    {
        return this.latitude;
    }
    public double getLongtitude()
    {
        return this.longitude;
    }
    public int getPop()
    {
        return this.population;
    }



    @Override
    public int compareTo(City anotherCity) {
        return this.getName().compareTo(anotherCity.getName());
    }

    @Override
    public String toString(){
        String out = String.format("City: %s Location Latitude: %f Longitude: %f Population: %d", 
            this.name , this.latitude , this.longitude , this.population);
        return out;
    }

}
