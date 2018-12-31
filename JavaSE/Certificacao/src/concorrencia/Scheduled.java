package concorrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduled {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Matheus lindo");;
		Callable<String> task2 = () -> "Monkey";

		Future<?> result1 = service.schedule(task1, 5, TimeUnit.SECONDS);
		
		ScheduledFuture<?> result2 = service.scheduleAtFixedRate(task1, 3, 1, TimeUnit.SECONDS);
		System.out.println(result2.get());
	}
}
