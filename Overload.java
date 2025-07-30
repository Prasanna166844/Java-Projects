/*method overloading*/
import java.io.*;
import java.lang.*;
import java.util.*;
class Overload
{
	int add(int a,int b)
	{
		return(a+b);
	}
	float add(float x,float y)
	{
		return(x+y);
	}
	int add(int a,int b,int c)
	{
		return(a+b+c);
	}
}
class ODemo
{
	public static void main(String args[])
	{
		Overload O=new Overload();
		int a=10,b=20;
		System.out.println("overload with two parameters="+O.add(a,b));
		float x=10.2f,y=20.3f;
		System.out.println("overload with two parameters="+O.add(x,y));
		int c=30;
		System.out.println("overload with three parameters="+O.add(a,b,c));
    }
}