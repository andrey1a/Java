package com.company;

import java.io.*;

public class Serilizator {
    public boolean  serilization(Countrys country)
    {
        boolean flag = false;
        File file = new File("serilization.data");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(country);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }
    public Countrys desirization()
    {
        File file = new File("serilization.data");
        ObjectInputStream ois = null;
        Countrys country = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                country = (Countrys) ois.readObject();
                return country;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } throw new IndexOutOfBoundsException("Error 404");

    }
}
