package org.douifi.Exercixe19;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class PersonReader {

	
	public Map<String, Object> read (String fileName) {
		Path peopleFile = Path.of(fileName);
		
		Set<String> beanKeys = new HashSet<>();
		Map<String, Object> beanRegistry = new HashMap<>();

		try (BufferedReader people = Files.newBufferedReader(peopleFile);) {
			
			String line = people.readLine();
			while (line != null) {
				if (!line.startsWith("#")) {
					
					String[] element = line.split("=");
					if (element[0].equals("bean.name")) {
						beanKeys.add(element[1]);
					
					} else if (element[0].endsWith(".class")) {
						String beanKey = element[0].substring(0, element[0].indexOf('.'));
						String className = element[1];
						Class<?> beanClass = Class.forName(className);
						Constructor<?> beanEmptyConstructor = beanClass.getConstructor();
						Object bean = beanEmptyConstructor.newInstance();
						beanRegistry.put(beanKey, bean);
					
						
					} else if (element[0].endsWith(".lastName")) {
						String beanKey = element[0].substring(0, element[0].indexOf('.'));
						String name = element[1];
						
						Object bean = beanRegistry.get(beanKey);
						Field nameField = bean.getClass().getDeclaredField("lastName");
						nameField.setAccessible(true);
						nameField.set(bean, name);
					
					} 
					else if (element[0].endsWith(".firstName")) {
						String beanKey = element[0].substring(0, element[0].indexOf('.'));
						String name = element[1];
						
						Object bean = beanRegistry.get(beanKey);
						Field nameField = bean.getClass().getDeclaredField("firstName");
						nameField.setAccessible(true);
						nameField.set(bean, name);
					
					}else if (element[0].endsWith(".age")) {
						String beanKey = element[0].substring(0, element[0].indexOf('.'));
						int age = Integer.parseInt(element[1]);
						
						Object bean = beanRegistry.get(beanKey);
						Field ageField = bean.getClass().getDeclaredField("age");
						ageField.setAccessible(true);
						ageField.set(bean, age);
					
				} else if (element[0].endsWith(".salary")) {
					String beanKey = element[0].substring(0, element[0].indexOf('.'));
					int salary = Integer.parseInt(element[1]);
					
					Object bean = beanRegistry.get(beanKey);
					Field ageField = bean.getClass().getDeclaredField("salary");
					ageField.setAccessible(true);
					ageField.set(bean, salary);
				}
					
				}
				line = people.readLine();
			}
			
		} catch (IOException | 
				ClassNotFoundException | 
				NoSuchMethodException | SecurityException | 
				InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | 
				NoSuchFieldException e) {
			e.printStackTrace();
		}
		return beanRegistry;
	}
	
	
}
