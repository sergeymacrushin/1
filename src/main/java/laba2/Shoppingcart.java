package laba2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shoppingcart implements Serializable {
    private int ID;
    private ArrayList<Service> services;

    public Shoppingcart()
    {
        ID = 0;
        services = new ArrayList<>(0);
    }

    public Shoppingcart(int ID, ArrayList<Service> services) {
        this.ID = ID;
        this.services = services;
    }
    public int size()
    {
        return services.size();
    }
    public int getID() {
        return ID;
    }

    public ArrayList<Service> getservices() {
        return services;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMas(ArrayList<Service> services) {
        this.services = services;
    }
    public void addService(Service s)
    {
        this.services.add(s);
    }
    public void deleteService(int index)
    {
        this.services.remove(index);
    }
    public Service getService(int index)
    {
        return services.get(index);
    }
    public static void writeServices(Shoppingcart shoppingcart, String s) throws IOException
    {
        File file = new File(s);
        file.createNewFile();
        FileWriter out = new FileWriter(file);
        out.write(new Integer(shoppingcart.ID).toString());
        out.write("\r\n");
        for(int i = 0; i < shoppingcart.services.size(); i++){
            out.write(shoppingcart.services.get(i).toString());
            if(i != shoppingcart.services.size() - 1)
                out.write("\r\n");
        }
        out.flush();
        out.close();
    }
    public static Shoppingcart readServices(String s)throws IOException{
        FileReader in = new FileReader(s);
        Scanner scan = new Scanner(in);
        ArrayList<Service> oo = new ArrayList<>();
        int idd = 0;
        try{
            idd = scan.nextInt();
            while (scan.hasNextLine()) {
                Service tmp = Service.readService(s,scan);
                oo.add(tmp);
            }
        } catch(Exception e) {
            System.out.println("Некорректные данные");
            System.exit(0);
        }
        return new Shoppingcart (idd,oo);
    }
    public void sort(){
        Collections.sort(this.services);
    }
    public void deleteDublicates()
    {
        for (int i= 0;i<this.size()-1;i++)
        {
            for (int j=1; j<this.size(); j++)
            {
                if(this.services.get(i).equals(this.services.get(j)))
                    this.services.remove(j);
            }
        }
    }
}
