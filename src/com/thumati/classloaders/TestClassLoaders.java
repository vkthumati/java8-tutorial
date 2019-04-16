package com.thumati.classloaders;

import java.net.URL;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.thumati.corejava.oops.Book;

import sun.misc.*;

public class TestClassLoaders {

	public static void main(String[] args) throws Exception {
		Class obj = Class.forName("com.thumati.classloaders.TestClassLoaders");
		System.out.println("Class.forName : "+obj.getName());
		
		TestClassLoaders testClassLoaders = new TestClassLoaders();
		Class<? extends TestClassLoaders> class1 = testClassLoaders.getClass();
		System.out.println("testClassLoaders.getClass() : "+class1.getName());
		
		System.out.println("obj : "+obj);
		System.out.println("class1 : "+class1);
		
		System.out.println("obj hashcode : "+obj.hashCode());
		System.out.println("class1 hashcode : "+class1.hashCode());
		System.out.println("obj == class1 : "+(class1==obj));
		
		System.out.println("Class Loaders -------------------------------------------------------");
		System.out.println("Class Loader loaded String class : "+String.class.getClassLoader());
		System.out.println("Class Loader loaded TestClassLoaders class : "+TestClassLoaders.class.getClassLoader());
		System.out.println("Class Loader loaded Book class : "+Book.class.getClassLoader());
		
		Launcher l = Launcher.getLauncher();
		URL[] urLs = l.getBootstrapClassPath().getURLs();
		for(URL url : urLs) {
			System.out.println("Bootstrap Class Path : "+url.getPath());
		}
		
		/*Launcher.ExtClassLoader ext = Launcher.ExtClassLoader.getExtClassLoader();
		URL[] urLsExt = ext.getURLs();
		for(URL url : urLsExt) {
			System.out.println("ExtClassLoader Class Path : "+url.getPath());
		}*/
		
		System.out.println("\nSystem properties ---------------------------------------");
		Properties properties = System.getProperties();
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}
}
