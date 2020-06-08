package com.example.canbe.re_contact;

import java.util.ArrayList;

/**
 * Created by canbe on 6.05.2017.
 */

public class Contact {

    String name,email,password,uname,hobbies,facebook,twitter,age,job,workplace, isuser = "true";
    int phoneNum;
    ArrayList<Contact> contacts;
    ArrayList<String> info;
    DatabaseHelper helper;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addContact( String username) { contacts.add(helper.getContact(username));}
    public ArrayList<Contact> getContacts() { return this.contacts;}
    public void setPhoneNum(int phoneNum){this.phoneNum = phoneNum;}
    public int getPhoneNum(){return this.phoneNum;}
    public void setUname(String uname){
        this.uname = uname;
    }
    public String getUname(){
        return this.uname;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setHobbies(String hobbies){
        this.hobbies = hobbies;
    }
    public String getHobbies(){
        return this.hobbies;
    }
    public void setFacebook(String facebook){
        this.facebook = facebook;
    }
    public String getFacebook(){
        return this.facebook;
    }
    public void setTwitter(String twitter){
        this.twitter = twitter;
    }
    public String getTwitter(){
        return this.twitter;
    }
    public void setAge(String age) { this.age = age;}
    public String getAge() { return this.age;}
    public void setJob(String job) { this.job = job;}
    public String getJob() { return this.job;}
    public void setWorkplace(String workplace) { this.workplace = workplace;}
    public String getWorkplace() { return this.workplace;}
    public void setIsUser(String isUser){ this.isuser = isuser;}
    public String getIsUser(){return this.isuser;}

    public ArrayList<String> getInfo(){
        info = new ArrayList<>();
        info.add(name);
        info.add(age);
        info.add("" + phoneNum);
        info.add(job);
        info.add(email);
        info.add(workplace);
        info.add(hobbies);
        info.add(facebook);
        info.add(twitter);
        info.add(isuser);
        return info;
    }

    public void setInfo(ArrayList<String> info){
        setName(info.get(0));
        setAge(info.get(1));
        setPhoneNum(Integer.parseInt(info.get(2)));
        setJob(info.get(3));
        setEmail(info.get(4));
        setWorkplace(info.get(5));
        setHobbies(info.get(6));
        setFacebook(info.get(7));
        setTwitter(info.get(8));
        setIsUser("false");
    }
}
