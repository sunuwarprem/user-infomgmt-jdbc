package com.userinfo.jdbc.controller;


import com.userinfo.jdbc.TestUserApps;
import com.userinfo.jdbc.model.User;
import com.userinfo.jdbc.service.UserService;
import com.userinfo.jdbc.service.userServiceImp;

import java.util.List;
import java.util.Scanner;

public class UserController {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TestUserApps apps=new TestUserApps();
        UserService userService=new userServiceImp();
        int decision=0;
        do {
            System.out.println("enter Save | Update |Delete :");
            String choice=sc.next();
            switch (choice.toLowerCase()) {
                case "save":
                    User user= apps.getUserInfo();
                  int save=0;
                   save= userService.saveUser(user);
                   if(save>0){
                       System.out.println("Save in DB");
                       return;
                   }System.out.println("Saving Error!!!");
                   break;
                case "update":
                    User updateuser= apps.getUserInfo();
                    int updated=0;
                    updated=userService.updateUser(updateuser);
                    if(updated>0){
                        System.out.println("updated in DB");
                        return;
                    }System.out.println("Error in Update!!!");
                    break;
                case "delete":
                    System.out.println("enter id to delete from user");
                   int uid= sc.nextInt();
                   int deleted=userService.deleteUser(uid);
                   if(deleted>0){
                       System.out.println("Deleted from table");
                       return;
                   }System.out.println("Error on delete from table"); //added
                   break;
                case "list":
                    List<User> users=userService.listUser();
                    for(User u:users){
                    apps.getDisplay(u);
                    }break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }System.out.println("To continue press 1 :");
            decision=sc.nextInt();
        }while(decision!=0);
       }
    }

