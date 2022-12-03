import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D02P1_RockPaperScissors {
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
				
				switch(op) {
				case('A')	:	switch(my) {
								case('X')	:	round += 1;
												round += 3;	//Draw
												break;
								case('Y')	:	round += 2;
												round += 6;	//Win
												break;
								case('Z')	:	round += 3;
												//round += 0;	//Lose
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
								break;
				
				case('B')	:	switch(my) {
								case('X')	:	round += 1;
												//round += 0;	//Lose
												break;
								case('Y')	:	round += 2;
												round += 3;	//Draw
												break;
								case('Z')	:	round += 3;
												round += 6;	//Win
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
								break;
								
				case('C')	:	switch(my) {
								case('X')	:	round += 1;
												round += 6;	//Win
												break;
								case('Y')	:	round += 2;
												//round += 0;	//Lose
												break;
								case('Z')	:	round += 3;
												round += 3;	//Draw
												break;
								default		:	System.out.printf("Bad round...op=%d my=%d\n", op, my);
												System.exit(1);
								}
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
