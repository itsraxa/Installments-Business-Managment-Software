// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this class holds the some method to calculate purchases ,profit and collection on monthly basis
//  it also contain display method to display monthly report and their setter and getter methods
//  all the methods in this class are implemented either from an interface or an abstract class

// used classes
//  this class of project is extended by purchaseCalculation abstract class and it implement an interface
//  with name calculation for account class



import java.util.ArrayList;

public class  MonthlyReport extends PurchaseCalculations implements CalculationsForAccountClass {

    private int MonthlyPurchaseAmount;
    private int MonthlyInstallmentCollection;
    private int purchaseProfit;
    private  int MonthlyProfitFromInstallmentCollection;   // this variable will hold profit from installments collected in a month
    private int TotalProfitAmount;


    // setter methods


    //  defining abstract methods

    @Override
    public void CalculateMonthlyPurchaseAmount(PurchaseManager purchaseManager) {
        for (AllPurchases p : purchaseManager.PurchaseRecord) {
            this.MonthlyPurchaseAmount += p.getTotalPurchasesAmountOfOneItem();
        }
    }

    @Override
    void CalculatePurchaseProfit(PurchaseManager purchaseManager) {
        for (AllPurchases a : purchaseManager.PurchaseRecord) {
            purchaseProfit += a.getTotalProfitOfOneItem();
        }
    }


    // describing methods of interface


    @Override
    public void CalculateTotalCollections(AccountDetail accountDetail) {
        for (AccountDetail a : accountDetail.Accounts) {
            this.MonthlyInstallmentCollection += a.getInstallmentPerMonth();
        }
    }


    @Override
    public void CalculateProfitFromCollections(AccountDetail accountDetail) {

        double per2=0 ;  // this will hod 2 per profit collected in every installment from customer
        for (AccountDetail a : accountDetail.Accounts) {
            per2 = (a.getInstallmentPerMonth())*0.02;
            this.MonthlyProfitFromInstallmentCollection += per2;
        }
    }

    // this method will calculate  total profit from both collections and purchases


    public void CalculateTotalProfit(){

        this.TotalProfitAmount=getPurchaseProfit()+getMonthlyProfitFromInstallmentCollection();

    }



    //  getter methods


    public int getTotalPurchaseAmount() {
        return MonthlyPurchaseAmount;
    }

    public int getTotalInstallmentCollection() {
        return MonthlyInstallmentCollection;
    }

    public int getTotalProfitAmount() {
        return TotalProfitAmount;
    }

    public int getPurchaseProfit() {
        return purchaseProfit;
    }

    public int getMonthlyProfitFromInstallmentCollection() {
        return MonthlyProfitFromInstallmentCollection;
    }



    // display method of monthly report which will display diff amounts of concern


    public void displayMonthlyReport() {

        System.out.println(" purchases in whole month                      =" + getTotalPurchaseAmount());
        System.out.println(" Profit Amount of items After direct Selling   =" + getPurchaseProfit());
        System.out.println(" collected amount in whole month               =" + getTotalInstallmentCollection());
        System.out.println(" profit from collected amount in whole month   =" + getMonthlyProfitFromInstallmentCollection());
        System.out.println(" Total profit collected in whole month         =" + getTotalProfitAmount());


    }


}

