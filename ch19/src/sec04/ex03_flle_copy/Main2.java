package sec04.ex03_flle_copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:\\Users\\pcj01\\git\\JavaFX\\ch19\\src\\sec04\\ex03_flle_copy\\CGI.png");
		Path to = Paths.get("C:\\Users\\pcj01\\git\\JavaFX\\ch19\\src\\sec04\\ex03_flle_copy\\CGI3.png");
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("파일 복사 성공");
	}

}
