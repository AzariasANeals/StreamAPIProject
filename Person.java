
/**
 * This is the Person class. It implements Comparable.
 */
public class Person implements Comparable
{
    public final static int MIN_AGE = 0;
    public final static int MAX_AGE = 130;
    public final static int INVALID_AGE = -1;
    private String name;
    private int age;
    
    
    public Person(String name, int age)
    {
        setName(name);
        setAge(age);
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAge(int age)
    {
        if(MIN_AGE <= age && age <= MAX_AGE)
        {
            this.age = age;
        }
        else
        {
            this.age = INVALID_AGE;
        }        
    }
    
    public String toString()
    {
        if(age == INVALID_AGE)
        {
            return "Name: " + name + " Age: unavailable\n";
        }
        return "Name: " + name + " Age: " + age + "\n";
    }
    
    @Override
    public int compareTo(Object o)
    {
        int buf = ((Person)o).getAge();
        return age == buf?0: age>buf?1:-1;
    }
}
