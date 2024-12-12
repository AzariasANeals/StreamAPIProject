import java.util.*;
import java.util.stream.Collectors;

/**
 * This is the StreamExample class. It will be where we will be 
 * running our program demo from.
 */
public class StreamExample
{
    public static final int LIST_SIZE = 10;

    public static void main(String args[])
    {
        List<Integer> testIntList = new ArrayList<>();
        System.out.println(""); 
        System.out.println("Creating initial list of integers.");
        System.out.println("Our empty initial List: " + testIntList);
        fillArrayListInts(testIntList);
        System.out.println("Our filled initial List: " + testIntList);
        System.out.println(""); 

        System.out.println("Demonstrating Filtering by Showing only Even Numbers");
        System.out.println("Even Numbers: " + showEvenNumbers(testIntList));
        System.out.println(""); 

        System.out.println("Demonstrating Mapping by showing squares of all the numbers.");
        System.out.println("Original List: " + testIntList);
        System.out.println("Squares: " + showSquares(testIntList));
        System.out.println(""); 

        System.out.println("Demonstrating Filtering and Mapping Combined by showing the cubes of odd numbers only.");
        System.out.println("Original List: " + testIntList);
        System.out.println("Cubes: " + showCubesOfOdds(testIntList));
        System.out.println(""); 

        System.out.println("Demonstrating Reducing by Getting the total of all the integers.");
        System.out.println("Original List: " + testIntList);
        System.out.println("Total: " + sumListOfNumbers(testIntList));
        System.out.println(""); 

        System.out.println("Using Collect to create a new list of even numbers");
        List<Integer> even = testIntList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Original List: " + testIntList);        
        System.out.println("Even Numbers: " + even);  
        System.out.println("Showing both lists: " + "Original: " + testIntList + " Even Only: " + even);
        System.out.println(""); 

        // Here we create a List of Lists
        // This is used for testing flatmap. 
        System.out.println("Creating a List of Lists.");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(4,5,8,10),
                Arrays.asList(9,3,2,1),
                Arrays.asList(23, 21, 14, 6),
                Arrays.asList(31,18,7,54));
        System.out.println("Showing the table");
        System.out.println(listOfLists);
        System.out.println(""); 

        System.out.println("Showing Flatting Method to Create Single List");
        List<Integer> singleList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Single List: " + singleList);
        System.out.println(""); 

        System.out.println("Demonstrating how to Use Group By to Split a List into Categories");
        Map<String, List<Integer>> evenOdd = singleList.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even": "Odd"));
        System.out.println(evenOdd);
        System.out.println(""); 

        System.out.println("Demonstrating Using Stream on Custom Classes");
        Person p1 = new Person("Andy", 41);
        Person p2 = new Person("Able", 21);
        Person p3 = new Person("Martha", 55);
        Person p4 = new Person("Sam", 18);
        Person p5 = new Person("Joe", 56);
        List<Person> studyGroup = new ArrayList<>();
        studyGroup.add(p1);
        studyGroup.add(p2);
        studyGroup.add(p3);
        studyGroup.add(p4);
        studyGroup.add(p5);
        System.out.println("Original Study Group List");
        System.out.println(studyGroup);
        System.out.println("Showing Who is Over 25");
        studyGroup.stream().filter(p -> p.getAge() > 25).forEach(pn -> System.out.println(pn.getName()));
        System.out.println();

        System.out.println("This shows us who is oldest");
        System.out.println(studyGroup.stream().max(Person::compareTo));

        
    }
    public static void fillArrayListInts(List<Integer> list)
    {
        if(list != null)
        {
            for(int i = 1; i <= 10; i++)
            {
                list.add(i);
            }
        }
    }

    
    // provided for unit tests 
    public static int sumListOfNumbers(List<Integer> list)
    {
        int sum = list.stream().reduce(0, (x,y) -> x + y);

        return sum;
    }

    public static String showEvenNumbers(List<Integer> list)
    {
        List<Integer> even = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return even.toString();
    }

    public static String showSquares(List<Integer> list)
    {
        List<Integer> squared = list.stream().map(i -> i * i).collect(Collectors.toList());
        return squared.toString();
    }

    public static String showCubesOfOdds(List<Integer> list)
    {
        List<Integer> cubed = list.stream().filter(i -> i % 2 > 0).map(i -> i * i * i).collect(Collectors.toList());
        return cubed.toString();
    }
}
