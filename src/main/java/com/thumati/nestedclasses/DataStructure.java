package com.thumati.nestedclasses;

import java.util.Iterator;

public class DataStructure {
	
	private static final  int SIZE=15;
	private int[] arrayOfInts = new int[SIZE];
	
	public DataStructure() {
		for(int i=0;i<SIZE;++i) {
			arrayOfInts[i]=i;
		}
	}
	
	public void printEven() {
		DataStructureIterator dsIterator = this.new EvenIterator();
		while(dsIterator.hasNext()) {
			System.out.println(dsIterator.next()+" ");
		}
	}
	
	interface DataStructureIterator extends Iterator{
	}

	private class EvenIterator implements DataStructureIterator{
		private int nextIndex = 0;
		
		@Override
		public boolean hasNext() {
			return (nextIndex<=(SIZE-1));
		}
		
		@Override
		public Integer next() {
			Integer obj = arrayOfInts[nextIndex];
			nextIndex+=2;
			return obj;
		}
	}
	
	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		ds.printEven();
	}
	
	{
		class InstanceBlockClass{
			
		}
	}
	
	static {
		class StaticBlockClass{
			
		}
		
	}
}
