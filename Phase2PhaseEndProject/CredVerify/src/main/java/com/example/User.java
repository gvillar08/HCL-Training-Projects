package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user")   

public class User {				//This class is for fetching data from the database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private long id;
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    public User() {        
    }

    public User(long id, String name, String password) {
        this.id = id;
        this.username = name;
        this.password = password;
    }
    public long getID()							{return this.id; }
    public String getName()						{return this.username;}
    public String getPassword()					{return this.password;}
    
    public void setID(long id)					{this.id = id;}
    public void setName(String name)			{this.username = name;}
    public void setPassword(String password)	{this.password = password;}
}