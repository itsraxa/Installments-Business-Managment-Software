// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this class holds all the  attributes of a purchased item
// like name of item  ,price of item , quantity  etc and their setter and getter methods
// along with a method which will calculate selling price and profit for a purchased item

// used classes
// no class of project is used in this class



import java.util.Scanner;

public class AllPurchases {

    // declaring field variables


    public String CompanyName;
    public String itemName;
    public double PricePerUnit;
    public int Quantity;
    public double sellingAmount;
    public int TotalPurchasesAmountOfOneItem;
    public double TotalProfitOfOneItem;

    // setter methods

    // creating scanner object

    Scanner sc = new Scanner(System.in);

    public void setCompanyName() {
        System.out.println("Enter company Name");
        CompanyName = sc.nextLine();
    }

    public void setItemName() {
        System.out.println("Enter Item Name");
        this.itemName = sc.nextLine();
    }
        public void setPricePerUnit () {
        System.out.println("Enter price of one item");
        PricePerUnit = sc.nextDouble();
        sc.nextLine();
    }

        public void setQuantity () {
        System.out.println("Enter quantity of item ");
        Quantity = sc.nextInt();
        sc.nextLine();
    }

    // there is the method for updating the purchase price


    public  void updatePurchasePrice(double newPurchasePrice){
       this. PricePerUnit= newPurchasePrice;
       System.out.println("purchase price is updated to  = "+PricePerUnit);
    }




            // calculations methods

        // to calculate purchase which is paid in purchasing that item stock

    protected void TotalPurchasesAmountOfOneItem(){
       this.TotalPurchasesAmountOfOneItem= (int) (getPricePerUnit()*getQuantity());
    }




    // to calculate selling amount of one particular item

    protected void sellingAmountOfOneItem (){

        // 5 percent profit will be added to purchase amount

      double fivePer=getPricePerUnit()*0.05;

      // adding 5 percent to get new selling amount

        this.sellingAmount=getPricePerUnit()+fivePer;
    }



    // to calculate profit gained after selling one particular item

    protected void CalculateProfitOfOneItem (){

        this.TotalProfitOfOneItem=(getSellingAmount()-getPricePerUnit())*getQuantity();
        //                total profit  =  profit  *                     quantity
    }












    // getter methods


    public String getItemName() {
        return itemName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public double getPricePerUnit() {
        return PricePerUnit;
    }

    public int getQuantity() {
        return Quantity;
    }

    public int getTotalPurchasesAmountOfOneItem() {
        return TotalPurchasesAmountOfOneItem;
    }

    public double getSellingAmount() {
        return sellingAmount;
    }

    public double getTotalProfitOfOneItem() {
        return TotalProfitOfOneItem;
    }





    // display method which will display detail of one particular item which is purchased


    public void displayPurchaseDetail(){
        System.out.println("Company Name                        = "+getCompanyName());
        System.out.println("Item Name                           = "+getItemName());
        System.out.println("Price per unit                      = "+getPricePerUnit());
        System.out.println("Items Quantity                      = "+getQuantity());
        System.out.println("selling amount                      = "+getSellingAmount());
        System.out.println("Total Purchase amount of that item  = "+getTotalPurchasesAmountOfOneItem());
        System.out.println("Total Profit amount of that item    = "+getTotalProfitOfOneItem());
    }
}
