package com.buffalocart.utilities;

import java.util.Random;

public class RandomDataUtility {
    public  String random(){
        Random rg=new Random();
        int randomInt=rg.nextInt(500);
        String email="saturnjupiter"+randomInt+"@gmail.com";
        return email;
    }
}
