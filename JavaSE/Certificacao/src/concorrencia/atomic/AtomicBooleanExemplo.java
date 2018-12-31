package concorrencia.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExemplo {
	public static void main(String[] args) {
		AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		System.out.println(atomicBoolean.get());
		boolean oldValue = atomicBoolean.getAndSet(false);
		System.out.println("oldValue: " + oldValue);
		
		boolean expectedValue = true;
		boolean newValue = false;

		// Compara o valor atual do AtomicBoolean com um valor esperado,
		// Se esses valores forem iguais, um novo valor pode ser setado no AtomicBoolean
		boolean wasNewValueSet = atomicBoolean.compareAndSet(expectedValue, newValue);
		System.out.println("wasNewValueSet: " + wasNewValueSet);
	}
}
