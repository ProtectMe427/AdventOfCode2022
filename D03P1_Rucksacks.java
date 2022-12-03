import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D03P1_Rucksacks {
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("input3.txt"));
			
			String line, first, second;
			int common;
			long sum = 0;
			
			
			while(file.hasNextLine()) {
				line = file.nextLine().trim();
				if(line.length() < 2)
					continue;
				
				first = line.substring(0, line.length()/2);
				second = line.substring(line.length()/2);
				
				common = -1;
				for(char X : first.toCharArray()) {
					if(second.contains("" + X)) {
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