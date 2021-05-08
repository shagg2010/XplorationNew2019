package com.saurabh.dada.iq.impl.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoTest {

	@Mock
    MyDatabase databaseMock; 

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 

    @Test
    public void testQuery()  {
        ClassToTest t  = new ClassToTest(databaseMock); 
        boolean check = t.query("* from t"); 
        assertTrue(check); 
        verify(databaseMock).query("* from t"); 
    }
	
}

class MyDatabase{
	public boolean query(String query) {
		return true;
	}
}
class ClassToTest{
	private MyDatabase myDatabase;
	public ClassToTest(MyDatabase myDatabase) {
		this.myDatabase=myDatabase;
	}
	
	public boolean query(String query) {
		return true;
	}
}