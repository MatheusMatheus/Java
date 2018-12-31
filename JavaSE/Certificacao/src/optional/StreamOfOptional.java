package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOfOptional {
	public static void main(String[] args) {
		List<Optional<String>> listOfOptionals = 
				Arrays.asList(
						Optional.empty(), 
						Optional.of("foo"), 
						Optional.empty(),
						Optional.of("bar"));
		
		List<String> filteredList = listOfOptionals.stream()
				  .filter(Optional::isPresent)
				  .map(Optional::get)
				  .collect(Collectors.toList());
		System.out.println(filteredList);
		
		/*List<String> filteredList = listOfOptionals.stream()
				  .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
				  .collect(Collectors.toList());*/
	}
}
