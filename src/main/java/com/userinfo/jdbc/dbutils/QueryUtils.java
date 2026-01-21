package com.userinfo.jdbc.dbutils;

public class QueryUtils {

    public static final String SAVE_USER= """
            insert into user_test(username,password,email,address,phone,dob,status)
            values(?,?,?,?,?,?,?)
            """;
    public static final String UPDATE_USER= """
            update user_test set username=?,password=?,email=?,address=?,phone=?,dob=?,status=? 
            where id=?
            """;
    public static final String DELETE_USER= """
            delete from user_test where id=?
            """;
    public static final String List_USERS= """
            select * from user_test
            """;
}
