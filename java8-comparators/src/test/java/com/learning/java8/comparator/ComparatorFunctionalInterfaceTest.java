package com.learning.java8.comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.util.Comparator;

import org.junit.Test;

public class ComparatorFunctionalInterfaceTest {

	@Test
	public void shouldCompareTwoGuidesByUsingComparator() throws Exception {
		CraftCoderGuide mockito = new CraftCoderGuide("Mockito");
		CraftCoderGuide java = new CraftCoderGuide("Java 8");
		
		Comparator<CraftCoderGuide> comparator = new Comparator<CraftCoderGuide>() {

			@Override
			public int compare(CraftCoderGuide first, CraftCoderGuide second) {
				return first.getName().compareTo(second.getName());
			}
		};
		
		int compared = comparator.compare(mockito, java);
		
		assertThat(compared, greaterThan(0));
	}
	
	@Test
	public void shouldCompareTwoGuidesByUsingComparatorWithLambdaExpression() throws Exception {
		CraftCoderGuide mockito = new CraftCoderGuide("Mockito");
		CraftCoderGuide java = new CraftCoderGuide("Java 8");
		
		Comparator<CraftCoderGuide> comparator = (first, second) -> first.getName().compareTo(second.getName());
		
		int compared = comparator.compare(mockito, java);
		
		assertThat(compared, greaterThan(0));
	}
	
	@Test
	public void shouldCompareAndReverseTwoGuidesByUsingComparator() throws Exception {
		CraftCoderGuide mockito = new CraftCoderGuide("Mockito");
		CraftCoderGuide java = new CraftCoderGuide("Java 8");
		
		Comparator<CraftCoderGuide> comparator = (first, second) -> first.getName().compareTo(second.getName());
		
		int compared = comparator.reversed().compare(mockito, java);
		
		assertThat(compared, lessThan(0));
	}
	
}

class CraftCoderGuide {
	
	private String name;

	public CraftCoderGuide(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}