package com.example.Authentication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class Auth
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String username;
    private String password;

    public Integer getId() {					//getters and setters
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}