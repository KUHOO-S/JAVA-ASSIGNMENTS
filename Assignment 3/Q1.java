/*Q1. Write a program to demonstrate the knowledge of students in File handling.
Eg., Define a class Donor to store the below mentioned details of a blood donor.
 Name, age, Address, Contact number, blood group, date of last donation
Create n objects of this class for all the regular donors at Vellore. Write these objects to a
file. Read these objects from the file and display only those donors details whose blood
group is A+ve and had not donated for the recent six months.  */

import java.util.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;
class Donor implements Serializable {
    String name, addr, contact, bldgrp;
    Date date;
    Donor() {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
    String temp;
    String pattern = "[A|B|O|AB][+|-]";
    Matcher m;
    Pattern r = Pattern.compile(pattern);
    System.out.print("\nName: ");
    name = sc.nextLine();
    System.out.print("Address: ");
    addr = sc.nextLine();
    System.out.print("Contact: ");
    contact = sc.nextLine();
    bldgrp = "";
    m = r.matcher(bldgrp);
    while (!m.find()) {
    System.out.print("Blood Group: ");
    bldgrp = sc.nextLine();
    m = r.matcher(bldgrp);
    }
    boolean flag = false;
    while (!flag) {
        System.out.print("Date (dd-mm-yyyy): ");
        temp = sc.nextLine();
        try {
        date = ft.parse(temp);
        flag = true;
        } catch (ParseException e) {
        flag = false;
        System.out.println("Unparseable using " + ft);
        }
    }
    }
}
class Q1 {
    public static void main(String[] args) throws IOException {
    int n, i;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of donors: ");
    n = sc.nextInt();
    Donor d[] = new Donor[n];
    for (i = 0; i < n; i++) {
        System.out.print("\n\nEnter Details of Donor");
        d[i] = new Donor();
    }
    FileOutputStream fos = new FileOutputStream("test.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    for (i = 0; i < n; i++) {
        oos.writeObject(d[i]);
    }
    oos.close();
    FileInputStream fis = new FileInputStream("test.txt");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Donor d1[] = new Donor[n];
    System.out.println("\n\n\nEntries which have A+ and not donated in 6 months\n");
    for (i = 0; i < n; i++) {
        try {
            d1[i] = (Donor) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                }   
        Date now = new Date();
        //System.out.println("n: "+now+"\nd:"+d1[i].date);
        long difference = (now.getTime()-d[i].date.getTime())/86400000;
        long month = difference/30;
        //System.out.println(month);
        if((Math.abs(month)>=6) && d1[i].bldgrp.equals("A+"))
        {
            System.out.println("Donor " + (i+1));
            System.out.println(d1[i].name);
            System.out.println(d1[i].addr);
            System.out.println(d1[i].contact);
            System.out.println(d1[i].bldgrp);
            System.out.println(d1[i].date);
            System.out.println("\n");
        }
    }
    ois.close();
    }
}