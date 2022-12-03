package Refactored;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Refactored_D02P1_RockPaperScissors {
	private static int[][] part1map = {{1+3, 2+6, 3+0},
									   {1+0, 2+3, 3+6},
									   {1+6, 2+0, 3+3}};
	
	private static int[][] part2map = {{3+0, 1+3, 2+6},
			   						   {1+0, 2+3, 3+6},
			   						   {2+0, 3+3, 1+6}};
	
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("input2.txt"));
			
			long sum1 = 0, sum2 = 0;
			
			String line = "";
			char op, my;
			while(file.hasNextLine()) {
				line = file.nextLine().trim();
				if(line.length() < 3)
					continue;
				
				op = line.charAt(0);
				my = line.charAt(2);
				
				sum1 += part1map[op-'A'][my-'X'];
				sum2 += part2map[op-'A'][my-'X'];
			}
			
			System.out.printf("Part1 Sum = %d\nPart2 Sum = %d\n", sum1, sum2);
			
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}