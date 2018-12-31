package parallel_stream;

import java.util.Arrays;

public class Reduce {
	public static void main(String[] args) {
        System.out
        .println("using reduce: " + Arrays.asList("ohello2ooo", "whello1", "dhello3", "ahello4", "zhello5hhhh")
                .parallelStream().reduce("", (c1, s1) -> {
                    //print("c1 in accumulator: " + c1);
                    //print("s1 in accumulator: " + s1);
                    return c1 + process(s1);
                }, (s2, s3) -> {
                    print("s2 in combiner: " + s2);
                    print("s3 in combiner: " + s3);
                    return s2 + s3;
                }));
        
		/*Integer arrSum = Stream.of(1, 2, 3)
				.parallel()
				.reduce(1000, 
						(x, y) -> {
							System.out.println("accumulator called: "  + (x + y)); 
							System.out.printf("X = %d \t Y = %d\n", x, y); 
							return x + y;
						}, 
						(p, q) -> {
							System.out.println("combiner called: " + (p + q));
							return p + q;
						});
		System.out.println(arrSum);*/

	}

	public static String process(String input) {
		if (input.length() > 6) {
			input = input.substring(1, 7);
		}
		System.out.println("process output: " + input);
		return input;
	}

	public static void print(String input) {
		System.out.println("in print: " + input);
	}
	
	
}
