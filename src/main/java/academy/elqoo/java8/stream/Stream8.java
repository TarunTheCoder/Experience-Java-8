package academy.elqoo.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import academy.elqoo.java8.stream.sample.CommaSeparatedNameCreator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Stream8 {

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {
		return numbers.stream().map(Math::sqrt).map(Double::intValue).collect(Collectors.toList());
	}

	public static List<Integer> getAgeFromUsers(List<User> user) {
		return user.stream().map(usr -> usr.getAge()).collect(Collectors.toList());
	}

	public static List<Integer> getDistinctAges(List<User> users) {
		return users.stream().map(usr -> usr.getAge()).distinct().collect(Collectors.toList());
	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {
		return users.stream().limit(2).collect(Collectors.toList());
	}

	public static Integer countUsersOlderThen25(List<User> users) {
		return users.stream().filter(usr -> usr.getAge() > 25).collect(Collectors.toList()).size();
	}

	public static List<String> mapToUpperCase(List<String> strings) {
		return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public static Integer sum(List<Integer> integers) {
		return integers.stream().collect(Collectors.summingInt(Integer::intValue));
	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
		return integers.stream().skip(toSkip).collect(Collectors.toList());
	}

	static List<String> getFirstNames(List<String> names) {
		return names.stream().map(name -> name.substring(0, name.indexOf(" "))).collect(Collectors.toList());
	}

	public static List<String> getDistinctLetters(List<String> names) {

		return names.stream().flatMap(name -> name.chars().mapToObj(intnum -> (char) intnum)).distinct()
				.map(chr -> chr.toString()).collect(Collectors.toList());

	}

	public static String separateNamesByComma(List<User> users) {
		CommaSeparatedNameCreator nameCreator = users.stream().map(user -> user.getName()).collect(
				CommaSeparatedNameCreator::new, CommaSeparatedNameCreator::accept, CommaSeparatedNameCreator::combiner);

		return nameCreator.getCommaSeparatedNames();

	}

	public static String separateNamesByComma1(List<User> users) {
		return users.stream().map(user -> user.getName()).collect(Collectors.joining(", "));
	}

	public static String separateNamesByComma2(List<User> users) {
		List<String> names = users.stream().map(user -> user.getName()).collect(Collectors.toList());
		return String.join(", ", names);
	}

	public static double getAverageAge(List<User> users) {
		return users.stream().mapToInt(user -> user.getAge()).average().orElseThrow(NoSuchElementException::new);
	}

	public static Integer getMaxAge(List<User> users) {
		return users.stream().mapToInt(user -> user.getAge()).max().orElseThrow(NoSuchElementException::new);

	}

	public static Integer getMinAge(List<User> users) {
		return users.stream().mapToInt(user -> user.getAge()).min().orElseThrow(NoSuchElementException::new);

	}

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
		return users.stream().collect(Collectors.groupingBy(User::isMale));
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		return users.stream().collect(Collectors.groupingBy(User::getAge));
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));

	}

	public static boolean anyMatch(List<User> users, int age) {
		return users.stream().anyMatch(user -> user.getAge() == age);
	}

	public static boolean noneMatch(List<User> users, int age) {
		return users.stream().noneMatch(user -> user.getAge() == age);
	}

	public static Optional<User> findAny(List<User> users, String name) {
		return users.stream().filter(user -> user.getName().equalsIgnoreCase(name)).findAny();
	}

	public static List<User> sortByAge(List<User> users) {
		return users.stream().sorted(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return (o1.getAge() > o2.getAge()) ? 1 : -1;
			}

		}).collect(Collectors.toList());

	}

	public static List<User> sortByAge1(List<User> users) {
		return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());

	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {
		return stream.mapToObj(Integer::new);
	}

	public static List<Integer> generateFirst10PrimeNumbers() {
		throw new NotImplementedException();
		//IntStream.rangeClosed(1,50).anyMatch(..isPrime())
	}
	
	public static List<Integer> sieveOfEratosthenes(int n) {
	    boolean prime[] = new boolean[n + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= n; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= n; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= n; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}

	public static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {
		Random random = new Random();
		return random.ints().limit(10).mapToObj(Integer::new).collect(Collectors.toList());
	}

	public static User findOldest(List<User> users) {
		return users.stream().max(Comparator.comparing(User::getAge)).orElseThrow(NoSuchElementException::new);
	}

	public static int sumAge(List<User> users) {
		return users.stream().collect(Collectors.summingInt(user -> user.getAge()));
	}

	public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
		return users.stream().collect(Collectors.summarizingInt(User::getAge));
	}

}
