package com.company;

import java.io.Serializable;

public class Countrys implements Serializable {
    private int Id;
    private String NameCountry;
    private float Area;
    private String NameCity;
    private int Population;
    private int Salary;
    private int IdCountry;

    public void setId(int Id){
        this.Id = Id;
    }
    public void setNameCountry(String NameCountry){
        this.NameCountry = NameCountry;
    }
    public void setArea(float Area){
        this.Area = Area;
    }
    public void setNameCity(String NameCity){
        this.NameCity = NameCity;
    }
    public void setPopulation(int Population){
        this.Population = Population;
    }
    public void setSalary(int Salary){
        this.Salary = Salary;
    }
    public void setIdCountry(int IdCountry){
        this.IdCountry = IdCountry;
    }
    public int getId(){
        return Id;
    }
    public String getNameCountry(){
        return NameCountry;
    }
    public float getArea(){
        return Area;
    }
    public String getNameCity(){
        return NameCity;
    }
    public int getPopulation (){
        return Population;
    }
    public int getSalary(){
        return Salary;
    }
    public int getIdCountry(){
        return IdCountry;
    }
    public Countrys(int Id, String NameCountry,float Area, String NameCity, int Population, int Salary, int IdCountry)
    {
        this.Id = Id;
        this.NameCountry=NameCountry;
        this.Area=Area;
        this.NameCity=NameCity;
        this.Population=Population;
        this.Salary=Salary;
        this.IdCountry=IdCountry;
    }

}
