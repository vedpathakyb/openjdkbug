package com.JdkBug;
import java.util.*;
import java.io.IOException;
import jakarta.xml.bind.*;
import java.io.File;
public class App 
{
	public static void main( String[] args )
	{
		Bean b=new Bean();
		Scanner sc=new Scanner(System.in);
		System.out.println( "Enter 1 to Marshal,2 to UnMarshal");
		int a=sc.nextInt();
		if (a==1)
		{
			System.out.println("Marshalling Invoked");
			b.Mar();
		}
		if (a==2)
		{
			System.out.println("UnMarshalling Invoked");
			b.UnMar();
		}
	}
}
