package academy.elqoo.java8.joiner;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Test;

public class StringJoinerPrac {

	private static final CharSequence PREFIX = "{";
	private static final CharSequence SUFFIX = "}";
	private static final CharSequence COMMA = ",";
	private static final CharSequence DASH = "-";
	private static final CharSequence RED = "RED";
	private static final CharSequence GREEN = "GREEN";
	private static final CharSequence BLUE = "BLUE";
	private static final CharSequence CYAN = "CYAN";
	private static final CharSequence MAGENTA = "MAGENTA";
	private static final CharSequence YELLOW = "YELLOW";
	private static final CharSequence BLACK = "BLACK";
	private static final CharSequence DEFAULT = "DEFAULT";

	@Test
	public void whenUsedWithinCollectors_ThenJoined() {
		List<String> rgbList = Arrays.asList("Red", "Green", "Blue");
		String commaSeparatedRGB = rgbList.stream().collect(Collectors.joining(","));
		assertEquals(commaSeparatedRGB, "Red,Green,Blue");
	}

	@Test
	public void whenUsedWithinCollectors_WithPrefixs_ThenJoined() {
		List<String> rgbList = Arrays.asList("Red", "Green", "Blue");
		String commaSeparatedRGB = rgbList.stream().collect(Collectors.joining(",", "{", "}"));
		assertEquals(commaSeparatedRGB, "{Red,Green,Blue}");
	}

	@Test
	public void whenUsedWithinCollectors_WithNoDelimiter_ThenJoined() {
		List<String> rgbList = Arrays.asList("Red", "Green", "Blue");
		String rgb = rgbList.stream().collect(Collectors.joining());
		assertEquals(rgb, "RedGreenBlue");
	}

	@Test
	public void whenMergingJoiners_thenReturnMerged() {
		StringJoiner rgbJoiner = new StringJoiner(COMMA, PREFIX, SUFFIX);
		StringJoiner cmybJoiner = new StringJoiner(DASH, PREFIX, SUFFIX);

		rgbJoiner.add(RED).add(GREEN).add(BLUE);
		cmybJoiner.add(CYAN).add(MAGENTA).add(YELLOW).add(BLACK);

		rgbJoiner.merge(cmybJoiner);

		assertEquals(rgbJoiner.toString(), "{RED,GREEN,BLUE,CYAN-MAGENTA-YELLOW-BLACK}");

	}

	@Test
	public void whenEmptyJoinerWithPrefixSuffixAndEmptyValue_thenDefaultValue() {
		StringJoiner joiner = new StringJoiner(COMMA, PREFIX, SUFFIX);
		joiner.setEmptyValue(DEFAULT);
		assertEquals(joiner.toString(), DEFAULT);

	}

	@Test
	public void whenEmptyJoinerWithEmptyValue_thenDefaultValue() {
		StringJoiner joiner = new StringJoiner(COMMA);
		joiner.setEmptyValue(DEFAULT);
		assertEquals(joiner.toString(), DEFAULT);

	}

	@Test
	public void whenEmptyJoinerJoinerWithPrefixSuffix_thenPrefixSuffix() {
		StringJoiner joiner = new StringJoiner(COMMA, PREFIX, SUFFIX);
		assertEquals(joiner.toString(),PREFIX.toString() + SUFFIX.toString());
	}
	
	@Test
	public void whenEmptyJoinerWithoutPrefixSuffix_thenEmptyString() {
		StringJoiner joiner = new StringJoiner(COMMA);
		assertEquals(joiner.toString().length(),0);
	}

	
}
