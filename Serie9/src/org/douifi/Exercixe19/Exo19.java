package org.douifi.Exercixe19;

import org.douifi.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Exo19 {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
			NoSuchFieldException, SecurityException, 
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		
		AnalyzeBean beanAnalyzer = new AnalyzeBean();
		
		Person person = new Person("Paul","liio", 33);
		
		//Q1 trois mth p
		Class<?> clss1 = person.getClass();
		Class<?> clss2 = Person.class;
		Class<?> clss3 = Class.forName("org.douifi.model.Person");
		System.out.println("clss1 == clss2 " + (clss1 == clss2));
		System.out.println("clss1 == clss3 " + (clss1 == clss3));
		
		//q2 
		Object newInstance = clss1.getConstructor().newInstance();
		System.out.println("new instance = " + newInstance);
		
		Person p = (Person)beanAnalyzer.getInstance("org.douifi.model.Person");
		System.out.println("p = " + p);
		// q3
		List<String> properties = beanAnalyzer.getProperties(p);
		System.out.println("properties = " + properties);
//		
//		
		//Q6 test de la class PersonReader
		PersonReader pr= new PersonReader();
		System.out.println("Read objects from file: ");
		System.out.println(pr.read("files/Peoples.txt"));

		
	}

}
