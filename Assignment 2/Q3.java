/*Q3. Write a program to demonstrate the knowledge of students in Inheritance. Eg.,
Three students A, B and C of B.Tech- II year contest for the PR election. With the
total strength of 240 students in II year, simulate the vote casting by generating 240
random numbers (1 for student A, 2 for B and 3 for C) and store them in an array.
Create four threads to equally share the task of counting the number of votes cast
for all the three candidates. Use synchronized method or synchronized block to
update the three count variables. The main thread should receive the final vote
count for all three contestants and hence decide the PR based on the values
received.*/

import p.*;
import java.util.Vector;
class Q3 {
 public static void main(String[] args) {
 Vector votevec = new Vector(240);
 vote a = new vote(1, votevec);
 a.start();
 vote b = new vote(2, votevec);
 b.start();
 vote c = new vote(3, votevec);
 c.start();
 try{
 a.join();
 b.join();
 c.join();
 System.out.println("Voting has ended!");
 }catch(Exception e){System.out.println(e);}
 count ac = new count(1, votevec);
 count bc = new count(2, votevec);
 count cc = new count(3, votevec);
 ac.start();
 bc.start();
 cc.start();
 try{
 ac.join();
 bc.join();
 cc.join();
 System.out.println("Counting has ended!");
 }catch(Exception e){System.out.println(e);}
 int av = ac.count;
 int bv = bc.count;
 int cv = cc.count;
 System.out.println("elections.Vote Vector:" + "\n" + votevec);
 System.out.println(av + " votes for A");
 System.out.println(bv + " votes for B");
 System.out.println(cv + " votes for C");
 if(av >= bv && av >= cv){
 if(av == bv || av == cv)
 System.out.println("Tie in elections!");
 else
 System.out.println("A has won the elections!");
 }
 else if(bv >= av && bv >= cv){
 if(av == bv || bv == cv)
 System.out.println("Tie in elections!");
 else
 System.out.println("B has won the elections!");
 }
 else if(cv >= av && cv >= bv){
 if(cv == bv || cv == av)
 System.out.println("Tie in elections!");
 else
 System.out.println("C has won the elections!");
 }
 }
}