package CVUT.kalkulacka;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;

public class Exercise01{
	private int	choice = 0;
	private int pocetDesMist = 0;
	private BigDecimal	firstValue;
	private BigDecimal	secondValue;

	public void start(String[] args) {
	
		Scanner input = new Scanner(System.in);
		String[][] inputMessages = {
			{"Zadej scitanec: ", "Zadej scitanec: "}, 
			{"Zadej mensenec: ", "Zadej mensitel: "}, 
			{"Zadej cinitel: ", "Zadej cinitel: "}, 
			{"Zadej delenec: ", "Zadej delitel: "}
		};
		String[] operators = {" + ", " - ", " * ", " / "};
		this.choice = getInput(input);
		System.out.println(inputMessages[choice][0]);
		this.firstValue = new BigDecimal(input.nextDouble());
		System.out.println(inputMessages[choice][1]);
		this.secondValue = new BigDecimal(input.nextDouble());
		if (choice == 3 && secondValue.compareTo(BigDecimal.ZERO) == 0)
		{
			System.out.println("Cannot divide by zero.");
			return;
		}
		System.out.println("Zadej pocet desetinych mist: ");
		pocetDesMist = input.nextInt();
		if (pocetDesMist < 0)
		{
			System.out.println("Pocet desetinych mist nemuze byt mensi nez nula.");
			return;
		}
		BigDecimal result = new BigDecimal(0);
		switch(choice)
		{
			case 0:
				result = firstValue.add(secondValue);
				break;
			case 1:
				result = firstValue.subtract(secondValue);
				break;
			case 2:
				result = firstValue.multiply(secondValue);
				break;
			case 3: 
				result = firstValue.divide(secondValue);
				break;
		}
		firstValue = firstValue.setScale(pocetDesMist, RoundingMode.HALF_UP);
		secondValue = secondValue.setScale(pocetDesMist, RoundingMode.HALF_UP);
		System.out.println(firstValue.toPlainString() + operators[choice] + secondValue.toPlainString() + " = "+ result);
	}

	private static int getInput(Scanner input)
	{
		int choice = 0;
		boolean validInput = false;

		System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
		while (!validInput)
		{
			try{
				choice = input.nextInt();
				if (choice < 1 || choice > 4)
				{	
					System.out.println("Number not in scope. Try again.");
					continue;
				}
				validInput = true;
			} catch (InputMismatchException ime)
			{
				System.out.println("Invalid input please try again.");
				input.nextLine();	
			}	
		}
		return choice - 1;
	}

}