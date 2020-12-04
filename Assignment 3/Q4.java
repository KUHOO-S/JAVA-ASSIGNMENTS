/*4. Write a program to demonstrate the knowledge of students in JDBC. 
Eg: Create a student table with fields roll number, name, percentage. Insert values in the
table. Display all the details of the student table in a tabular format on the screen. */

import java.sql.*;
class Q4
{
public static void main(String a[]) throws Exception
{
Connection con;
Statement x;
ResultSet result;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/java","kuhoo","kuhoopc");
x=con.createStatement();
x.executeUpdate("create table student(regno varchar(20) primary key,name varchar(20),marks int)");
x.executeUpdate("insert into student values('18BIT0101','Kuhoo',97)");
x.executeUpdate("insert into student values('18BCB0080','Siddharth',43)");
x.executeUpdate("insert into student values('18BIT0989','Saurav',81)");
result=x.executeQuery("select * from student");
System.out.println("\nREGNO no \t NAME \t MARKS ");
while(result.next())
System.out.println("\n"+result.getString(1)+" \t "+result.getString(2)+" \t"+result.getInt(3));
}
}