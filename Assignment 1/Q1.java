/*Q1. Write a program to demonstrate the knowledge of students in multidimensional arrays
and looping constructs. Eg., If there are 4 batches in BTech learning CSE1007 course,
read the count of the slow learners (who have scored<25 ) in each batch. Tutors should be
assigned in the ratio of 1:4 (For every 4 slow learners, there should be one tutor).
Determine the number of tutors for each batch. Create a 2-D jagged array with 4 rows to
store the count of slow learners in the 4 batches. The number of columns in each row
should be equal to the number of groups formed for that particular batch ( Eg., If there are
23 slow learners in a batch, then there should be 6 tutors and in the jagged array, the
corresponding row should store 4, 4, 4, 4, 4,3). Use for-each loop to traverse the array and
print the details. Also print the number of batches in which all tutors have exactly 4
students.*/
import java.util.*;
class Q1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i,j;
    int[] s = new int[4];
    for(i=0;i<4;i++)
    {System.out.println("\nenter no of slow learners in batch"+(i+1));
    s[i]= sc.nextInt();
    }
    int batchdata[][] = new int[4][];
    int count=0; //to count number of full batches
    for(i=0;i<4;i++)
    { int n=s[i];
    int q=n/4;
    int r=n%4;
    if(r!=0)
    {
    batchdata[i]=new int[q+1];
    batchdata[i][q]=r;
    }
    else
    {batchdata[i]=new int[q];
    count++;
    }
    for(j=0;j<q;j++)
    batchdata[i][j]=4;
    }
    for (i=0; i<4; i++)
    {
    for (int num:batchdata[i])
    System.out.print(num + " ");
    System.out.println();
    }
    System.out.println(count);
    }
}