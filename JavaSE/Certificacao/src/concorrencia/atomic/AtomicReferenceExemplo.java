package concorrencia.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExemplo {
	public static void main(String[] args) {

		String initialReference = "the initially referenced string";
		AtomicReference atomicReference = new AtomicReference(initialReference);
		System.out.println(atomicReference.get());

		AtomicReference<String> atomicStringReference = new AtomicReference<>(initialReference);
		System.out.println(atomicStringReference.get());
	}
}
