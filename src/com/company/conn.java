package com.company;

import java.io.*;
import java.sql.*;


public class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:test5.s3db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'Countrys' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'NameCountry' text, 'Area' FLOAT(3,1))");
        statmt.execute("CREATE TABLE if not exists 'Citys' ('idCity' INTEGER PRIMARY KEY AUTOINCREMENT, 'NameCity' text, 'Population' INTEGER, 'Salary' INTEGER,'IdCountry' INTEGER)");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB(Countrys object) throws SQLException
    {
        String queryCoutrys = "INSERT INTO 'Countrys' ('NameCountry', 'Area')" + " VALUES (?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(queryCoutrys);
        preparedStmt.setString(1,object.getNameCountry());
        preparedStmt.setFloat(2,object.getArea());
        preparedStmt.execute();
        String queryCitys = "INSERT INTO 'Citys' ('NameCity', 'Population', 'Salary', 'IdCountry' )" + " VALUES (?, ?, ?, ?)";
        preparedStmt = conn.prepareStatement(queryCitys);
        preparedStmt.setString(1,object.getNameCity());
        preparedStmt.setInt(2,object.getPopulation());
        preparedStmt.setInt(3,object.getSalary());
        preparedStmt.setInt(4,object.getIdCountry());
        preparedStmt.execute();

        //statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        //statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
       // statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
        //statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES (object.getName, object.getArea); ");

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException, IOException {
        //resSet = statmt.executeQuery("SELECT * FROM ");
        Serilizator serilizator = new Serilizator(); //объекты для серилиазицацуацуацуа
        Countrys objectDesir = serilizator.desirization();
        resSet = statmt.executeQuery("SELECT a.id, a.NameCountry, a.Area, b.IdCity, b.NameCity, b.Population, b.Salary FROM Countrys AS a LEFT JOIN Citys AS b ON a.id = b.IdCountry ");

        while(resSet.next())
        {
            Countrys reset = new Countrys(resSet.getInt("id"), resSet.getString("NameCountry"), resSet.getFloat("Area"), resSet.getString("NameCity"), resSet.getInt("Population"),resSet.getInt("Salary"),resSet.getInt("IdCity"));
            System.out.println( "Страны\n");
            System.out.println( "ID: " + reset.getId() );
            System.out.println( "Название: " + reset.getNameCountry() );
            System.out.println( "Площадь: " + reset.getArea() );
            System.out.println();
            System.out.println( "\n Города");
            System.out.println( "ID: " + reset.getId() );
            System.out.println( "Название: " + reset.getNameCity() );
            System.out.println( "Население: " + reset.getPopulation() );
            System.out.println( "Средняя зарплата: " + reset.getSalary() );
            System.out.println( "ID страны: " + reset.getIdCountry() );
            System.out.println(serilizator.serilization(reset));
            objectDesir = serilizator.desirization();
            System.out.println(objectDesir.getNameCountry());
        }

        System.out.println("Таблица выведена");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        //statmt.close();
        //resSet.close();

        System.out.println("Соединения закрыты");
    }

}