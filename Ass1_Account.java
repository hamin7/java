
public class Account
{
    String owner;     //사용자 이름
    int id;           // 계좌
    int balance;      // 잔액
    public Account() {}      // 기본 생성자

    // 메뉴의 Source -> Generate Constructor using Fields 들어가서 한 번에 생성할 수 있음.

    public Account(String n,int id,int b)
    {
            owner=n;
            id=id;
            balance=b;
        }
} // end class

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
