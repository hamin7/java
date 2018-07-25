package bank;

import java.util.Scanner;

public class Bank_Manager
{
	public static void main(String args[])
    {
      Account[] accounts = new Account[100];
      int accountCount = 0;     // Account배열의 인덱스랄까,,,

      Scanner in = new Scanner(System.in);

      String user_name=null;
      
      int userChoice = 0;
      boolean quit = false;

      do
      {
                  System.out.println("1. Create Account");
                  System.out.println("2. Deposit money");
                  System.out.println("3. Withdraw money");
                  System.out.println("4. Send money");
                  System.out.println("5. Check balance");
                  System.out.println("6. Display Account Details");
                  System.out.println("0. to quit: \n");
                  System.out.print("Enter Your Choice : ");
                  userChoice = in.nextInt();

                  switch (userChoice)
                  {
                  case 1:     // create_account
                	      create_account();
                	      break;

                	  case 2: // deposite
                		  deposite();
                		  break;

                  case 3: // withdrawal
                	      withdraw();
                       break;

                  case 4 : // send money
                	       send();
                	       break;

                  case 5: // check balance
                	     check_balance();
                      break;

                  case 6: // display all info
                	     //display_balance();
                      break;
                  case 0:
                        quit = true;
                        break;
                  default:
                        System.out.println("Wrong Choice.");
                        break;
                  }
                  System.out.println("\n");
            } while (!quit);
            System.out.println("Thanks !");
            }

	private static void create_account()
	{
		Scanner in = new Scanner(System.in);
		int accountCount = 0;
		int i;
	    i = accountCount;
		
	    Account[] accounts = new Account[100];
		accounts[i] = new Account();
		
		int aNumber = 0;
		aNumber = (int)((Math.random() * 9000) + 1000);
		int id = aNumber;

		System.out.print("Enter your Name : ");
		String owner = in.nextLine();
		System.out.print("Give me your money : ");
		int balance = Integer.parseInt(in.nextLine());
		
		Account account = new Account(id, owner, balance);     //***********************
	
		System.out.print("Your Account Number is : " + aNumber);
		
		System.out.println("\nCreating Account complete\n");
		System.out.println("**************************");
		
		i++;
	}


	private static void deposite()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your account Number : ");
        int id = in.nextInt();
        System.out.print("How much do you want to deposite? : ");
        int money = Integer.parseInt(in.nextLine());   // ****************
        Account a = new Account();
        a = searchAccount(id);
        try
        {
        	if (a != null)
        	{
        		a.setBalance(a.getBalance() + money);
        		System.out.println("Current Balance: " + a.getBalance());
        		System.out.println("Deposite is success.");
        	} else
        		throw new NoAccountException();
        } catch (NoAccountException e)
        {
        	e.printStackTrace();
        }
	}

	public static class NoAccountException extends Exception
	{
		public NoAccountException()
		{
			System.out.println("Wrong Account");
		}
	}

	private static void withdraw()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your account Number : ");
		int id = in.nextInt();
		System.out.print("How much do you want to withdraw?: ");
		int money = Integer.parseInt(in.nextLine());
		Account a = new Account();
		a = searchAccount(id);
		try
		{
			if (a != null)
			{
				try
				{
					if (money < a.getBalance())
					{
						a.setBalance(a.getBalance() - money);
						System.out.println("Current Balance : " + a.getBalance());
						System.out.println("Withdrawal is succeed.");
					} else
						throw new NoMoneyException();
				} catch (NoMoneyException m)
				{
					m.printStackTrace();
				}
			} else
				throw new NoAccountException();
		} catch (NoAccountException e)
		{
			e.printStackTrace();
		}
	}

	public static class NoMoneyException extends Exception
	{
		public NoMoneyException()
		{
			System.out.println("You have not enough money");
		}
	}

	private static void send()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Write the withdrawal balance id: ");
		int id = in.nextInt();
		System.out.print("Write the deposite balance id: ");
		int id2 = in.nextInt();
		System.out.print("How much do you want to send? ");
		int money = Integer.parseInt(in.nextLine());
		Account a = new Account();
		Account b = new Account();
		a = searchAccount(id);
		b = searchAccount(id2);

		try
		{
			if (a != null && b != null)
			{
				try
				{
					if (a.getBalance() > money)
					{
						a.setBalance(a.getBalance() - money);
						b.setBalance(b.getBalance() + money);
						System.out.println("Money send complete.");
					} else
						throw new NoMoneyException();
				} catch (NoMoneyException m)
				{
					m.printStackTrace();     //throw
					System.out.println("You have not enough money.");
				}
			} else
				throw new NoAccountException();
		} catch (NoAccountException e)
		{
			e.printStackTrace();
		}
	}

	
	private static void check_balance()
	{
		Scanner in = new Scanner(System.in);
		 System.out.print("Enter your Account Number : ");
         int id = in.nextInt();
         Account a = new Account();
         a = searchAccount(id);
		try
		{
			if (a != null)
			{
				a.setBalance(a.getBalance());
				System.out.println("Current Balance : " + a.getBalance());				
			} else 
				throw new NoAccountException ();
		} catch (NoAccountException n)
		{
			n.printStackTrace();
		}
	}
	

	
	private static void Display_Balance()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your Account Number : ");
		int id = in.nextInt();
		Account a = new Account();
		a = searchAccount(id);
	}

	
	private static Account searchAccount(int id)      // 계좌 탐색 함수
	{	
		for (int j = 0; j < 100; j++)
		{
			if ( accounts[j].getId()==id)
				return accounts[j];
		}
		return null;
	}
	
}
