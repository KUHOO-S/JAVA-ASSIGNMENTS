/*
Q3. Write a program to demonstrate the knowledge of students in Inheritance. Eg: Assume
that a bank maintains two kinds of accounts for customers, one called as savings account
and the other as current account. The savings account provides compound interest and
withdrawal facilities but no cheque book facility. The current account provides cheque
book facility but no interest. Current account holders should maintain a minimum balance
and if the balance falls below this level, a service charge is imposed. Create a class
account that stores customer name, account number and type of account. From this derive
the classes cur_acct and sav_acct to make them more specific to their requirements.
Include necessary member functions in order to achieve the following tasks: a) Accept
deposit from a customer and update the balance. b) Display the balance c) Compute and
deposit interest. d) Permit withdrawal and update the balance. e) Check for the minimum
balance, impose penalty, necessary, and update the balance.*/

import java.util.*;
class account{
String customername;
int accno;
String type;
int bal;
Scanner s=new Scanner(System.in);
public account(String t){
System.out.println("Enter name ");
customername=s.nextLine();
System.out.println("\nEnter account number : ");
accno=s.nextInt();
type=t;
System.out.println("\nEnter balance");
bal=s.nextInt();
}
void display(){
System.out.println("Customer name:"+customername);
System.out.println("Account number:"+accno);
System.out.println("Type of account:"+type);
System.out.println("Balance:"+bal);
}
void deposit(){
int amount;
System.out.println("\n \nEnter the amount to deposit");
amount=s.nextInt();
bal+=amount;
}
}
class saving extends account{
private double i;
public saving (String t){
super(t);
System.out.print("\nCalculating Cmpound Interest");
i=compound_int();
bal+=i;
System.out.println("Interest:"+i);
System.out.println("New Balance:"+bal);
}
int compound_int(){
int t,r;
r=10;
System.out.println("\nEnter time ");
t=s.nextInt();
i=bal*(Math.pow(1+r/100.0,t))-bal;
return (int) i;
}
void update_bal(){
bal=bal+compound_int();
}
void withdrawal(){
int amount;
System.out.println("\nEnter amount to withdrawn");
amount=s.nextInt();
if(bal>=amount){
bal=bal-amount;
}
else{
System.out.println("\nThe amount cannot be withdrawn");
}
}
}
class current extends account{
public current (String t){
super(t);
display();
}
private int chq_bk;
private int penality;
void min_bal(){
if(bal<=500){
penality=50;
bal=bal-penality;
System.out.println("penality imposed Rs "+penality);
}
else{
System.out.println("No penality imposed");
}
}
void withdrawal(){
int amount;
System.out.println("\nEnter the amount to withdrawn");
amount=s.nextInt();
if(bal>=amount)
bal=bal-amount;
else
System.out.println("\nThe amount cannot be withdrawn");
min_bal();
}
};
class Q3{
public static void main(String[]args) {
System.out.print("Welcome to Bank\n Press 0 for current and 1 for savings\n");
String t;
Scanner sc=new Scanner(System.in);
int x=sc.nextInt();
if(x==1)
{t="savings";
saving s = new saving(t);
s.deposit();
s.display();
s.withdrawal();
s.display();
}
else
{t="current";
current c = new current(t);
c.deposit();
c.display();
c.withdrawal();
c.display();
}
}}