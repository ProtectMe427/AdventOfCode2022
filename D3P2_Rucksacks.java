import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3P2_Rucksacks {
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("input3.txt"));
			
			String line1, line2, line3;
			int common;
			long sum = 0;
			
			
			while(file.hasNextLine()) {
				line1 = file.nextLine().trim();
				if(line1.length() < 2)
					continue;
				line2 = file.nextLine().trim();
				if(line2.length() < 2)
					continue;
				line3 = file.nextLine().trim();
				if(line3.length() < 2)
					continue;
				
				common = -1;
				for(char X : line1.toCharArray()) {
					if(line2.contains("" + X) && line3.contains("" + X)) {
						common = Character.isUpperCase(X)? X - 'A' + 27 : X - 'a' + 1;
						break;
					}
				}
				if(common == -1) {
					System.out.println("No match found!");
					System.exit(1);
				}
				
				sum += common;
			}
			
			System.out.printf("Sum = %d\n", sum);
			
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}