package com.saurabh.dada.iq.impl.data_structures;

public class CustomHashMap<K,V> {
	private int DEFAULT_SIZE = 16;
	private Entry<K, V>[] entryBucket;

	public static void main(String[] args) {
		CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(11, 30);
		System.out.println("Val is: " + map.get(1));
		System.out.println(map.indexFor(200, 10));
		System.out.println(map.indexFor(201, 10));
		System.out.println(map.indexFor(203, 10));
		System.out.println(map.indexFor(204, 10));
		System.out.println(map.indexFor(205, 10));
		System.out.println(map.indexFor(206, 10));
		System.out.println(map.indexFor(207, 10));
		System.out.println(map.indexFor(208, 10));
		System.out.println(map.indexFor(209, 10));
	}
	
	public int indexFor(int h, int length) {
	    return h & (length-1);
	}
	 
	public CustomHashMap() {
		entryBucket = new Entry[DEFAULT_SIZE];
	}

	public CustomHashMap(int capacity) {
		entryBucket = new Entry[capacity];
	}
	 
	public void put(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		Entry<K, V> entry = entryBucket[bucketIndex];
		if (entry != null) {
			boolean done = false;
			while (!done)
				if (key.equals(entry.getKey())) {
					entry.setValue(value);
					done = true;
				} else if (entry.getNext() == null) {
					entry.setNext(new Entry<K, V>(key, value));
				}
			entry = entry.getNext();

		} else {
			entryBucket[bucketIndex] = new Entry<K, V>(key, value);
		}
	}
	 /**
	  * this method returns the basketId based on applying hashCode on given key
	  * @param key
	  * @return
	  */
	public int getBucketIndex(K key) {
		int val = key.hashCode() % (entryBucket.length - 1);
		return val;
	}
	 
	public V get(K key) {
		Entry<K, V> entry = entryBucket[getBucketIndex(key)];
		while (entry != null && !key.equals(entry.getKey()))
			entry = entry.getNext();
		return entry != null ? entry.getValue() : null;
	}

	}

class Entry<K,V> {
	 K key;
	 V value;
	 Entry<K,V> next;
	 public Entry(K key, V value)
	 {
	  this.key=key;
	  this.value=value;
	  next=null;
	 }
	 
	 public K getKey() {
	  return key;
	 }
	 public void setKey(K key) {
	  this.key = key;
	 }
	 public V getValue() {
	  return value;
	 }
	 public void setValue(V value) {
	  this.value = value;
	 }
	 public Entry<K, V> getNext() {
	  return next;
	 }
	 public void setNext(Entry<K, V> next) {
	  this.next = next;
	 }
	}