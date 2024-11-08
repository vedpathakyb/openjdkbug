package com.JdkBug;
import java.util.Date;
import java.io.IOException;
import jakarta.xml.bind.*;
//import javax.xml.bind.*;
import java.io.File;
public class Bean
{
	public void Mar()
	{
		JAXBContext jaxbContext = null;
		Fruit o=new Fruit();
		try
		{
			jaxbContext = JAXBContext.newInstance(com.JdkBug.Fruit.class.getPackage().getName(),com.JdkBug.Fruit.class.getClassLoader());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			o.setId(1);
			o.setName("Banana");
			o.setPrice("9.99");
			jaxbMarshaller.marshal(o, new File("fruit.xml"));
			System.out.println("File cretaed");
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public void UnMar()
	{
		JAXBContext jaxbContext = null;
		try
		{
			jaxbContext = JAXBContext.newInstance(Fruit.class);
			File file = new File("fruit.xml");
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Fruit o = (Fruit) jaxbUnmarshaller.unmarshal(file);
			System.out.println(o);
			System.out.println("Object created");
		}
		catch (JAXBException e) {
			Throwable cause = e.getCause();
			System.err.println("MESSAGE = |" + cause.getMessage() + "|");
			System.err.println("LOCALIZED MESSAGE = |" + cause.getLocalizedMessage() + "|");
			System.err.println("STACK TRACE");
			e.printStackTrace();
		}
	}
}
