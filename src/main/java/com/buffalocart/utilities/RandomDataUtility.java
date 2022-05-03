package com.buffalocart.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomDataUtility {
    public  String random(){
        Random rg=new Random();
        int randomInt=rg.nextInt(500);
        String email="saturnjupiter"+randomInt+"@gmail.com";
        return email;
    }

    public  String randomRole(){
        Random rg=new Random();
        int randomInt=rg.nextInt(200);
        String role1="Pharmacist"+randomInt+"in";
        System.out.println(role1);
        return role1;
    }

    public  String randomUser(){
        Random rg=new Random();
        int randomInt=rg.nextInt(200);
        String role1="Venus"+randomInt;
        System.out.println(role1);
        return role1;
    }

    public  String randomUserMail(){
        Random rg=new Random();
        int randomInt=rg.nextInt(500);
        String email="venusj"+randomInt+"@gmail.com";
        return email;
    }



    public static void main(String args[]){
        RandomDataUtility data=new RandomDataUtility();
        //data.randomRole();
        System.out.println(data.randomUser());
    }

}
