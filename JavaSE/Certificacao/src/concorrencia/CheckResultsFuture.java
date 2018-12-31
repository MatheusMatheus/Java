package concorrencia;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResultsFuture {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> {
				for (int i = 0; i < 500; i++)
					CheckResultsFuture.counter++;
				return 5;
			});
			
			
			int inteiro = (Integer)result.get(10, TimeUnit.SECONDS);
			System.out.println("Reached!");
			System.out.println(inteiro);
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	

}
