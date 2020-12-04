/*Q1. Write a program to demonstrate the knowledge of students in
working with user-defined packages and sub-packages. Eg., Within
the package named primespackage, define a class Primes which
includes a method checkForPrime() for checking if the given number
is prime or not. Define another class named TwinPrimes outside of
this package which will display all the pairs of prime numbers whose
difference is 2. (Eg, within the range 1 to 10, all possible twin prime
numbers are (3, 5), (5,7)). The TwinPrimes class should make use of
the checkForPrime() method in the Primes class.
*/
import primespackage.Prime;
import java.util.Scanner;
public class Q1 {
    public static void main(String args[]) {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();
        sc.close();
        System.out.println("Twin prime numbers are: ");
        for(i = n1; i <= n2; i++){ 
            if(Prime.checkPrime(i) & Prime.checkPrime(i+2) & i > 1)
            {System.out.println("(" + i + "," + (i+2) + ")");}
        }
    }
}