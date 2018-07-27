package bank;

public class NoMoneyException extends Exception
{
	public NoMoneyException()
	{
		System.out.println("You have not enough money");
	}
}
