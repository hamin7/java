package bank;

import java.util.Scanner;

public class Bank_Manager
{
	static Account[] accounts = new Account[100];
	static int accountCount = 0;     // Account배열의 인덱스랄까,,,

	public static void main(String args[])
    {

      Scanner in = new Scanner(System.in);

      int userChoice = 0;
      boolean quit = false;

      do
      {
                  System.out.println("1. Create Account");
                  System.out.println("2. Deposit money");
                  System.out.println("3. Withdraw money");
                  System.out.println("4. Send money");
                  System.out.println("5. Check balance");
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

	private void interestFunc()
	{
		System.out.print("Write the account number: ");
		String id = in.nextLine();
		Account acc = new Account();
		acc = searchAccount(id);
		try
		{
			new Thread(new InterestThread(acc)).start();
		} catch (NullPointerException e)
		{
			e.printStackTrace();
		}
	}

	private static void create_account()
	{
		Scanner in = new Scanner(System.in);

	    //Account[] accounts = new Account[100];
		//accounts[i] = new Account();

		//int aNumber = 0;
		//aNumber = (int)((Math.random() * 9000) + 1000);
		//int id = aNumber;

		System.out.println("Enter your Account address: ");
		String id = in.nextLine();
		//int id = Integer.parseInt(in.nextLine());

		System.out.println("Enter your Name : ");
		String owner = in.nextLine();
		System.out.println("Give me your money : ");
		int balance = Integer.parseInt(in.nextLine());

		Account account = new Account(id, owner, balance);     //***********************
		accounts [accountCount++] = account;

		System.out.println("Your Account Number is : " + id);

		System.out.println("\nCreating Account complete\n");
		System.out.println("**************************");
	}

	private static void deposite()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your account Number : ");
        String id = in.nextLine();
        System.out.println("How much do you want to deposite? : ");
        int money = Integer.parseInt(in.nextLine());   // ****************
        Account a = new Account();
        a = searchAccount(id);
				if (a != null)
				{
					a.setBalance(a.getBalance() + money);
	        System.out.println("Current Balance: " + a.getBalance());
	        System.out.println("Deposite is success. ");
				}

        /*
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
        */
	}



	private static void withdraw()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your account Number : ");
		String id = in.nextLine();
		System.out.println("How much do you want to withdraw?: ");
		int money = Integer.parseInt(in.nextLine());
		Account a = new Account();
		a = searchAccount(id);
		if (a != null)
		{
			a.setBalance(a.getBalance() - money);
			System.out.println("Current Balance : " + a.getBalance());
			System.out.println("Withdrawal is succeed. ");
		}

		/*
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
		*/
	}



	private static void send()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Write the withdrawal balance id: ");
		String id = in.nextLine();
		System.out.println("Write the deposite balance id: ");
		String id2 = in.nextLine();
		System.out.println("How much do you want to send? ");
		int money = Integer.parseInt(in.nextLine());
		Account a = new Account();
		Account b = new Account();
		a = searchAccount(id);
		b = searchAccount(id2);

		if (a != null && b != null)
		{
			a.setBalance(a.getBalance() - money);
			b.setBalance(b.getBalance() + money);
			System.out.println("Money send complete.");
		}

		/*
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
		*/
	}


	private static void check_balance()
	{
		Scanner in = new Scanner(System.in);
		 System.out.println("Enter your Account Number : ");
         String id = in.nextLine();
         Account a = new Account();
         a = searchAccount(id);
				 if (a != null)
				 {
					 a.setBalance(a.getBalance());
	         System.out.println("Current Balance : " + a.getBalance());
				 }



         /*
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
		*/
	}

	private static Account searchAccount(String id)      // 계좌 탐색 함수
	{
		for (int j = 0; j < accountCount; j++)
		{
			if ( accounts[j].getId().equals("id"))
				return accounts[j];
		}
		return null;
	}
}

