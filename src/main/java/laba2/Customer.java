package laba2;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String login;
    private String password;
    private ArrayList<Shoppingcart> shoppingcarts;

    public Customer(int id, String name, String login, String password, ArrayList<Shoppingcart> shoppingcarts) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.shoppingcarts = shoppingcarts;
    }
    public Customer()
    {}

    public void setShoppingcarts(ArrayList<Shoppingcart> shoppingcarts) {
        this.shoppingcarts = shoppingcarts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addShoppingcart(Shoppingcart shoppingcart)
    {
        shoppingcarts.add(shoppingcart);
    }

    public ArrayList<Shoppingcart> getShoppingcarts() {
        return shoppingcarts;
    }

    public Service getService(int index_shoppingcarts, int index_service)
    {
        return shoppingcarts.get(index_shoppingcarts).getService(index_service);
    }

    public void deleteShoppingcart(int index){shoppingcarts.remove(index);}

    public int sizeShoppingcart()
    {
        return shoppingcarts.size();
    }
}
