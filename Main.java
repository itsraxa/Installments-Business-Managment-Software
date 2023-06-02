// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// it is main class of project

// used classes
// no class of project is used in this class



import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {


    public Main() throws IOException {
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        // crating files for saving permanently added accounts complains and purchase items
        File AccountfileObj = new File("E:\\030-BSCS-2019(Section C)-Installment Business Software\\database\\AccountsData.text");
        File PurchasefileObj = new File("E:\\030-BSCS-2019(Section C)-Installment Business Software\\database\\PurchaseData.text");
        File ComplainfileObj = new File("E:\\030-BSCS-2019(Section C)-Installment Business Software\\database\\ComplainData.text");

        // deleting already saved files
        AccountfileObj.delete();
        PurchasefileObj.delete();
        ComplainfileObj.delete();

        // creating objects of diff classes
        int accountCounter=0;
        AccountDetail [] AccountObjects = new AccountDetail[10];
        AccountManager accountManager = new AccountManager();
        AccountDetail account1 = new AccountDetail();AccountDetail account2 = new AccountDetail(); AccountDetail account3 = new AccountDetail();AccountDetail account4 = new AccountDetail(); AccountDetail account5 = new AccountDetail();
        AccountObjects[accountCounter] = account1;AccountObjects[1]=account2;AccountObjects[2]=account3;AccountObjects[3]=account4;AccountObjects[4]=account5;

        int purchaseCounter=0;
        AllPurchases [] PurchaseObjects = new AllPurchases[10];
        AllPurchases purchaseItem1 = new AllPurchases();AllPurchases purchaseItem2 = new AllPurchases();AllPurchases purchaseItem3 = new AllPurchases();AllPurchases purchaseItem4 = new AllPurchases();AllPurchases purchaseItem5 = new AllPurchases();
        PurchaseObjects[purchaseCounter]=purchaseItem1;PurchaseObjects[1]=purchaseItem2;PurchaseObjects[2]=purchaseItem3;PurchaseObjects[3]=purchaseItem4;PurchaseObjects[4]=purchaseItem5;
        PurchaseManager purchaseManager = new PurchaseManager();

        int ComplainCounter=0;
        Complain [] ComplainObjects = new Complain[10];
        Complain complain1 = new Complain();Complain complain2 = new Complain();Complain complain3 = new Complain();Complain complain4 = new Complain();Complain complain5 = new Complain();
        ComplainObjects[ComplainCounter]=complain1;ComplainObjects[1]=complain2;ComplainObjects[2]=complain3;ComplainObjects[3]=complain4;ComplainObjects[4]=complain5;
        ComplainManagment complainManagment = new ComplainManagment();


        String redo = "n";  // this will hold user will of redoing task either yes or no
        int option = 0;        // this will hold option number from menu about which operation user want to perform
        int password = 0;       // This will hold default password which user will type

        //  creating scanner object


        Scanner input = new Scanner(System.in);


        System.out.println("ENTER PASSWORD   default(12345)");
        password = input.nextInt();
        input.nextLine();       // this hold extra line after executing NextInt()


        if (password == 12345) {


            do {
                System.out.println("*************************Account Management Section**********************************");
                System.out.println("|       1.Add New Account                               2.Search Account               |");
                System.out.println("|       3.Remove Account                                4.Display All Accounts         |");
                System.out.println("|       5.Update Account Installments                   6.Display Saved Accounts       |");
                System.out.println("*************************************************************************************");
                System.out.println("*************************Purchase Management Section**********************************");
                System.out.println("|       7.Add New Purchase Detail                       8.Search Purchased Item        |");
                System.out.println("|       9.Remove Purchased Item                         10.Display All Purchases       |");
                System.out.println("|       11.Update Purchased Item Price                 12.Display Saved Purchase Items |");
                System.out.println("*************************************************************************************");
                System.out.println("*************************Complain Management Section**********************************");
                System.out.println("|       13.Add New Complain                              14.Search Complain            |");
                System.out.println("|       15.Remove Complain                               16.Display Complain           |");
                System.out.println("|       17.Update Complain Description                   18.Update Complain Status     |");
                System.out.println("|       19.Display Saved Complains                                                     |");
                System.out.println("**************************************************************************************");
                System.out.println("******************************Monthly Report Section**********************************");
                System.out.println("|       20.Display Monthly Report                        21.EXIT                       |");
                System.out.println("***************************************************************************************");
                System.out.println("                                                                                       ");
                System.out.println("                                                                                       ");

                System.out.println("Which Task You Wanna Perform Enter NUMBER");
                option = input.nextInt();
                input.nextLine();    //  this line will consume one line after nextInt()

                switch (option) {
                    case 1:

                        do {

                            AccountObjects[accountCounter].setAccountNO();
                            AccountObjects[accountCounter].setCustomerName();
                            AccountObjects[accountCounter].setCNIC();
                            AccountObjects[accountCounter].setItemName();
                            AccountObjects[accountCounter].setItemPrice();

                            // calling different methods of acount detail class

                            AccountObjects[accountCounter].calculateInstallmentPerMonth();
                            accountManager.addAccount(AccountObjects[accountCounter]);

                                // as we add account in arraylist this account will also be saved to file in database folder


                            if (AccountfileObj.createNewFile()) {
                                System.out.println("file created with name ("+AccountfileObj.getName()+") to save your account permanently");
                            } else {
                                System.out.println("file with name("+AccountfileObj.getName()+") already created but your new account is saved in it permanently  ");
                            }
                            FileWriter pen = new FileWriter(AccountfileObj, true);
                                pen.write(AccountObjects[accountCounter].getAccountNO()+","+AccountObjects[accountCounter].getCustomerName()+","
                                        +AccountObjects[accountCounter].getCNIC()+","+AccountObjects[accountCounter].getItemName()+","
                                        +AccountObjects[accountCounter].getInstallmentPerMonth()+","+AccountObjects[accountCounter].getPaidInstallments()
                                        +","+AccountObjects[accountCounter].getTotalInstallments()+"," +AccountObjects[accountCounter].getPaidAmount()
                                        +","+AccountObjects[accountCounter].getTotalAmount()+"\n");
                            pen.close();



                            System.out.println("Do you wanna ADD another Account y/n");
                            redo = input.nextLine();
                            accountCounter++;
                        }
                        while (redo.equalsIgnoreCase("y"));

                        break;

                    case 2:
                        do {
                            System.out.println("you have to Enter Customer CNIC you wanna Search");
                            String AccountCNIC = input.nextLine();
                            accountManager.SearchAccount(AccountCNIC);
                            System.out.println("Do you wanna SEARCH another Account y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;

                    case 3:
                        do {
                            System.out.println("you have to Enter Customer CNIC you wanna remove");
                            String AccountCNIC = input.nextLine();
                            accountManager.remove(AccountCNIC);
                            System.out.println("Do you wanna REMOVE another Account y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 4:
                        accountManager.showAllAccounts();
                        break;
                    case 5:
                        do {
                            String CNIC;
                            int PaidInstallments;
                            System.out.println("Please Enter CNIC of customer");
                            CNIC = input.nextLine();
                            System.out.println("Please Enter how many Installments Have been paid");
                            PaidInstallments = input.nextInt();
                            input.nextLine();
                            accountManager.updateInstallments(CNIC, PaidInstallments);
                            System.out.println("Do you wanna again UPDATE installments y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 6:

                        // reading objects from file that are permanently stored
                        Scanner AccountfileReader = new Scanner(AccountfileObj);
                        ArrayList<AccountDetail> AccountfinalList = new ArrayList<>();
                        while (AccountfileReader.hasNextLine()) {
                            String buffer = AccountfileReader.nextLine();
                            String[] testString = buffer.split(",");
                            AccountDetail accountDetail = new AccountDetail();
                            accountDetail.accountNO = Integer.parseInt(testString[0]);
                            accountDetail.customerName = testString[1];
                            accountDetail.CNIC = testString[2];
                            accountDetail.itemName = testString[3];
                            accountDetail.installmentPerMonth = (int) Double.parseDouble(testString[4]);
                            accountDetail.paidInstallments = Integer.parseInt(testString[5]);
                            accountDetail.totalInstallments = Integer.parseInt(testString[6]);
                            accountDetail.PaidAmount = Integer.parseInt(testString[7]);
                            accountDetail.totalAmount = Integer.parseInt(testString[8]);
                            AccountfinalList.add(accountDetail);
                        }AccountfileReader.close();
                        for (AccountDetail a:AccountfinalList) {
                            a.displayAccount();
                        }
                        break;

                    case 7:
                        do {
                            PurchaseObjects[purchaseCounter].setCompanyName();
                            PurchaseObjects[purchaseCounter].setItemName();
                            PurchaseObjects[purchaseCounter].setPricePerUnit();
                            PurchaseObjects[purchaseCounter].setQuantity();
                            purchaseManager.AddNewPurchasedItem(PurchaseObjects[purchaseCounter]);

                            PurchaseObjects[purchaseCounter].TotalPurchasesAmountOfOneItem();
                            PurchaseObjects[purchaseCounter].sellingAmountOfOneItem();
                            PurchaseObjects[purchaseCounter].CalculateProfitOfOneItem();

                            // creating new file to save purchased items

                            if (PurchasefileObj.createNewFile()) {
                                System.out.println("file created with name ("+PurchasefileObj.getName()+") to save your purchased item permanently");
                            } else {
                                System.out.println("file with name("+PurchasefileObj.getName()+") already created but your new purchased item is saved in it permanently  ");
                            }
                            // writing object

                            FileWriter pen = new FileWriter(PurchasefileObj, true);
                            pen.write(PurchaseObjects[purchaseCounter].getCompanyName()+","+PurchaseObjects[purchaseCounter].getItemName()+","
                                    +PurchaseObjects[purchaseCounter].getPricePerUnit() +","+PurchaseObjects[purchaseCounter].getQuantity()
                            +","+PurchaseObjects[purchaseCounter].getSellingAmount()+","+PurchaseObjects[purchaseCounter].getTotalProfitOfOneItem()+"\n");
                            pen.close();
                            System.out.println("Do you wanna ADD another Purchased Item y/n");
                            redo = input.nextLine();
                            purchaseCounter++;
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;

                    case 8:
                        do {
                            String itemName;
                            System.out.println("you have to Enter Item Name you wanna search");
                            itemName = input.nextLine();
                            purchaseManager.SearchPurchase(itemName);
                            System.out.println("Do you wanna SEARCH another purchased Item y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 9:
                        do {
                            String itemName;
                            System.out.println("you have to Enter Item Name you wanna remove");
                            itemName = input.nextLine();
                            purchaseManager.removePurchasedItem(itemName);
                            System.out.println("Do you wanna REMOVE another Purchased Item y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 10:

                        purchaseManager.showAllPurchases();
                        break;

                    case 11:
                        do {
                            double newPrice;
                            String itemName;
                            System.out.println("you have to Enter Item Name whose Price you wanna Update ");
                            itemName = input.nextLine();
                            System.out.println("Enter new Price Of Item ");
                            newPrice = input.nextDouble();
                            input.nextLine();
                            purchaseManager.updatePurchasePrice(itemName, newPrice);
                            System.out.println("Do you wanna Update another Purchased Item Price y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));

                        break;
                    case 12:
                        Scanner PurchasefileReader = new Scanner(PurchasefileObj);
                        ArrayList<AllPurchases> PurchasefinalList = new ArrayList<>();
                        while (PurchasefileReader.hasNextLine()) {
                            String buffer = PurchasefileReader.nextLine();
                            String[] testString = buffer.split(",");
                            AllPurchases allPurchases = new AllPurchases();
                            allPurchases.CompanyName = testString[0];
                            allPurchases.itemName = testString[1];
                            allPurchases.PricePerUnit = Double.parseDouble(testString[2]);
                            allPurchases.Quantity = Integer.parseInt(testString[3]);
                            allPurchases.sellingAmount = Double.parseDouble(testString[4]);
                            allPurchases.TotalProfitOfOneItem = Double.parseDouble(testString[5]);
                            PurchasefinalList.add(allPurchases);
                        }PurchasefileReader.close();
                        for (AllPurchases a:PurchasefinalList) {
                            a.displayPurchaseDetail();
                        }
                        break;
                    case 13:

                        do {
                            ComplainObjects[ComplainCounter].setComplainerCNIC();
                            ComplainObjects[ComplainCounter].setComplainDescription();
                            ComplainObjects[ComplainCounter].setComplainStatus();
                            complainManagment.AddNewComplain(ComplainObjects[ComplainCounter]);

                            // creating new file to save purchased items

                            if (ComplainfileObj.createNewFile()) {
                                System.out.println("file created with name ("+ComplainfileObj.getName()+") to save your complain permanently");
                            } else {
                                System.out.println("file with name("+ComplainfileObj.getName()+") already created but your new complain is saved in it permanently  ");
                            }

                            // writing in to file

                            FileWriter pen = new FileWriter(ComplainfileObj, true);
                            pen.write(ComplainObjects[ComplainCounter].getComplainerCNIC()+","+
                                    ComplainObjects[ComplainCounter].getComplainDescription() +","+ComplainObjects[ComplainCounter].getComplainStatus()+"\n");
                            pen.close();
                            System.out.println("Do you wanna ADD another Complain y/n");
                            redo = input.nextLine();
                            ComplainCounter++;
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 14:
                        do {
                            String CNIC;
                            System.out.println("you have to Enter Complainer CNIC which you Wanna Search");
                            CNIC = input.nextLine();
                            complainManagment.SearchComplain(CNIC);
                            System.out.println("Do you wanna SEARCH another Complain y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                    case 15:
                        do {
                            String CNIC;
                            System.out.println("you have to Enter complainer CNIC You wanna Remove");
                            CNIC = input.nextLine();
                            complainManagment.removeComplain(CNIC);
                            System.out.println("Do you wanna REMOVE another Complain y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 16:
                        complainManagment.showAllCpmplains();
                        break;
                    case 17:
                        do {
                            String NewDescription;
                            String complainerCNIC;
                            System.out.println("you have to Enter name of complainer ");
                            complainerCNIC = input.nextLine();
                            System.out.println("you have to Enter New Description of complain");
                            NewDescription = input.nextLine();
                            complainManagment.updateComplainDescription(complainerCNIC, NewDescription);
                            System.out.println("Do you wanna Update Description Of another Complain y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 18:
                        do {
                            String NewStatus;
                            String complainerCNIC;
                            System.out.println("you have to Enter name of complainer ");
                            complainerCNIC = input.nextLine();
                            System.out.println("you have to Enter New Status of complain PENDING/SOLVED");
                            NewStatus = input.nextLine();
                            complainManagment.updateComplainStatus(complainerCNIC, NewStatus);
                            System.out.println("Do you wanna UPDATE Status of another Complain y/n");
                            redo = input.nextLine();
                        }
                        while (redo.equalsIgnoreCase("y"));
                        break;
                    case 19:

                        // to  read data from file

                        Scanner ComplainfileReader = new Scanner(ComplainfileObj);
                        ArrayList<Complain> ComplainfinalList = new ArrayList<>();
                        while (ComplainfileReader.hasNextLine()) {
                            String buffer = ComplainfileReader.nextLine();
                            String[] testString = buffer.split(",");
                            Complain complain = new Complain();
                            complain.ComplainerCNIC = testString[0];
                            complain.ComplainDescription = testString[1];
                            complain.ComplainStatus = testString[2];
                            ComplainfinalList.add(complain);
                        }
                        ComplainfileReader.close();
                        for (Complain c:ComplainfinalList) {
                            c.displayComplain();
                        }
                        break;
                    case 20:
                        // creating object of monthly report

                        MonthlyReport monthlyReport = new MonthlyReport();
                        // calling display method to display monthly report

                        monthlyReport.displayMonthlyReport();
                        break;

                    case 21:

                        System.out.println("Thank you Program EXIT");
                        password = 0;
                        break;

                    default:
                        System.out.println("you have entered a wrong input plz enter number between(1-17) from menu");
                        break;

                }


            } while (password == 12345);

        }else {
            System.out.println("you have typed INNCORRECT pasword plz tyy again");
        }

    }
}
