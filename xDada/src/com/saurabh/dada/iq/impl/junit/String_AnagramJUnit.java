package com.saurabh.dada.iq.impl.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.saurabh.dada.iq.impl.String_Anagram;

public class String_AnagramJUnit {

	@Test 
	public void testIsAnagram() {
		assertTrue(String_Anagram.isAnagram("word", "wrdo"));
		assertTrue(String_Anagram.isAnagram("mary", "army"));
		assertTrue(String_Anagram.isAnagram("stop", "tops"));
		assertTrue(String_Anagram.isAnagram("boat", "btoa"));
		assertFalse(String_Anagram.isAnagram("pure", "in"));
		assertFalse(String_Anagram.isAnagram("fill", "fil"));
		assertFalse(String_Anagram.isAnagram("b", "bbb"));
		assertFalse(String_Anagram.isAnagram("ccc", "ccccccc"));
		assertTrue(String_Anagram.isAnagram("a", "a"));
		assertFalse(String_Anagram.isAnagram("sleep", "slep"));
	}

	@Test
	public void testIAnagram() {
		assertTrue(String_Anagram.iAnagram("word", "wrdo"));
		assertTrue(String_Anagram.iAnagram("boat", "btoa"));
		assertFalse(String_Anagram.iAnagram("pure", "in"));
		assertFalse(String_Anagram.iAnagram("fill", "fil"));
		assertTrue(String_Anagram.iAnagram("a", "a"));
		assertFalse(String_Anagram.iAnagram("b", "bbb"));
		assertFalse(String_Anagram.iAnagram("ccc", "ccccccc"));
		assertFalse(String_Anagram.iAnagram("sleep", "slep"));
	}

	@Test
	public void testcheckAnagram() {
		assertTrue(String_Anagram.checkAnagram("word", "wrdo"));
		assertFalse(String_Anagram.checkAnagram("b", "bbb"));
		assertFalse(String_Anagram.checkAnagram("ccc", "ccccccc"));
		assertTrue(String_Anagram.checkAnagram("a", "a"));
		assertFalse(String_Anagram.checkAnagram("sleep", "slep"));
		assertTrue(String_Anagram.checkAnagram("boat", "btoa"));
		assertFalse(String_Anagram.checkAnagram("pure", "in"));
		assertFalse(String_Anagram.checkAnagram("fill", "fil"));
	}
	

}
