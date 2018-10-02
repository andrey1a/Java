package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        conn.Conn();
        conn.CreateDB();
        Countrys object = new Countrys(1, "Russia",  45.3f, "Moscow", 12000000, 45000, 1);

        Serilizator serilizator = new Serilizator();
        System.out.println(serilizator.serilization(object));
        Countrys objectDesir = serilizator.desirization();
        System.out.println(objectDesir.getNameCountry());

        //System.out.println(object.getArea());

       // conn.WriteDB(object);
        conn.ReadDB();
        conn.CloseDB();
    }
}