package bank;

public class InterestThread implements Runnable
{
  Account account;
  public InterestThread(Account account)
  {
    this.account = account;
  }
  public void run()
  {
      try
      {
        Thread.sleep(1000);
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      account.interest();
    
  }
}

//while(true)가 
