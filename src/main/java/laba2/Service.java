package laba2;

import java.io.*;
import java.util.Scanner;

public class Service implements Serializable, Comparable<Service> {
    private String type;
    private int price;
    private int count;
    public Service (String type, int price, int count) throws Exception
    {
        this.type = type;
        if(price>0){
            this.price = price;
        }
        else{
            throw new Exception ("Некорректная цена за ед.");
        }
        if(count>0){
            this.count = count;
        }
        else{
            throw new Exception ("Некорректное количество");

        }

    }
    public Service ()
    {
        this.type ="";
        this.price = 0;
        this.count = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if(price>0){
            this.price = price;
        }
        else{
            throw new Exception("Некорректная цена за ед.");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) throws Exception {
        if(count>0){
            this.count = count;
        }
        else{
            throw new Exception("Некорректное количество");
        }
    }
    public int getCost()
    {
        return this.count * this.price;
    }
    public static void writeService(Service service) throws IOException
    {
        File file = new File("service.txt");
        file.createNewFile();
        FileWriter out = new FileWriter("service.txt");
        out.write(service.toString());
        out.flush();
        out.close();

    }
    public static Service readService(String s,Scanner scan)throws Exception
    {
        FileReader in = new FileReader(s);
        String type = scan.next();
        int price = scan.nextInt();
        int count = scan.nextInt();
        in.close();
        return new Service(type,price,count);
    }
    public int compareTo(Service ro){
        return this.type.compareTo(ro.type);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(type).append(' ').append(price).append(' ')
                .append(count).toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Service ro = (Service) obj;
        return type.equals(ro.getType()) && price == ro.getPrice() && count == ro.getCount();
    }
}
