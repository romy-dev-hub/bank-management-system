package bankManagement;

public class application {
    public static void main(String[] args){

        bankAccount acc1 = new bankAccount("123456", "cheking", "xiao",
                "roro", "algeria", 1000);
        bankAccount acc2 = new bankAccount("78910", "savings", "ling",
                "dilan", "china", 1500);

        //deposit info
        acc1.displayInfos();
        acc2.displayInfos();

        //deposit money
        acc1.Deposit(500);

        //withdraw money
        acc1.Withdraw(700);

        //transfer money
        acc1.Transfer(acc2, 200);

        // applying interest
        acc2.ApplyInterest(5); //and it's only for savings accounts

        //compare balances
        bankAccount richer = bankAccount.Compare(acc1, acc2);
        System.out.print("\nthe richer is: "+richer.getAccountNumber());

        //close account
        acc1.Close();

        //display total accounts created
        bankAccount.DisplayAccountNumber();

    }
}
