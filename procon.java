import java.lang.*;
class carrier
{
	int n;
	boolean test=true;
	boolean busy=false;
	synchronized void put(int value)
	{
		if(busy)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ie)
			{
				System.out.println("Interrupted in put method");
			}
		}
		n=value;
		busy=true;
		System.out.println("put value:"+n);
		notify();
	}
	synchronized int get()
	{
		if(!busy)
		{
			try
			{
				wait();
			}
			catch(InterruptedException ie)
			{
				System.out.println("Interrupted in get method");
			}
		}
		busy=false;
		System.out.println("get value:"+n);
		notify();
		return n;
	}
}
class producer implements Runnable
{
	carrier t;
	producer(carrier t)
	{
		this.t=t;
		new Thread(this,"producer").start();
	}
	public void run()
	{
		int i=0;
		try
		{
			while(t.test)
			{
				t.put(i++);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println("interrupted in put method");
		}
		
	}
}
class consumer implements Runnable
{
	carrier t;
	consumer(carrier t)
	{
		this.t=t;
		new Thread(this,"consumer").start();
	}
	public void run()
	{
		int i=0;
		try
		{
			while(t.test)
			{
				t.get();
				Thread.sleep(500);
			}
		}
		catch(InterruptedException ie)
		{
			System.out.println("interrupted in get method");
		}
		
	}
}
class PCDemo
{
	public static void main(String args[]) throws Exception
	{
		carrier t=new carrier();
		System.out.println("press ctrl+c to stop");
		new producer(t);
		new consumer(t);
	}
}