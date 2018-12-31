package testes_gerais;

import java.util.Arrays;
import java.util.List;

public class Teste {
	private String value = "Enclosing scope value";
	
	public String scopeExperiment() {
	    Foo fooIC = new Foo() {
	        String value = "Inner class value";
	 
	        @Override
	        public String method(String string) {
	            return this.value;
	        }
	    };
	    String resultIC = fooIC.method("");
	 
	    Foo fooLambda = parameter -> {
	        String value = "Lambda value";
	        return this.value;
	    };
		String resultLambda = fooLambda.method("");
	 
	    return "Results: resultIC = " + resultIC + 
	      ", resultLambda = " + resultLambda;
	}
	
	public static void main(String[] args)  {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int result = numeros.stream()
							.filter(n -> n > 5)
							.filter(n -> n % 2 == 0)
							.filter(n -> n < 9)
							.filter(n -> n * 2 > 15)
							.findFirst()
							.get();
		
		System.out.println(result);
		
	}
	


}

@FunctionalInterface
interface Foo {
    String method(String str);
}
