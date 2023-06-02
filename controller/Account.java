// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this class holds the basic attributes of a customer
// like neme ,CNIC number etc and their setter and getter methods

// used classes
// no class of project is used in this class






import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    // field variablrs



  protected String  customerName;
  protected String CNIC;
  protected int accountNO;

  //  setter methods



    // creating scanner object

        Scanner sc = new Scanner(System.in);


    public void setAccountNO (){


        System.out.println("Enter Customer Account Number");
        this.accountNO = sc.nextInt();
        sc.nextLine() ; // this will consume one line after reading one string
    }

        public void setCustomerName () {
        System.out.println("Enter Customer name");
        this.customerName = sc.nextLine();

        //sc.nextLine() ; // this will consume one line after reading one string

    }

        public void setCNIC (){
           // sc.nextLine() ; // this will consume one line after reading one string
            System.out.println("Enter Customer CNIC");
            this.CNIC = sc.nextLine();
    }




        // getter methods

        public String getCustomerName () {
        return customerName;
    }

        public String getCNIC () {
        return CNIC;
    }

        public int getAccountNO () {
        return accountNO;
    }
    }

