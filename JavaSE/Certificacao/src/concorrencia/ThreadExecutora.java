package concorrencia;

public class ThreadExecutora {
	public static void main(String[] args) {
		System.out.println("begin");
/*		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();*/
		new PrintData().run();
		System.out.println("end");
	}
}
