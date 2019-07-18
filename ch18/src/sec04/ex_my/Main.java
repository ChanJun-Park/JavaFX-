package sec04.ex_my;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void showDirList(String dirPath) {
		File file = new File(dirPath);
		System.out.println("현재 디렉토리 내용");
		System.out.println("번호\t형태\t크기\t이름");
		File[] contents = file.listFiles();
		for (int i = 0; i < contents.length; i++) {
			File f = contents[i];
			System.out.print(i + "\t");
			if(f.isFile()) {
				System.out.print("<File>\t");
			} else {			
				System.out.print("<Dir>\t");
			}
			System.out.print(f.length() + "\t");
			System.out.println(f.getName());
		}
	}
	
	public static void copyFile(String org, String cpy) throws IOException{
		File origin = new File(org);
		File copy = new File(cpy);
		FileInputStream fs;
		try {
			fs = new FileInputStream(origin);
		} catch (FileNotFoundException e1) {
			System.out.println("복사하려는 파일이 존재하지 않습니다");
			System.out.println("파일 복사 실패");
			return;
		}
		FileOutputStream os;		
		os = new FileOutputStream(copy);
		
		byte[] buffer = new byte[100];
		int readCnt = 0;
		while((readCnt = fs.read(buffer)) != -1) {
			os.write(buffer, 0, readCnt);
		}
		os.flush();
		os.close();
		fs.close();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String currentDirPath = "C:\\Temp";
		while(true) {
			showDirList(currentDirPath);
			System.out.print("명령 입력 > ");
			String[] str = sc.nextLine().split(" ");
			String cmd = str[0];
			if(cmd.equals("copy")) {
				int index = str[1].lastIndexOf(".");
				String fileExt = str[1].substring(index+1);
				File dstDir = new File(str[2]);
				if(!dstDir.exists()) {
					dstDir.mkdirs();
				}
				String copyFileName = "copy." + fileExt;
				String fullOriginFileName = currentDirPath + "\\" + str[1];
				String fullCopyFileName = str[2] + "\\" + copyFileName;
				System.out.println(fullOriginFileName);
				System.out.println(fullCopyFileName);
				copyFile(fullOriginFileName, fullCopyFileName);
			}
		}
	}

}
