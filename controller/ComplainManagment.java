// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this is a manager class for  Complain class  it includes methods as
// add new Complain , remove a complain,search an complain ,display all complains
// it also have methods to update status and description of a  complain

// used classes
// this class is a child class of Complain class to manage it properly by using its methods




import java.util.ArrayList;
import java.util.Iterator;

public class ComplainManagment extends Complain {

    // creating arrylist with name Complain

    ArrayList<Complain> Complain= new ArrayList<>();

    public void AddNewComplain(Complain complain)
    {
        if ( Complain.contains(complain)){
            System.out.println("-- complain you are trying to add already exist --");
        }else {
            Complain.add(complain);
            System.out.println("your complain is added successfully");
        }


    }
    public void removeComplain(String CNIC){

        for (Complain c:Complain) {

        if ( c.getComplainerCNIC().equalsIgnoreCase(CNIC)){
            if (Complain.remove(c))
            System.out.println("-- complain is removed successfully --");
        }else {
            System.out.println("-- complain dose not exist --");
        }
    }
    }
    public void SearchComplain(String CNIC){
        for (Complain c:Complain) {
        if (c.getComplainerCNIC().equalsIgnoreCase(CNIC)){
            System.out.println("-- your Searched complain exists --");
            System.out.println("-- Detail of your searched complain is here --");
            c.displayComplain();// this will display complain
        }else {
            System.out.println("-- your searched account dose not exist --");
        }
    }
    }

    // using iterator to print all elements in a Arrylist

    public void showAllCpmplains(){
        Iterator<Complain> it =Complain .iterator();
        while (it.hasNext()){
            it.next().displayComplain();
            System.out.println("--------------------------");

        }
    }

    // this method will update complain status only


   public void updateComplainStatus(String complainerCNIC,String complainStatus ) {
       for (Complain c : Complain) {
           if (c.getComplainerCNIC().equalsIgnoreCase(complainerCNIC)) {
               System.out.println("-- your Searched Complain exist --");
               System.out.println("-- Detail of your searched Complain after update is here --");
               c.updateStatus(complainStatus);
               c.displayComplain();
           } else {
               System.out.println("-- your searched Complain dose not exist --");
           }
       }
   }


    // ths method will update complain description only


    public void updateComplainDescription(String complainerCNIC,String complainDescription ) {
        for (Complain c : Complain) {
            if (c.getComplainerCNIC().equalsIgnoreCase(complainerCNIC)) {
                System.out.println("-- your Searched Complain exists --");
                System.out.println("-- Detail of your searched Complain after update is here --");
                c.updateDescription(complainDescription);
                c.displayComplain();
            } else {
                System.out.println("-- your searched Complain dose not exist --");
            }
        }
    }
}

