// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this is a manager class for  AccountDetail class  its includes methods as
// add new account , remove an account,search an account ,display all accounts etc

// used classes
// this class is a child class of AccountDetail to manage it properly




import java.util.ArrayList;
import java.util.Iterator;

public  class AccountManager extends AccountDetail {


    //  arraylist is already created in AccountDetail class
    ArrayList<AccountDetail> Accounts = new ArrayList<>();
    //  arrylist methods

    public void addAccount(AccountDetail accountDetail) {
       if (Accounts.contains(accountDetail)) {
           System.out.println("Account you are trying to  add already exist");
        } else {

            Accounts.add(accountDetail);
           System.out.println("Account Added Successfully");
       }
    }

    public void remove(String CNIC) {
        for (AccountDetail a : Accounts) {
            if (a.getCNIC().equalsIgnoreCase(CNIC)) {
                if (Accounts.remove(a)){
                System.out.println("-- Account is removed Successfully --");
            } else {
                System.out.println("-- Account dose not exist --");
            }
        }
    }}

    public void SearchAccount(String CNIC) {
        for (AccountDetail a:Accounts) {
            if (a.getCNIC().equalsIgnoreCase(CNIC)) {
                System.out.println("-- your Searched account exist --");
                System.out.println("-- Detail of your searched account is here --");
            a.displayAccount();
        } else {

        System.out.println("-- your searched account dose not exist --");
    }}}

    // using iterator to print all elements in a arrylist

    public void showAllAccounts() {


        Iterator<AccountDetail> it = Accounts.iterator();
       while (it.hasNext()) {
            it.next().displayAccount();
           System.out.println("-------------------------");

       }
    }

    // this method will update paid installments and will also update paid amount


    public void updateInstallments(String CNIC, int PaidInstallments) {

        for (AccountDetail a : Accounts) {
            if (a.getCNIC().equalsIgnoreCase(CNIC)) {
                System.out.println("-- your Searched account exist --");
                // calculating remaining installments

                a.setPaidInstallments(a.getTotalInstallments()-PaidInstallments);

                // calculating remaining amount

               a. setPaidAmount((int) (a.getInstallmentPerMonth()*PaidInstallments));

                // display message

                System.out.println("installments  and paid amount is updated on your account");
                System.out.println("-------Detail of your account After update--------");
                a.displayAccount();

            } else {
                System.out.println("-- your searched account dose not exist --");
            }
        }
    }



}
