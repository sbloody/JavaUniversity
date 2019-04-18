package main;

public class Main {
	
	public static void main(String[] args) {
		Thread server = new Thread(new BluetoothConnectionListener());
		System.out.println("Starting server");
		server.start();
		try {
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Server stopped. Exiting...");
	}
}
