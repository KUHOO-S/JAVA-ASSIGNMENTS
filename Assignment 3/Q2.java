/*Q2. Write a program to demonstrate the knowledge of students in working with Java collection
framework.
Eg., Assume only a maximum of 3 courses can be registered by a student for week end semester
classes. Create a hashmap h1 with n key-value pairs where keys are the names of students
and values are the courses registered by them. Create another hashmap h2 with mkey-value
pairs where keys are the names of courses offered for B.Tech and values are the names of
faculty handling the courses. Write appropriate code to
- Add or remove a student from h1
- Iterate over the maps and display the key-value pairs stored in them
- Given a student name, fetch the names of all those who teach him/her.
 
*/

import java.util.*;
class Q2 {
static Map<String, List<String>> h1 = new HashMap<String, List<String>>();
static Map<String, Integer> h2 = new HashMap<String, Integer>();
static void add_in_h1(String key, List<String> values) {
h1.put(key, values);
//System.out.println("\nh1:");
System.out.println(h1);
}
static void delete_in_h1(String key) {
h1.remove(key);
//System.out.println("\nh1:");
System.out.println(h1);
}
static void findFaculties(String key) {
if (h1.containsKey(key)) {
List<Integer> faculties = new ArrayList<Integer>();
List<String> list = h1.get(key);
Set<String> keys = h2.keySet();
for (String l : list) {
for (String k : keys) {
if (l.equals(k)) {
faculties.add(h2.get(k));
}
}
}
System.out.println(faculties);
} else
System.out.println("No such student");
}
public static void main(String[] args) {
List<String> valSetOne = new ArrayList<String>();
valSetOne.add("English");
valSetOne.add("Hindi");
valSetOne.add("SST");
List<String> valSetTwo = new ArrayList<String>();
valSetTwo.add("SST");
valSetTwo.add("Maths");
List<String> valSetThree = new ArrayList<String>();
valSetThree.add("Maths");
valSetThree.add("Physics");
valSetThree.add("Chemistry");
h1.put("A", valSetOne);
h1.put("B", valSetTwo);
h1.put("C", valSetThree);
h2.put("English", 1);
h2.put("Hindi", 2);
h2.put("SST", 3);
h2.put("Maths", 4);
h2.put("Physics", 5);
h2.put("Chemistry", 6);
System.out.println("\nStudents and Subjects :");
for (Map.Entry<String, List<String>> entry1 : h1.entrySet()) {
String key1 = entry1.getKey();
List<String> values1 = entry1.getValue();
System.out.println("Key = " + key1 + "\t\t\tValue = " + values1);
}
System.out.println("\nSubjects and Teachers code :");
for (Map.Entry<String, Integer> entry2 : h2.entrySet()) {
String key2 = entry2.getKey();
Integer values2 = entry2.getValue();
System.out.println("Key = " + key2 + "\t\tValue = " + values2);
}
int choice =0;
while(choice!=4)
{System.out.println(
"\nEnter choice:\n1 - Add or remove a student from h1\n2 - Iterate over the maps and display the key-value pairs stored in them\n3 - Given a student name, fetch the names of all those who teach him/her\n4 - Exit ");
Scanner sc = new Scanner(System.in);
choice = sc.nextInt();
switch (choice) {
case 1:
System.out.println("\nPress 1 for add\nPress2 for delete :");
int ch = sc.nextInt();
if (ch == 1) {
List<String> val = new ArrayList<String>();
val.add("English");
val.add("Maths");
val.add("Hindi");
System.out.println("\nAdding Student D");
for (String i : val)
System.out.println(i);
add_in_h1("D", val);
}
else {
System.out.println("\nRemoving Student C");
delete_in_h1("C");
}
break;
case 2:
System.out.println("\nh1:");
System.out.println(h1);
break;
case 3:
System.out.println("\nEnter name of student :");
String x = sc.next();
System.out.println("\nTeacher numbers :");
findFaculties(x);
break;
case 4:
System.out.println("Bye");
break;
default:
System.out.println("error wrng input");
}
}
}
}