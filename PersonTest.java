

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    Person testerOne;
    Person invalidAge;
    Person nullName;
    final String nameOne = "Joshua";
    final String nameTwo = "Kevin";
    final String nameThree = null;
    final int ageOne = 55;
    final int ageInvalid = 150;
    final int ageTwo = 26;
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
    {

        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        testerOne = new Person(nameOne,ageOne);
        invalidAge = new Person(nameTwo, ageInvalid);
        nullName = new Person(nameThree, ageTwo);        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    // 3 normal cases
    @Test
    public void testGetAge()
    {
        int expected = ageOne;
        int actual = testerOne.getAge();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetName()
    {
        String expected = nameOne;
        String actual = testerOne.getName();
        
        assertEquals(expected, actual);
    }   
    
    @Test
    public void testSetAge()
    {
        int expected = 89;
        testerOne.setAge(expected);
        int actual = testerOne.getAge();
        
        assertEquals(expected, actual);
    }   
    
    // 3 edge cases
    @Test
    public void testInvalidGetAge()
    {
        int expected = Person.INVALID_AGE;
        int actual = invalidAge.getAge();
        
        assertEquals(expected, actual);
    }    
    
    @Test
    public void testInvalidSetAge()
    {
        int expected = Person.INVALID_AGE;
        testerOne.setAge(200);
        int actual = testerOne.getAge();
        
        assertEquals(expected, actual);
    }    
    
    @Test
    public void testNullGetName()
    {
        String expected = null;
        String actual = nullName.getName();
        
        assertEquals(expected, actual);
    }    
}
