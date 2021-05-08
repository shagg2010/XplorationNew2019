package com.saurabh.dada.iq.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializationAndSingleton {

	public static void main(String[] args) {
		try{
			SearchBox s1 = SearchBox.getInstance();
			s1.setName("s1");
			
			//Serialization
			FileOutputStream fileOut = new FileOutputStream("sb.serz");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s1);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in sb.serz");
			
			//Deserialization
			FileInputStream fileIn = new FileInputStream("sb.serz");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			SearchBox e1 = (SearchBox) in.readObject();
			in.close();
			fileIn.close();
			
			System.out.println("Deserialized ...1");
			System.out.println("e1: " + e1.name + ", hash:" + e1.hashCode());
			
			System.out.println("Deserialized Employee...2");
			fileIn = new FileInputStream("sb.serz");
			in = new ObjectInputStream(fileIn);
			SearchBox e2 = (SearchBox) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("e2: " + e2.name + ", hash:" + e2.hashCode());
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	public static class SearchBox implements Serializable,Cloneable{
	      
		private static final long serialVersionUID = -3094243618464429051L;
		private static volatile SearchBox searchBox;
        private static String[] list=null;
        private String name;

        static{
        	list = new String[]{"Stack", "Overflow"};
        }

        
        private SearchBox() {}
        
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		// static method to get instance
        public static SearchBox getInstance() {
            if (searchBox == null) { // first time lock
                synchronized (SearchBox.class) {
                    if (searchBox == null) {  // second time lock
                        searchBox = new SearchBox();
                        System.out.println("New SearchBox Object Created........!");
                    }
                }
            }
            return searchBox;
        }
        
        public Object clone() throws CloneNotSupportedException{
        	//return super.clone();
        	return searchBox!=null?searchBox:getInstance();
        }
        protected Object readResolve() throws ObjectStreamException {
        	  return searchBox!=null?searchBox:getInstance();
        }
      
		protected Object writeReplace() throws ObjectStreamException {
			return this;
		}
	}

}
