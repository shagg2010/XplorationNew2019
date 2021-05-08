package com.saurabh.dada.iq.impl.classloaders;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class JavaClassLoader extends ClassLoader {
	
	public static void main(String[] args) {
		JavaClassLoader me = new JavaClassLoader();
		me.invokeClassMethod("com.saurabh.dada.iq.impl.classloaders.MyClass", "sayHello");
	}
	
	@Override
	public Class findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassFromFile(name);
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassFromFile(String fileName) {
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(fileName.replace('.', File.separatorChar) + ".class");
		byte[] buffer;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int nextValue = 0;
		try {
			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer = byteStream.toByteArray();
		return buffer;
	}
    
    public void invokeClassMethod(String classBinName, String methodName){
         
        try {
             
            // Create a new JavaClassLoader 
            ClassLoader classLoader = this.getClass().getClassLoader();
             
            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);
             
            System.out.println("Loaded class name: " + loadedMyClass.getName());
             
            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();
             
            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}
