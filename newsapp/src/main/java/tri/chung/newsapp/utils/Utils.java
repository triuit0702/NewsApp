package tri.chung.newsapp.utils;

import java.lang.reflect.Field;

public class Utils {

	//@SuppressWarnings("unchecked")
	public static <T> T mergeObject(T a, T b) throws InstantiationException, IllegalAccessException {	
		Field[] fieldsOld = a.getClass().getDeclaredFields();
		Field[] fieldsNew = b.getClass().getDeclaredFields();
		//Object merged = a.getClass().newInstance();
		for (Field old: fieldsOld) {
			
			if (!"serialVersionUID".equals(old.getName())) {
				for (Field newF: fieldsNew) {
					old.setAccessible(true);
					//System.out.println(newF.get(b));
					if (old.getName().equals(newF.getName())) {
						//System.out.println(newF.get(b));
						old.set(a, newF.get(b));
					}
				}
			}
		}
		return a;
	}
}
