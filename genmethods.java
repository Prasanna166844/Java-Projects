import java.util.*;
class genc
{
	<T>void swap(T g1,T g2)
	{
		System.out.println("before swapping v1="+g1+"and v2="+g2);
		T temp=g1;
		g1=g2;
		g2=temp;
		System.out.println("after swapping v1="+g1+"and v2="+g2);
	}
	public static void main(String args[])
	{
		genc g1=new genc();
		g1.<Integer>swap(10,20);
		g1.<Double>swap(23.25,24.22);
		g1.<Character>swap('a','b');
		g1.swap("abc","def");
	}
}