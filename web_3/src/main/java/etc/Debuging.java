package etc;

import java.util.Scanner;

public class Debuging {
	
	public static void main (String [] args) {

	Scanner scanf = new Scanner (System.in);
	
	
	System.out.println("¼ö1 >> ");
	int num1 = scanf.nextInt();
	System.out.println("¼ö2 >> ");
	int num2 = scanf.nextInt();
	
	while (num1 <= num2) {
		System.out.println(num1);
		
		num1++;
	}

		
	}}