package com.gaurav.mydiary;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
    String name;
    String phoneNumber;
    String emailId;
    public Person(String x,String y,String z)
    {
        name = x;
        phoneNumber = y;
        emailId = z;
    }
    public void setName(String name){
        this. name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmailId(String emailId){
        this. emailId= emailId;
    }


    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmailId(){
        return emailId;
    }
}