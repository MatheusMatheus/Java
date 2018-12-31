package concorrencia.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExemplo {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(123);

		int expectedValue = 123;
		int newValue      = 234;
		System.out.println("Valor antigo: " + atomicInteger);
		atomicInteger.compareAndSet(expectedValue, newValue);
		System.out.println("Novo valor: " + atomicInteger.get());
		
		System.out.println("getAndAdd: " + atomicInteger.getAndAdd(10));
		System.out.println("addAndGet: " + atomicInteger.addAndGet(10));
		
		System.out.println("addAndGetNegativo:" + atomicInteger.addAndGet(-50));
	}
}
