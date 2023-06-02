// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this is a manager class for AllPurchases class  it includes methods as
// add new Item  , remove an item ,search an item  ,display all purchased items
// it also have methods to update price of a purchased item

// used classes
// this class is a child class of AllPurchases class to manage it properly by using its methods






import java.util.ArrayList;
import java.util.Iterator;

public class  PurchaseManager extends AllPurchases {

    // creating array

    ArrayList<AllPurchases>  PurchaseRecord = new ArrayList<>();

    public void AddNewPurchasedItem(AllPurchases purchasedItem)
    {
        if (PurchaseRecord.contains(purchasedItem)){
            System.out.println("Purchase item you are trying to add already exist");
        }else {
            PurchaseRecord.add(purchasedItem);
            System.out.println("Purchased item is added successfully");
        }
    }

    public void removePurchasedItem(String ItemName)
    {

        for (AllPurchases p:PurchaseRecord) {
            if (p.getItemName().equalsIgnoreCase(ItemName)){
             if ( PurchaseRecord.remove(p))  {
            System.out.println("-- Purchased item is removed successfully --");
        }else {
            System.out.println("-- Purchased item dose not exist --");
        }}
    }
    }

    public void SearchPurchase(String name) {
        for (AllPurchases p : PurchaseRecord) {

            if (p.getItemName().equalsIgnoreCase(name)) {
                System.out.println("-- your Searched purchased item exist --");
                System.out.println("-- Detail of your searched purchased item is here --");
                p.displayPurchaseDetail();// this will display purchased item detail
            } else {
                System.out.println("-- your searched purchased item dose not exist --");
            }
        }
    }

    // using iterator to print all elements in a Arrylist

    public void showAllPurchases(){
        Iterator<AllPurchases> it =PurchaseRecord .iterator();
        while (it.hasNext()){
            it.next().displayPurchaseDetail();
            System.out.println("------------------");

        }
    }


    //   method will update th purchase price


    public void updatePurchasePrice(String ItemName, double NewpricePerUnit ) {
        for (AllPurchases p : PurchaseRecord) {
            if (p.getItemName().equalsIgnoreCase(ItemName)) {
                System.out.println("-- your Searched purchased item exist --");
                System.out.println("-- Detail of your searched purchased item after update is here --");
                p.updatePurchasePrice(NewpricePerUnit);
                p.displayPurchaseDetail();
            } else {
                System.out.println("-- your searched purchased item dose not exist --");
            }
        }
    }




}

