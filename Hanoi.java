/*hanoi*/
import java.io.*;
import java.lang.*;
import java.util.*;
class Hanoi
{
	public static void main(String args[])
	{
		System.out.println("enter no of disks");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println("the moves are");
		movedisks(n,'A','B','c');
	}
	public static void movedisks(int n,char A,char B,char C)
	{
		if(n==1)
			System.out.println("move disk"+n+" from"+A+" to"+B);
		else
		{
			movedisks(n-1,A,C,B);
			System.out.println("move disk"+n+" from "+A+" to "+B);
			movedisks(n-1,C,B,A);
		}
	}
}
