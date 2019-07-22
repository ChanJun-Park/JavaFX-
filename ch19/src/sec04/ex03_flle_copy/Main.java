package sec04.ex03_flle_copy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:\\Users\\pcj01\\git\\JavaFX\\ch19\\src\\sec04\\ex03_flle_copy\\CGI.png");
		Path to = Paths.get("C:\\Users\\pcj01\\git\\JavaFX\\ch19\\src\\sec04\\ex03_flle_copy\\CGI2.png");
		
		FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ);
		
		FileChannel fileChannel_to = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		while(true) {
			buffer.clear();
			byteCount = fileChannel_from.read(buffer);
			if(byteCount == -1) break;
			buffer.flip();
			fileChannel_to.write(buffer);
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}

}
