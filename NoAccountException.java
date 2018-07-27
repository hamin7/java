package bank;

public class NoAccountException extends Exception
{
	public NoAccountException()
	{
		System.out.println("Wrong Account");
	}
}
