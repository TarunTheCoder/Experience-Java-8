package academy.elqoo.java8.stream.prim;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class PrimitiveStreamPrac {
	
	@Test
	public void createIntStreamFromArray() {
		int[] integers = new int[] {12,45,23,67,78,32};
		IntStream intPrimStream = Arrays.stream(integers);
		assertEquals(intPrimStream.min().getAsInt(), 12);
	}
	
	@Test
	public void createIntStreamUsingOf() {
		IntStream intPrimStream = IntStream.of(12,45,23,67,78,32);
		assertEquals(intPrimStream.max().getAsInt(), 78);
	}
	
	@Test
	public void calculateSumOfIntegers() {
		int[] integers = new int[] {12,45,23,67,78,32};
		IntStream intPrimStream = Arrays.stream(integers);
		assertEquals(intPrimStream.sum(),12+45+23+67+78+32);
	}
	
	//@SuppressWarnings("deprecation")
	@Test
	public void calculateAvgOfIntegers() {
		IntStream intPrimStream = IntStream.of(12,45,23,67,78,32);
		System.out.println(intPrimStream.average().getAsDouble());
		System.out.println((12+45+23+67+78+32)/6d);
		//assertEquals(,(12+45+23+67+78+32)/6);
	}
	
	@Test
	public void useRangeToCreateIntStream() {
		IntStream intPrimStream = IntStream.range(1,10);
		assertEquals(intPrimStream.sum(),45);
	}
	
	@Test
	public void useClosedRangeToCreateIntStream() {
		IntStream intPrimStream = IntStream.rangeClosed(1,10);
		assertEquals(intPrimStream.sum(),55);
	}
	
	@Test
	public void boxedDemo() {
		Set<Integer> setOfEvens = IntStream.range(1,10).filter(i-> i % 2 == 0).boxed().collect(Collectors.toSet());
		// Does not compiles without boxed(); Set<Integer> setOfEvens = IntStream.range(1,10).filter(i-> i % 2 == 0).collect(Collectors.toSet());
	}
	
	@Test
	public void wrapperStream_toPrimitiveStream() {
		Stream<Integer> wrapperStream = Arrays.asList(33,45).stream();
		IntStream primitiveStream = wrapperStream.mapToInt(i->i);
	}

}
