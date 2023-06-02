// installment Business Software: solution
// Muhammad Ali Raza
// 030-BSCS-2019(section-C)

//Description:
// this is an interface which contains two methods to calculate total collection and profit
// which will be used in monthly report class to calculate them

// used classes
// because it is an interface therefore no  class of project is used in it


public interface CalculationsForAccountClass {

    void CalculateTotalCollections(AccountDetail accountDetail);
    void  CalculateProfitFromCollections(AccountDetail accountDetail);
}
