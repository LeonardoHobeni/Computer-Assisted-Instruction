//Program helps an elementery student learn multiplication by quizzing
//Author: Bonga L. Hobeni
//23/02/2022
import java.util.Scanner;
import java.security.SecureRandom;
public class CAI{
	public static void main(String[] args)
	{
		Arithmetic question = new Arithmetic();
		Scanner input = new Scanner(System.in);
		int value1,level,arithmetic_type;
		question.DisplayLevelOptions();
		System.out.printf("Insert the level you want to try, e.g. 1 for one digit level: ");
		level = input.nextInt();
		question.DisplayArithmeticOption();
		System.out.printf("insert the arithmetic option you want to try: ");
		arithmetic_type = input.nextInt();
		question.generateQuestions(level,arithmetic_type);
		question.DisplayQuestion();
		value1 = input.nextInt();
		while(value1 != -1)
		{	question.countAnswers();//counting answers
			if(question.isCorrectAnswer(value1))
			{	
				question.countCorrectAnswers();//counting correct answers
				question.CorrectAnswerComments();
			}
			else
				while(!question.isCorrectAnswer(value1))
				{
					question.IncorrectAnswerComments();
					question.DisplayQuestion();
					value1 = input.nextInt();
					if(question.isCorrectAnswer(value1))
						question.CorrectAnswerComments();
						
				}
			if(question.isCorrectAnswer(value1))
				System.out.printf("To terminate program enter -1:%n%n");
			if(question.getCountedAnswers() == 10)
			{
				if(question.getPercentage() >= 75)
				{
					System.out.printf("Congratulations, you are ready to go to the next level.%n%n");
					question.DisplayLevelOptions();
					System.out.printf("Insert the level you want to try, e.g. 1 for one digit level: ");
					level = input.nextInt();
					question.DisplayArithmeticOption();
					System.out.printf("insert the arithmetic option you want to try: ");
					arithmetic_type = input.nextInt();
				}
				else
					System.out.printf("Please ask your teacher for extra help.%n%n");
				question.resetProgram();
			}
			question.generateQuestions(level,arithmetic_type);
			question.DisplayQuestion();
			value1 = input.nextInt();
		}
	}
}

class Arithmetic
{
	private int value1;//instance variable holds the value of the first integer
	private int value2;//instance variable holds the value of the second integer
	private int product;//instance variable holds the value of the product
	private int sum;//instance variable holds the value of the sum
	private int difference;//instance variable holds the value of the difference
	private int quotient;//instance variable holds the value of the qoutient
	SecureRandom randInt = new SecureRandom();//random object
	private int count_answers = 0;//Instance variable to hold number of counted answers
	private int count_correct_answers = 0;//Instance variable to hold the number of
									  //correct answers
	int type;//instance variable holds the random value
	public void DisplayLevelOptions()
	{
		System.out.printf("1.One digit integer level.%n2.Two digit integer level.%n");
		System.out.printf("3.Three digit integer level.%n4.Four digit integer level.%n%n");
	}
	
	public void DisplayArithmeticOption()
	{
		System.out.printf("1.Addition%n2.Subtraction%n3.Multiplication%n4.Division%n%n");
	}
	
	public void mixedArithmetics()
	{
		//computing the selected arithmetic type
		type = 1+randInt.nextInt(4);
		switch(type)
		{
		case 1:
			//addition
			computeSum();
			break;
		case 2:
			//subtraction
			computeDifference();
			break;
		case 3:
			//multiplication
	    	computeProduct();
			break;
		case 4:
			//division
			computeQuotient();
			break;
		}
	}
	public void generateQuestions(int level, int arithmetic_type)
	{	
		//generating non-deterministic random integers
		switch(level)
		{
		case 1:
			//generating one-digit integer
			value1 = 1+randInt.nextInt(9);
			value2 = 1+randInt.nextInt(9);
			break;
		case 2:
			//generating two-digits integer
			value1 = 10+randInt.nextInt(89);
			value2 = 10+randInt.nextInt(89);
			break;
		case 3:
			//generating three-digit integer
			value1 = 100+randInt.nextInt(899);
			value2 = 100+randInt.nextInt(899);
			break;
		case 4:
			//generating four-digit integer
			value1 = 1000+randInt.nextInt(8999);
			value2 = 1000+randInt.nextInt(8999); 
			break;
		}
		
		//computing the selected arithmetic type
		if(arithmetic_type != 5)
			type = arithmetic_type;
		switch(arithmetic_type)
		{
		case 1:
			//addition
			computeSum();
			break;
		case 2:
			//subtraction
			computeDifference();
			break;
		case 3:
			//multiplication
			computeProduct();
			break;
		case 4:
			//division
			computeQuotient();
			break;
		case 5:
			//mixed
			mixedArithmetics();
		}
	}
	
	public boolean isCorrectAnswer(int val)
	{	
		//checking if answer is correct
		if(val == product)
			return true;
		else if(val == sum)
			return true;
		else if(val == difference)
			return true;
		else if(val ==  quotient)
			return true;
		return false;
	}
	
	public void computeProduct()
	{
		//calculating product
		product = value1 * value2;
	}
	
	public void computeSum()
	{
		//calculating sum 
		sum = value1 + value2;
	}
	
	public void computeDifference()
	{
		//calculating difference
		difference = value1 - value2;
	}
	
	public void computeQuotient()
	{
		//calculating quotient
		quotient = value1/value2;
	}
	
	public void CorrectAnswerComments()
	{
		//displaying random comments for correct answers
		int option;
		option = 1+randInt.nextInt(4);
		switch(option)
		{//random comments
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	public void IncorrectAnswerComments()
	{
		//displaying random comments for incorrect answers
		int option;
		option = 1+randInt.nextInt(4);
		switch(option)
		{//random comments
		case 1:
			System.out.println("No. Please try again.");
			System.out.println();
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			System.out.println();
			break;
		case 3:
			System.out.println("Don't give up!");
			System.out.println();
			break;
		case 4:
			System.out.println("No. Keep trying.");
			System.out.println();
			break;
		}
	}
	
	public void DisplayQuestion()
	{
		//displaying question
		switch(type)
		{
		case 1:
			//addition
			System.out.printf("How much is %d plus %d? ", value1, value2);
			break;
		case 2:
			//subtraction
			System.out.printf("How much is %d minus %d? ", value1, value2);
			break;
		case 3:
			//multiplication
			System.out.printf("How much is %d times %d? ", value1, value2);
			break;
		case 4:
			//division
			System.out.printf("How much is %d divide by %d? ", value1, value2);
			break;
		}
		
	}
	
	public void countAnswers()
	{
		//counting number of answers
		count_answers++;
	}
	
	public int getCountedAnswers()
	{
		//returning the value of counted answers
		return count_answers;
	}
	
	public void countCorrectAnswers()
	{
		//counting correct answers
		count_correct_answers++;
	}
	
	public int getCountedCorrectAnswers()
	{
		//returning the value of correct answers
		return count_correct_answers;
	}
	public int getPercentage()
	{
		return (getCountedCorrectAnswers()/getCountedAnswers())*100;
	}
	public void resetProgram()
	{
		//reseting the correct answers count and answers count
		count_correct_answers = 0;
		count_answers = 0;
	}
}
