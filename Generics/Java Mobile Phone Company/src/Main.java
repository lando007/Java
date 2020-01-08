import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        MobilePhoneCompany oMobilePhoneCompany1 = new MobilePhoneCompany();
        ArrayList<MobilePhoneCompany> lsMobilePhoneCompany = new ArrayList<>();
       Phone oPhone1 = new Phone();
       oPhone1.sName = "760-545-4567";
       Customer oCustomer1 = new Customer();
       oCustomer1.sLastName = "Luke";
       oCustomer1.sFirstName = "Landon";
       oMobilePhoneCompany1.lsCustomer.add(oCustomer1);
       oMobilePhoneCompany1.sCompanyName = "Verizon";
       oMobilePhoneCompany1.lsPhone.add(oPhone1);

        lsMobilePhoneCompany.add(oMobilePhoneCompany1);


        MobilePhoneCompany oMobilePhoneCompany2 = new MobilePhoneCompany();
        Phone oPhone2 = new Phone();
        oPhone2.sName = "760-576-3432";
        Customer oCustomer2 = new Customer();
        oCustomer2.sLastName = "Matt";
        oCustomer2.sFirstName = "Smith";
        oMobilePhoneCompany2.sCompanyName = "AT&T";
        oMobilePhoneCompany2.lsPhone.add(oPhone2);
        oMobilePhoneCompany2.lsCustomer.add(oCustomer2);
        lsMobilePhoneCompany.add(oMobilePhoneCompany2);


        MobilePhoneCompany oMobilePhoneCompany3 = new MobilePhoneCompany();
        Phone oPhone3 = new Phone();
        oPhone3.sName = "619-576-3432";
        Customer oCustomer3 = new Customer();
        oCustomer3.sLastName = "John";
        oCustomer3.sFirstName = "Kinnaman";
        oMobilePhoneCompany3.sCompanyName = "Cricket";
        oMobilePhoneCompany3.lsCustomer.add(oCustomer3);
        oMobilePhoneCompany3.lsPhone.add(oPhone3);
        lsMobilePhoneCompany.add(oMobilePhoneCompany3);

        for(MobilePhoneCompany oCompany: lsMobilePhoneCompany ){
            System.out.println("Phone companys Name is: "+oCompany.sCompanyName);
            for(Customer oCustomer: lsMobilePhoneCompany.get(0).lsCustomer){
                System.out.print("Customers Name is "+oCompany.lsCustomer.get(0).sFirstName+ " " );
                System.out.println(oCompany.lsCustomer.get(0).sLastName);
                for (Phone oPhone: lsMobilePhoneCompany.get(0).lsPhone){
                    System.out.println("Customers Number is:  "+oCompany.lsPhone.get(0).sName);

                }

            }

        }



    }

}
