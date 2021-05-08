package com.saurabh.dada.iq.impl.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavaAssistExample {

	public static void main(String[] args) throws Exception {
		 /* Create object of ClassPool */
        ClassPool objClassPool = ClassPool.getDefault();
        /**
         * Create an object of CtClass.
         * Get the instance of class you want to inject the code.
         * Be careful while accessing the class. You have to specify whole the package name.
         */
        CtClass objCtClass = objClassPool.get("com.saurabh.dada.iq.impl.javassist.CommonUtil");
        /**
         * Create an object of CtMethod.
         * Get the method where you want to inject the code.
         */
        CtMethod objCtMethod = objCtClass.getDeclaredMethod("printToConsole");
        /* Inject the code at the begging of the method */
        objCtMethod.insertBefore("{ System.out.println(\"Hello World! at the begining of method [Runtime from JavaAssistExample class]\"); }");
        /* Inject the code at the end of the method */
        objCtMethod.insertAfter("{ System.out.println(\"Hello World! at the end of method [Runtime from JavaAssistExample class]\"); }");
        /* Create an object of Class */
        Class objClass = objCtClass.toClass();
        /* Create an instance of CommonUtil class using objClass */
        CommonUtil objCommonUtil = (CommonUtil)objClass.newInstance();
        /* Execute method printToConsole */
        objCommonUtil.printToConsole();
    }
}
class CommonUtil {
    public void printToConsole() {
        System.out.println("javaQuery");
    }
}