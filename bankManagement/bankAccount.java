package bankManagement;

public class bankAccount {

    private static final String Bank_Name = "AL-BARAKA"; //final means it won't change anymore
    private static final String Agency_Code = "AGENCE-CODE-107";
    private static final double SEUIL_ALERT = 50.0;

    private String accountNumber;
    private String accountType;
    private String clientName;
    private String clientFirstname;
    private String clientAddress;
    private double balance;
    private static int AccountNumbers = 0;

    // CONSTRUCTOR
    public bankAccount (String accountNumber, String accountType,
                        String clientName, String clientFirstname,
                        String clientAddress, double balance){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.clientName = clientName;
        this.clientFirstname = clientFirstname;
        this.clientAddress = clientAddress;
        this.balance = balance;
        AccountNumbers++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountType(){
        return accountType;
    }

    public void displayInfos(){
        System.out.print("\nAccount information:");
        System.out.print("\nBank: "+Bank_Name+", Agency: "+Agency_Code);
        System.out.print("\nAccount: "+accountNumber+" ("+accountType+") ");
        System.out.print("\nClient: "+clientName+" "+ clientFirstname);
        System.out.print("\nAddress: "+clientAddress);
        System.out.print("\nSolde: "+balance);
    }

    //deposit money
    public void Deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.print("\ndeposit of "+amount+" DA, new balance: "+balance+" DA");
        }else{
            System.out.print("\ninvalid amount");
        }
    }

    //withdraw money with balance verification
    public void Withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.print("\nWithdraw of "+amount+" DA, New solde: "+balance+" DA");
            if(balance < SEUIL_ALERT){
                System.out.print("\nAlerte: low balance !");
            }
        }else{
            System.out.print("\ninsufficient funds.");
        }
    }

    //transfer money between accounts
    public void Transfer(bankAccount destination, double amount){
        if (amount > 0 && amount <= balance){
            this.Withdraw(amount);
            destination.Deposit(amount);
            System.out.print("\ntransfer of "+amount+" DA to this bank account: "+destination.accountNumber);
        }else{
            System.out.print("\nunable to transfer! check balance.");
        }
    }

    //apply interest for savings accounts
    public void ApplyInterest(double t){
        if(accountType.equalsIgnoreCase("savings")){
            balance += balance * t / 100;
            System.out.print("\napplied interest ("+t+" %). New balance: "+balance+" DA");
        }else{
            System.out.print("\nthis account is not a savings account !");
        }
    }

    //compare two accounts
    public static bankAccount Compare(bankAccount b1, bankAccount b2){
        return (b1.balance > b2.balance) ? b1 : b2;
    }

    // close an account
    public void Close(){
        balance = 0;
        System.out.print("\naccount: "+accountNumber+" has been closed.");
    }

    //display total numbers of created accounts
    public static void DisplayAccountNumber(){
        System.out.print("\ntotal numbers of created accounts: "+AccountNumbers);
    }



}
