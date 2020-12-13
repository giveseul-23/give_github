import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mainClass1 {
	public static void main(String[] args) {
		
		// NullPointerException
		String str = null;
		
		try {
			System.out.println(str.length());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
				
		// ArrayIndexOutOfBoundsException
		int arr[] = { 1, 2, 3 };
		
		try {
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}
		
		// FileNotFoundException
		File file = new File("c:\\xxx.txt");
		FileInputStream is;
		
		try {
			is = new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// NumberFormatException
		try {
			int num = Integer.parseInt( "123.456" );
			
			//int num = Integer.parseInt( ((int)Double.parseDouble("123.456")) + "" );
			//System.out.println("num = " + num);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
				
		// StringIndexOutOfBoundsException
		String str1 = "abc";
		
		try {
			char c = str.charAt(3);			
		}catch(StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		

	}
}
