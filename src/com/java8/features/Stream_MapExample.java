package com.java8.features;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;

enum Gender { MALE, FEMALE }
class Person {
	  private final String name;
	  private final Gender gender;
	  private final int age;
	  
	  public Person(String theName, Gender theGender, int theAge) {
	    name = theName;
	    gender = theGender;
	    age = theAge;
	  }
	  
	  public String getName() { 
	    return name; 
	  }
	  public int getAge() { 
	    return age; 
	  }
	  public Gender getGender() { return gender; }
	  
	  public String toString() {
	    return String.format("%s -- %s -- %d", name, gender, age);
	  }  
	}

public class Stream_MapExample {
  public static List<Person> createPeople() {
    return Arrays.asList(
	    new Person("Sara", Gender.FEMALE, 20),
	    new Person("Sara", Gender.FEMALE, 22),
	    new Person("Bob", Gender.MALE, 20),
	    new Person("Paula", Gender.FEMALE, 32),
	    new Person("Paul", Gender.MALE, 32),
	    new Person("Jack", Gender.MALE, 2),
	    new Person("Jack", Gender.MALE, 72),
	    new Person("Jill", Gender.FEMALE, 12)
	  );
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();
    
    //create a Map with name and age as key(Composite Key get Unique), and the person as value.
    
    System.out.println(
      people.stream()
            .collect(toMap(
              person -> person.getName() + "-" + person.getAge(),
              person -> person)));
  }
}
