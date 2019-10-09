
/**
 * HW05_Test
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class HW05_Test {
  // returns a random item out of a string array
  private static String getRandomElement(String[] a) {
    int i = new Random().nextInt(a.length);
    return a[i];
  }

  // returns a random integer in a given range
  // low and high, both inclusive
  private static int getRandomInt(int low, int high) {
    return (new Random().nextInt(high - low)) + 1 + low;
  }

  private static String generateRandomPhoneNumber() {
    // area code
    int d1 = getRandomInt(6, 8);
    int d2 = getRandomInt(3, 6);
    int d3 = getRandomInt(1, 5);

    int d456 = getRandomInt(200, 700);
    int d78910 = getRandomInt(2000, 7000);

    return "(" + d1 + d2 + d3 + ") " + d456 + " " + d78910;
  }

  // checks if entry already exists in the hashtable, and increases it's value by 1 if it does
  // if the entry is new, then initializes it's count to 1
  private static void updateDictionaryCounts(Hashtable<String, Integer> t, String key, Integer value) {
    // update count for this major, if it's already in the collection
    if (t.containsKey(key)) {
      t.replace(key, ++value);
    }
    // set count = 1, for this major (new entry in the dictionary)
    else {
      t.put(key, 1);
    }
  }

  // prints out all students, faculty, and generic person; in that order.
  private static void displayPersonInformation(Person[] people) {
    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Faculty> facultyList = new ArrayList<>();

    for (Person o : people) {
      if (o instanceof Faculty) {
        facultyList.add((Faculty) o);
      }
      else if (o instanceof Student) {
        studentList.add((Student) o);
      }
      else {
        personList.add(o);
      }
    }

    for (Student s : studentList) {
      System.out.println(s);
    }
    for (Faculty f : facultyList) {
      System.out.println(f);
    }
    for (Person p : personList) {
      System.out.println(p);
    }
  } // end displayPersonInformation

  // displays students, with their respective frequencies by major. Shows average GPA
  // displays faculty members, with their respective frequencies by department
  private static void displayPersonsStatisticInfo(Person[] people) {
    int studentCount = 0;
    double totalGpa = 0;
    int facultyCount = 0;
    double avgGpa = 0;
    Hashtable<String, Integer> majors = new Hashtable<>();
    Hashtable<String, Integer> departments = new Hashtable<>();

    
    for (int i = 0; i < people.length; i++) {
      // count students, and aggregate their GPA
      if (people[i] instanceof Student) {
        studentCount++;
        Student s = (Student) people[i];
        totalGpa += s.getGPA();
        updateDictionaryCounts(
          majors, 
          s.getMajor(), 
          majors.getOrDefault(s.getMajor(), null)
        );
      }

      // count faculty
      else if (people[i] instanceof Faculty) {
        facultyCount++;
        Faculty f = (Faculty) people[i];
        updateDictionaryCounts(
          departments, 
          f.getDepartment(), 
          departments.getOrDefault(f.getDepartment(), null)
        );
      }
    }

    avgGpa = totalGpa / studentCount;

    // print out the student and faculty details
    System.out.printf("Total Students: %d%n", studentCount);
    for (String major : majors.keySet()) {
      System.out.printf("   Major %s: %d%n", major, majors.get(major));
    }
    System.out.printf("Average GPA: %.2f%n", avgGpa);

    System.out.printf("Total Faculty: %d%n", facultyCount);
    for (String department : departments.keySet()) {
      System.out.printf("   Department %s: %d%n", department, departments.get(department));
    }
  } // end displayPersonsStatisticInfo

  public static void main(String[] args) {
    final int N = 16;
    Person[] people = new Person[N];
    // arrays used to generate random Person, Student, and Faculty objects
    String[] names = {"John", "Noel", "Mark", "Jane", "Julie", "Fred", "Erin", "Erik"};
    String[] streets = {"Parkway dr", "Parker str", "Oxford Court", "King str", "Green str", "Morris Lane"};
    String[] majors = {"CS", "Math", "EE"};

    for (int i = 0; i < N; i++) {
      String name = getRandomElement(names);
      String address = getRandomInt(1000, 5000) + " " + getRandomElement(streets);
      String gender = (name == "Noel" || name == "Jane" || name == "Julie" || name == "Erin") 
        ? "Female" : "Male";

      // create Person, Student, or Faculty, depending on the value of the generated random
      // 0 = Student, 1 = Faculty, 2 = Person
      switch(new Random().nextInt(3)) {
        case 0:
          people[i] = new Student(
            name, 
            address, 
            getRandomInt(18, 25),    // age
            generateRandomPhoneNumber(),          // phone number
            gender,
            ThreadLocalRandom.current().nextDouble(2, 4),  // gpa (between 2 and 4)
            getRandomElement(majors) // major
          );
          break;
        
        case 1:
          people[i] = new Faculty(
            name, 
            address, 
            getRandomInt(25, 85), // age
            generateRandomPhoneNumber(), // phone number
            gender,
            getRandomElement(majors) // department
          );
          break;

        case 2:
          people[i] = new Person(
            name, 
            address, 
            getRandomInt(1, 85), // age
            generateRandomPhoneNumber(), // phone number
            gender
          );
          break;
      }
    }

    displayPersonsStatisticInfo(people);
    displayPersonInformation(people);
  }
}