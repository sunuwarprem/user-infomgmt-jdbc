package com.userinfo.jdbc;

import com.userinfo.jdbc.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestUserApps {
    Scanner sc=new Scanner(System.in);

    public User getUserInfo(){
        User user=new User();
        System.out.println("User form");
        System.out.println("Enter username :");
        String username=sc.next();
        System.out.println("Enter password :");
        String pass=sc.next();
        System.out.println("Enter email :");
        String email=sc.next();
        System.out.println("Enter address :");
        String address=sc.next();
        System.out.println("Enter phone :");
        long phone=sc.nextLong();
        System.out.println("Enter dob :");
        String date=sc.next();
        System.out.println("Enter status :");
        boolean status=sc.nextBoolean();
        //setting user from user input
        user.setUsername(username);
        user.setPassword(pass);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setStatus(status);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob=sdf.parse(date);
            user.setDob(dob);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
    public void getDisplay(User user){
        System.out.println("===========================");
        System.out.println("id is "+user.getId());
        System.out.println("User Name :"+user.getUsername());
        System.out.println("user Pass :"+user.getPassword());
        System.out.println("email :"+user.getEmail());
        System.out.println("address :"+user.getAddress());
        System.out.println("phone :"+user.getPhone());
        System.out.println("dob  :"+user.getDob());
        System.out.println("status :"+user.isStatus());
        System.out.println("===============================");

    }
}
