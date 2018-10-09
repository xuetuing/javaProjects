package day03;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos =
			new FileOutputStream("dos.dat");
		DataOutputStream dos =
			new DataOutputStream(fos);
		dos.writeInt(123);
		dos.writeLong(123L);
		dos.writeDouble(12.34);
		dos.writeUTF("ÄãºÃ");
		dos.close();
	}
}
