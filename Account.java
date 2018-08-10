package bank;

public class Account
{
    String owner;     //사용자 이름
    private String id;           // 계좌
    private int balance;      // 잔액

    // toString
    @Override
    public String toString()
    {
    	        return "Account [Account Number=" +id + ", Owner=" + owner + ", Balance=" + balance + "]";
    }


    // 기본 생성자
    public Account()
    {
    	super();
    }
    // 메뉴의 Source -> Generate Constructor using Fields 들어가서 한 번에 생성할 수 있음.

    public Account(String id,String owner,int balance)
    {
            this.owner=owner;
            this.id=id;
            this.balance=balance;
        }

    // Getter & Setter
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void interest()
	{
		balance *= 1.05;
	}

}



/*
class create_account extends Account
{
    create_account(String n,int id,int b)
    { // pass owner and account type
            owner=n;
            id=id;
            balance=b;
    }
    create_account()
    {
        super();
    }

    void insert(String n,int aNumber)
    { // input user owner, account number and type
        owner = n;
        id = aNumber; // generate random number
        balance = 0;
    }

    void display_details()
    {
        System.out.println("Depositor owner :" +owner);
        System.out.println("Account Number : "+id);
        System.out.println("Account Balance : "+balance);
    }

        void deposite(int id,int money)
        {
                balance=money;
        }

        int withdraw(int withd)
        {
                balance=balance-withd;
                return balance;
        }

} // end class
*/
