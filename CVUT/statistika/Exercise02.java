package CVUT.statistika;

public class Exercise02
{
	private TextIO input = new TextIO();

	private static String calculateDeviation(int countOfNums, String[] data)
	{
		double average = 0;
		double deviation = 0;
		double[] dataNumbers = new double[countOfNums];
		for (int i = 0; i < countOfNums; ++i)
		{
			dataNumbers[i] = Double.parseDouble(data[i]);
			average += dataNumbers[i];
		}
		average /= countOfNums;
		for (int i = 0; i < countOfNums; ++i)
		{
			dataNumbers[i] = Math.pow(dataNumbers[i] - average, 2);
			deviation += dataNumbers[i];
		}
		deviation = Math.sqrt(deviation);
	}

	public void homework()
	{
		int	lineCounter = 0;
		int	notNumbers = 0;
		String current = " ";
		String[] data = new String[10];

		while (current != "")
		{
			current = input.getLine();
			if (input.isInteger(current) || input.isDouble(current) || input.isFloat(current))
			{
				data[lineCounter] = current;
				lineCounter++;
			}
			else
			{
				int res = lineCounter + notNumbers;
				System.err.println("A number has not been parsen from the line " + res);
				notNumbers++;
			}
			if (lineCounter == 10)
			{
				calculateDeviation(lineCounter, data);
				lineCounter = 0;
			}
		}
		if (lineCounter > 1)
		{
			calculateDeviation(lineCounter, data);
		}
	}
}