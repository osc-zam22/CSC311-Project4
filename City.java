import java.lang.Exception;
public class City 
{
    // private field that holds info
    private String name;
    private double longitude, latitude;
    private int population;

    // default constructor
    public City(){}

    public City(String name , double longitude , double latitude , int population)
    {
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
}
