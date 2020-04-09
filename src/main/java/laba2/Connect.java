package laba2;

import com.mysql.fabric.jdbc.FabricMySQLDriver;


import java.sql.*;
import java.util.ArrayList;

public class Connect {
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String URL="jdbc:mysql://localhost:3306/web_labs";

    private Connection connection;

    public Connect() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.deregisterDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("driver not found");
        }
    }
    public  void addCustomer(Customer customer) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into customers (id, name, login, password) VALUE (?,?,?,?)");
        preparedStatement.setInt(1,customer.getId());
        preparedStatement.setString(2,customer.getName());
        preparedStatement.setString(3,customer.getLogin());
        preparedStatement.setString(4,customer.getPassword());
        preparedStatement.execute();
        if(customer.sizeShoppingcart()>0)
        {
            ArrayList<Shoppingcart> shoppingcarts = customer.getShoppingcarts();
            for(int i = 0; i<shoppingcarts.size(); i++)
            {
                Connect connect = new Connect();
                connect.addShoppingcart(shoppingcarts.get(i),customer.getId());
            }
        }
    }
    public Customer getCustomer(int id_customer) throws Exception
    {
        String name =null;
        String login= null;
        String password= null;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customers where id="+id_customer);
        while(resultSet.next()) {
             name = resultSet.getString("name");
             login = resultSet.getString("login");
             password = resultSet.getString("password");
        }
        Connect connect = new Connect();
        ArrayList<Shoppingcart>shoppingcarts = connect.allShoppingcarts(id_customer);
        return new Customer(id_customer, name,login,password,shoppingcarts);
    }
    public void deleteShoppingcart(int id_shoppingcart) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from shopping_carts where id="+id_shoppingcart);
        preparedStatement.execute();
    }
    public void deleteService(int id_shoppingcart,String type) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from shopping_carts_services where id_shopping_cart="+id_shoppingcart +" and service_name = "+type);
        preparedStatement.execute();
    }
    public boolean isExist(String login, String password) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where login = ? and password = ?");
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        return false;
    }
    public ArrayList<Shoppingcart> allShoppingcarts(int id_customer) throws Exception
    {
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("select * from shopping_carts where id_customer="+id_customer);
        ArrayList<Shoppingcart>shoppingcarts=new ArrayList<>();
        while(resultSet1.next())
        {
            Connect connect = new Connect();
            int id = resultSet1.getInt("id");
            ArrayList<Service> services = connect.allServices(id);
            Shoppingcart shoppingcart = new Shoppingcart(id,services);
            shoppingcarts.add(shoppingcart);
        }
        return shoppingcarts;
    }
    public ArrayList<Service> allServices(int id_shoppingcart) throws Exception
    {
        ArrayList<Service> services = new ArrayList<>();
        Statement statement2 = connection.createStatement();
        ResultSet resultSet2 = statement2.executeQuery("select  shopping_carts_services.service_name, shopping_carts_services.count, services.price from shopping_carts_services left join services on shopping_carts_services.service_name = services.service_name where id_shopping_cart ="+id_shoppingcart);
        while(resultSet2.next())
        {
            String type = resultSet2.getString("service_name");
            int count = resultSet2.getInt("count");
            int price = resultSet2.getInt("price");
            Service service = new Service(type, price, count);
            services.add(service);
        }
        return services;
    }
    public void addShoppingcart(Shoppingcart shoppingcart, int id_customer) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into shopping_carts (id, id_customer) VALUE (?,?)");
        preparedStatement.setInt(1,shoppingcart.getID());
        preparedStatement.setInt(2,id_customer);
        preparedStatement.execute();
        ArrayList<Service> services = shoppingcart.getservices();
        for(int j=0; j<services.size(); j++)
        {
            Connect connect = new Connect();
            connect.addService(services.get(j),shoppingcart.getID());
        }
    }
    public void addService(Service service, int id_shoppingcart) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into shopping_carts_services (id_shopping_cart, service_name, count) VALUE (?,?,?)");
        preparedStatement.setInt(1,id_shoppingcart);
        preparedStatement.setString(2,service.getType());
        preparedStatement.setInt(3, service.getCount());
        preparedStatement.execute();
    }
    public void deleteCustomer(int id_customer) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from customers where id =?");
        preparedStatement.setInt(1,id_customer);
        preparedStatement.execute();
    }
    public void updatePassword(int id_customer, String password) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement("update customers set password = ? where id = ?");
        preparedStatement.setString(1,password);
        preparedStatement.setInt(2,id_customer);
        preparedStatement.execute();
    }

}
