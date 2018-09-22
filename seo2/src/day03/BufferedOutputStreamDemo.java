package day03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		//缓存输入流是以文件输入流对象构建对象的
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String str = "大家好";
		byte[] b = str.getBytes("UTF-8");
		bos.write(b);
		//缓存输出流写出后，必须通过flush()将数据写入文件
		bos.flush();
		/*
		 * 在关闭流的时候，我们只需要关闭最外层的高级流即可，
		 * 高级流在关闭时会先将处理的流关闭再关闭自身
		 */
		bos.close();
		
		
	}
}


































