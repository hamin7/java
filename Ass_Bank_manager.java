import java.util.Scanner;

        public class Bank_manager
        {
            public static void main(String args[])
            {
              Account[] accounts = new Account[100];
              int accountCount = 0;     // Account배열의 인덱스랄까,,,
              String user_name=null;
              int balance=0, tmp=0, tmp1=0, tmp2=0;
              int withd=0, cb=0, send = 0;
              int aNumber = 0;
              int i;
              i = accountCount;


              create_account user = new create_account("user",0,0); // initilaize -- name,idber,Balance,Type

                    Scanner in = new Scanner(System.in);
                    Scanner string =new Scanner(System.in);
                    int userChoice;
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

                          case 1:


                        	  accounts[i] = new Account();
                                System.out.print("Enter your Name : ");
                                user_name=string.nextLine();
                                aNumber = (int)((Math.random() * 9000)+1000);
                                user.insert(user_name, aNumber);  // inserted
                                System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
                                System.out.println("**************************");
                                user.display_details();
                                i++;
                                break;

                        case 2: // deposite
                            System.out.print("Enter your account Number : ");
                            tmp=in.nextInt();
                         if(tmp==user.id)
                         {
                         System.out.print("Enter Amount Of Money : ");
                         balance=in.nextInt();
                         user.balance=balance;
                         System.out.println("\t Successfully Deposited.");
                         }
                             else
                            System.out.println("Wrong Accoount Number.");
                           break;

                          case 3: // withdraw money
                             System.out.print("Enter your account Number : ");
                              tmp=in.nextInt();

                                  if(tmp==user.id){
                                     if(user.balance==0)
                                     System.out.print("Your Account is Empty.");

                                     else{
                                     System.out.print("Enter Amout Of Money : ");
                                     withd=in.nextInt();

                                     if(withd>user.balance){
                                     System.out.print("Enter Valid Amout of Money : ");
                                     withd=in.nextInt();
                                     }
                                     else
                                     cb= user.withdraw(withd);
                                     System.out.println("Your Current Balance : "+cb);
                                     }
                                  }
                                     else
                                     System.out.println("Wrong Accoount Number.");
                                break;


                          case 5: // check balance

                              System.out.print("Enter your Account Number : ");
                              tmp=in.nextInt();

                                     if(tmp==user.id){
                                     System.out.println("Your Current Balance : "+user.balance);
                                     }
                                     else
                                     System.out.println("Wrong Accoount Number.");
                              break;

                          case 6: // display all info

                              System.out.print("Enter your Account Number :");
                              tmp=in.nextInt();
                                     if(tmp==user.id){
                                     user.display_details();
                                }else
                                     System.out.println("Wrong Accoount Number.");

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

             } //  end main function

        } //  end main class
