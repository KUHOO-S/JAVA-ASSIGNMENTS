/*Q2.Write a program to demonstrate the knowledge of students in Java Exception
handling. Eg., Read the Register Number and Mobile Number of a student. If the
Register Number does not contain exactly 9 characters or if the Mobile Number
does not contain exactly 10 characters, throw an IllegalArgumentException. If the
Mobile Number contains any character other than a digit, raise a
NumberFormatException. If the Register Number contains any character other
than digits and alphabets, throw a NoSuchElementException. If they are valid,
print the message valid else invalid.
*/

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Q2{
 static void validate(String r, String n){
 if(r.length() != 9){
 System.out.println("Invalid");
 throw new IllegalArgumentException("Register Number does not contain exactly 9 characters");
 }
 if(n.length() != 10){
 System.out.println("Invalid");
 throw new IllegalArgumentException("Mobile Number does not contain exactly 10 characters");
 }
 String pattern = "^[6|7|8|9]{1}\\d{9}";
 Pattern a = Pattern.compile(pattern);
 Matcher m1 = a.matcher(n);
 if(!m1.find()){
 throw new NumberFormatException("Mobile Number cannot contain any character other than a digit");
 }
 String pattern2 = "^[1-9]{2}[A-Z]{3}[0-9]{4}$";
 Pattern b = Pattern.compile(pattern2);
 Matcher m2 = b.matcher(r);
 if(!m2.find()){
 throw new NoSuchElementException("Registration Number cannot contain any character other than digits and alphabets");
 }
 }
 public static void main(String args[]){
 Scanner sc = new Scanner(System.in);
 String reg = sc.nextLine();
 String no = sc.nextLine();
 sc.close();
 validate(reg, no);
 System.out.println("Valid");
 }
}