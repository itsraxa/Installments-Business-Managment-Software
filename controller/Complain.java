// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this class holds some attributes of a complain
// like name of complainer  ,CNIC of complainer  , complain description
// and status and their setter and getter methods
// along with a method which will display detail of a complain

// used classes
// not class of project is used in this class



import java.util.Scanner;

public class Complain {
    // field variables



    public String ComplainDescription;
    public   String ComplainStatus;
    public String ComplainerCNIC;


    // setter methods

    // creating scanner object for data input

    Scanner sc = new Scanner(System.in);

    public void setComplainDescription() {
        System.out.println("Enter Description of ypur Complain ");
        ComplainDescription = sc.nextLine();
    }

    public void setComplainerCNIC() {
        System.out.println("Enter CNIC number of Complainer");
        ComplainerCNIC = sc.nextLine();
    }

    public void setComplainStatus() {
        System.out.println("Enter Complain Status as PENDING/SOLVED");
        ComplainStatus = sc.nextLine();
    }



    public void updateStatus(String complainStatus){

        if (complainStatus.equalsIgnoreCase("SOLVED")){
            ComplainStatus=complainStatus;
            System.out.println("Complain status is updated to SOLVED");
        }else if (complainStatus.equalsIgnoreCase("PENDING")){
            ComplainStatus=complainStatus;
            System.out.println("Complain status is updated to PENDING");
        }else {
            System.out.println("wrong status Complain status can only be SOLVED or PENDING");
        }
    }
    public void updateDescription(String complainDescription){

            ComplainDescription=complainDescription;
    }


    // getter methods


    public String getComplainDescription() {
        return ComplainDescription;
    }

    public String getComplainStatus() {
        return ComplainStatus;
    }

    public String getComplainerCNIC() {
        return ComplainerCNIC;
    }


    // display method whic will display complain detail


    public void displayComplain(){
        System.out.println("Complain Id (CNIC)  "+getComplainerCNIC());
        System.out.println("complain status     "+getComplainStatus());
        System.out.println("---------complain description -------");
        System.out.println(getComplainDescription());
        System.out.println("******************************");
        System.out.println("------------------------------------");

    }
}
