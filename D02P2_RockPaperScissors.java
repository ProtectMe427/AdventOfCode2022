import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D02P2_RockPaperScissors {
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File("input2.txt"));
			
			int round;
			long sum = 0;
			
			String line = "";
			char op, my;
			while(file.hasNextLine()) {
				line = file.nextLine().trim();
				if(line.length() < 3)
					continue;
				
				op = line.charAt(0);
				my = line.charAt(2);
				round = 0;
				
				switch(my) {
				case('X')	:	switch(op) {	//Lose
								case('A')	:	round += 3;
												break;
								case('B')	:	round += 1;
												break;
								case('C')	:	round += 2;
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
								//round += 0;
								break;
				
				case('Y')	:	switch(op) {	//Draw
								case('A')	:	round += 1;
												break;
								case('B')	:	round += 2;
												break;
								case('C')	:	round += 3;
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
								round += 3;
								break;
								
				case('Z')	:	switch(op) {	//Win
								case('A')	:	round += 2;
												break;
								case('B')	:	round += 3;
												break;
								case('C')	:	round += 1;
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
								round += 6;
								break;
								
				default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
								System.exit(1);
				}
				
				sum += round;
			}
			
			System.out.printf("Sum = %d\n", sum);
			
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
