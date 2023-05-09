package Users;
import Admins.Admin;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class DataForUsers {

    public static void dataForAdmin() {

        try {
            JAXBContext context = JAXBContext.newInstance(ListUsers.class);
            Unmarshaller ums = context.createUnmarshaller();
            ListUsers users = (ListUsers) ums.unmarshal(new File("C:\\Users\\USER\\IdeaProjects\\Library\\src\\MyVersion\\admin.xml"));

            for(Admin a: users.getAdminList()){
                Admin.getAdmin().add(a.getUsername());
                Admin.getAdmin().add(a.getPassword());
                Admin.getAdmin().add(a.getAccess());
            }
        } catch (JAXBException e) {
            System.out.println(e);
        }


    }

    public static void dataForClient(){
        try {
            JAXBContext context = JAXBContext.newInstance(ListUsers.class);
            Unmarshaller ums = context.createUnmarshaller();
            ListUsers users = (ListUsers) ums.unmarshal(new File("C:\\Users\\USER\\IdeaProjects\\Library\\src\\MyVersion\\customer.xml"));

            for(Customer c: users.getCustomerList()){
                Customer.getCustomer().add(c.getUsername());
                Customer.getCustomer().add(c.getPassword());
                Customer.getCustomer().add(c.getAccess());
            }
        } catch (JAXBException e) {
            System.out.println(e);
        }
    }

}

