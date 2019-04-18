package main;

import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable {

	private StreamConnection mConnection;

	public ProcessConnectionThread(StreamConnection connection) {
		this.mConnection = connection;
	}

	@Override
	public void run() {
		try {
			// prepare to receive data
			InputStream inputStream = mConnection.openInputStream();
			OutputStream outputStream = mConnection.openOutputStream();
			
			System.out.println("waiting for input");

			while (true) {
				byte[] buffer = new byte[128];
				int stringLength = inputStream.read(buffer);
				if (stringLength == -1) {
					break;
				}
				outputStream.write(buffer, 0, stringLength);
				System.out.println("received: " + new String(buffer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
