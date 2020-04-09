package laba2;


import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        try {
/*
        Customer customer = new Customer();
        customer.setId(8);
        customer.setName("Suchanov");
        customer.setLogin("sukhan");
        customer.setPassword("password8");
        Service service = new Service("manicure", 300, 3);
        Service service1 = new Service("pedicure", 1500, 2);
        Service service2 = new Service("polish", 350, 2);
        ArrayList<Service> services = new ArrayList<>();
        services.add(service);
        services.add(service1);
        services.add(service2);
        Shoppingcart shoppingcart = new Shoppingcart(17,services);
        ArrayList<Shoppingcart> shoppingcarts= new ArrayList<>();
        shoppingcarts.add(shoppingcart);
        customer.setShoppingcarts(shoppingcarts);
        }

        Connect connect = new Connect();
        connect.addCustomer(customer);

        if(connect.isExist("macrushi","12345678"))
        {
            System.out.println("Exist!");
        }*/
        Connect connect = new Connect();
        connect.deleteCustomer(8);
        }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());;
        }
        catch (Exception er)
        {
            System.err.println("hzzzzz");
        }
    }
}
