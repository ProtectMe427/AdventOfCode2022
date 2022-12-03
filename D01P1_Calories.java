import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D01P1_Calories {
	public static void main(String[] args) {
		try {
			File input = new File("input1.txt");
			Scanner file = new Scanner(input);
			
			PriorityQueue<Integer> calsPerElf = new PriorityQueue<Integer>();
			
			String line = "";
			int sum = 0;
			while(file.hasNextLine()) {
				line = file.nextLine().trim();
				try {
					sum += Integer.parseInt(line);
				} catch(Exception e) {
					calsPerElf.add(sum);
					sum = 0;
				}
			}
			calsPerElf.add(sum);
			
			//Ah hell, PriorityQueue is backwards
			while(!calsPerElf.isEmpty())
				System.out.println(calsPerElf.remove());
			
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}