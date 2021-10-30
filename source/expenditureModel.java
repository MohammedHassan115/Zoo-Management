package m;

import java.util.Scanner;

public class expenditureModel {
	static Scanner s = new Scanner(System.in);
	static int price1 = 0;
	public static void increaseX(int p) {
		price1 += p;
		expenditure.managerActions();
	}
	public static void decreaseX(int p) {
		if(price1!=0)
		price1 -= p;
		else
			System.out.println("Your expenditure is 0$\n");
		expenditure.managerActions();
	}
    public static void clearX() {
		price1 = 0;
		System.out.println("The expenditure is: " + price1 + "$\n");
		expenditure.managerActions();
	}
    public static void viewX() {
		System.out.println("The expenditure is: " + price1 + "$\n");
		expenditure.managerActions();
	}
}
