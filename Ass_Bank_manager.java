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
      //int tmp=0, tmp1=0, tmp2=0;
      //int withd=0, cb=0, send = 0;
      int i;
      i = accountCount;
      
      //Scanner string =new Scanner(System.in);
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
                		  // deposite();
                		  break;
                    
                  case 3: // withdraw money
                     
                        break;
                       
                  case 4 : // send money
                	  
                	  
                  case 5: // check balance

                     
                      break;

                  case 6: // display all info

                      
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
		int aNumber = 0;
		aNumber = (int)((Math.random() * 9000) + 1000);
		int id = aNumber;
  	  
		System.out.print("Enter your Name : ");
		String owner = in.nextLine();
		System.out.print("Give me your money : ");
		int balance = Integer.parseInt(in.nextLine());
		//user_name=string.nextLine();
		//user.insert(user_name, aNumber);  // inserted
		// accountList.add(account);
		Account account = new Account(id, owner, balance);
		System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
		System.out.println("**************************");
		//user.display_details();
		//i++;
	}
	
	
	private static void deposite()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your account Number : ");
        int id = in.nextInt();
        System.out.print("How much do you want to deposite? : ");
        int deposite = Integer.parseInt(in.nextLine());   // ****************
        Account a = new Account();
        a = searchAccount(id);
        
	}
	
	private static void withdraw()
	{
		
	}
	
	
	private static void send()
	{
		
	}
	
	/*
	private static void check_balance()
	{
		 System.out.print("Enter your Account Number : ");
                      tmp=in.nextInt();

                             if(tmp==user.id){
                             System.out.println("Your Current Balance : "+user.balance);
                             }
                             else
                             System.out.println("Wrong Accoount Number.");
	}
	*/
	
	/*
	private static void Disply_Balance()
	{
		System.out.print("Enter your Account Number :");
        tmp=in.nextInt();
               if(tmp==user.id){
               user.display_details();
          }else
               System.out.println("Wrong Accoount Number.");
	}
	*/
	
	
	private Account searchAccount(int id)      // 계좌 탐색 함수
	{
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getId().equals(id))
				return accounts.get(i);
		}
		return null;
	}
	
}
