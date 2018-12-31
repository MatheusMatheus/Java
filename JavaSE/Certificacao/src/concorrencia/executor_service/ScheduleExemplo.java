package concorrencia.executor_service;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleExemplo {
	public static void main(String[] args) throws InterruptedException{
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		Future<?> futuro = executorService.schedule(ScheduleExemplo::metodo, 2, TimeUnit.SECONDS);
		executorService.schedule(() -> "Matheus Lindo", 2, TimeUnit.SECONDS);
		executorService.scheduleAtFixedRate(ScheduleExemplo::metodo, 2, 1, TimeUnit.SECONDS);
		ScheduledFuture<?> future = executorService.scheduleWithFixedDelay(ScheduleExemplo::metodo, 2, 1, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(1);

		long remainingDelay = future.getDelay(TimeUnit.SECONDS);

		System.out.printf("Remaining Delay: %sms", remainingDelay);

		
	}
	
	 static void metodo() {
		 try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Dormi!");
	 }
}
