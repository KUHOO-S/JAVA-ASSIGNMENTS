/*Q2. Write a program to demonstrate the knowledge of students in String handling. A hash
algorithm uses rotation and fold shift methods to compute the address at which the user
input has to be stored. Define a static method to perform rotation of the data by moving
the least significant digit to the most significant bit position. Also define a non-static
method to perform fold shift by dividing the rotated data into segments of length 2 and
then add all the segments to get the hash address. If the sum has more than 2 digits,
delete the most significant digit and the resulting number is the address. Invoke these
methods from main( ) method. Eg., If the data is 112286, after rotation it should be 611228
and after fold shift it should be 61 + 12 + 28=101 =01 (after deleting the most significant
digit) */

import java.util.*;
class Stringdata{
void Hashfunction(String data){
int i,j,x,sum=0;
for(i=0;i<data.length();i+=2){
j=i+2>=data.length()?data.length():i+2;
sum =sum +Integer.parseInt(data.substring(i, j));
}
String add = String.valueOf(sum);
if (add.length()>2) add = add.substring(1, add.length());
System.out.println("\nThe address calculated by shift fold is "+add);
}
static String rotate(String data){
String r = data.substring(data.length()-1); // making lsb as msb
r = r.concat(data.substring(0, data.length()-1));
System.out.println("\nThe rotated string is "+r);
return r;
}
}
class Q2 {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
String n = sc.nextLine();
Stringdata x = new Stringdata();
String rotated =x.rotate(n);
x.Hashfunction(rotated);
}
}