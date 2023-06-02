// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this class holds the some additional attributes of a customer
// like name of item  ,price of item , installments etc and their setter and getter methods
// along with a method which will calculate installments for a customer

// used classes
// Account class of project is used in this class this class is child class
// of Account and usese some of its methods




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountDetail extends Account {

    // creating arryalist of type AccountDetail

    ArrayList<AccountDetail> Accounts = new ArrayList<>();


    // field variables

    public String itemName;
    public int itemPrice;
    public int installmentPerMonth;
    public int paidInstallments=0;
    public int totalInstallments=0;
    public int totalAmount;
    public int PaidAmount;


    // setter methods

    // creating scanner object

    Scanner sc = new Scanner(System.in);

    public void setItemName() {
        System.out.println("Enter item Name");
        this.itemName = sc.nextLine();
    }

    public void setItemPrice() {
        System.out.println("Enter Item Price");
        this.itemPrice = sc.nextInt();
        sc.nextLine();
    }


    public void setInstallmentPerMonth(int installmentPerMonth) {
    this.installmentPerMonth = installmentPerMonth;
 }

    public void setPaidInstallments(int paidInstallments) {
        this.paidInstallments = paidInstallments;
    }

    public void setTotalInstallments(int totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public  void setPaidInstallments(){
        System.out.println("how many installments have paid");
        this.paidInstallments= sc.nextInt();
    }




    public void setPaidAmount(int oneItemPaidAmount) {

        this.PaidAmount = oneItemPaidAmount;
    }




    // some calculations


    //  calculating installment per month

    public void calculateInstallmentPerMonth(){

        // calculating 25 percent of the the item price whill will be added to the
        // orignal item price to calculate installment price of that item

    int perc25=0;
    perc25= (int) (getItemPrice()*(0.25));// we have to get interger amount bcz customer can not pay i.e. 0.85

        // calculating new price after adding 25 percent of old price

        int newPrice= (int) (getItemPrice()+perc25);

        // calculating installment per month by dividing new price
        // by 8 if new price is less than or equal to 30,000 (8 months)


        if (newPrice<=30000){

            setTotalAmount(newPrice);
           setInstallmentPerMonth(newPrice/8);
            setTotalInstallments(8);
        }else
            // if new price is less than 80000 and more than 30000 than customer will have
            // to pay total price in 16 months

            if (newPrice<80000){
                setTotalAmount(newPrice);
                setInstallmentPerMonth(newPrice/16);
                setTotalInstallments(16);

        }
            // in case the item price excedes 80,000 customer will have to pay total amount in 20 months

            else {

                setTotalAmount(newPrice);
                setInstallmentPerMonth(newPrice/20);
                setTotalInstallments(20);

            } }








    // getter methods

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getInstallmentPerMonth() {
        return installmentPerMonth;
    }

    public int getPaidInstallments() {
        return paidInstallments;
    }

    public int getTotalAmount() {
        return totalAmount;
    }



    public int getTotalInstallments() {
        return totalInstallments;
    }


    public int getPaidAmount() {
        return PaidAmount;
    }





    // to display all detail of an account

    public void displayAccount(){
        System.out.println(" Account Number          = "+getAccountNO());
        System.out.println(" Name                    = "+getCustomerName());
        System.out.println(" CNIC Number             = "+getCNIC());
        System.out.println(" Item  Name              = "+getItemName());
        System.out.println(" Price of item           = "+getItemPrice());
        System.out.println(" Installment per month   = "+getInstallmentPerMonth());
        System.out.println(" Total installments      = "+getTotalInstallments());
        System.out.println(" Total paid installments = "+getPaidInstallments());
        System.out.println(" Total paid Amount       = "+getPaidAmount());
        System.out.println(" Total payable amount    = "+getTotalAmount());

        System.out.println("------------------------------------------------------");
    }

        }





