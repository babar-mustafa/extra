package com.example.babarmustafa.saylani_marathon.Model_Classes;

/**
 * Created by BabarMustafa on 2/14/2017.
 */

//public class User {
//}

public class User {
    private String UID;
    private String Name;
    private String Email;
    private String Country;
    private String City;
    private String Password;
    private String GEnder;


    public User() {
    }

    public User (String name) {
        Name = name;
    }

    public User (String UID, String name, String email, String country, String city, String password, String GEnder) {
        this.UID = UID;
        Name = name;
        Email = email;
        Country = country;
        City = city;
        Password = password;
        this.GEnder = GEnder;
    }

    public User(String UID, String name, String email, String password, String GEnder) {
        this.UID = UID;
        Name = name;
        Email = email;
        Password = password;
        this.GEnder = GEnder;
    }

    public String getUID() {
        return UID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGEnder() {
        return GEnder;
    }

    public void setGEnder(String GEnder) {
        this.GEnder = GEnder;
    }
}
