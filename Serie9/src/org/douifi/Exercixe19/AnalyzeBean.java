package org.douifi.Exercixe19;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeBean {


	public String getClassName(Object o) {
		
		Class<?> clazz = o.getClass();
		return clazz.getName(); 
	}
	
	@SuppressWarnings("deprecation")
	public Object getInstance(String className) {
		try {
			
			Class<?> clss = Class.forName(className);
			Object newInstance = clss.newInstance();
			return newInstance;
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getProperties(Object o) {
		List<String> properties = new ArrayList<>();
		Method[] declaredMethods = o.getClass().getDeclaredMethods();
		// System.out.println("\n# declared methods = " + declaredMethods.length);
		for (Method method : declaredMethods) {
			String methodName = method.getName();
			if ((methodName.startsWith("get") ||
				 methodName.startsWith("is")) && 
				method.getParameterCount() == 0 &&
				Modifier.isPublic(method.getModifiers())) {
				
					// System.out.println(methodName);
					String propertyName = "";
					if (methodName.startsWith("get")) {
						propertyName = methodName.substring(3);
					} else {
						propertyName = methodName.substring(2);
					}
					propertyName = 
							propertyName.substring(0, 1).toLowerCase() + 
							propertyName.substring(1);
					// System.out.println(propertyName);
					properties.add(propertyName);
				}
		}
		return properties;
	}
}
