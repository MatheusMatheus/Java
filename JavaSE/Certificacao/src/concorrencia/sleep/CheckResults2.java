package concorrencia.sleep;

public class CheckResults2 {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				System.out.println(i);
				CheckResults2.counter++;
			}
				
		}).start();
		while (CheckResults2.counter < 20) {
			System.out.println("Not reached yet");
			Thread.sleep(1000); // 1 SECOND
		}
		System.out.println("Reached!");
	}
}
