package com.movie.services;

import com.movie.entites.*;

public class AdminProfileSessionService {

    static private Users adminData;

    public static void setAdminData(Users adminDataRequest){
        adminData = adminDataRequest;
    }

    public static Users getAdminData(){
             return adminData;
    }

    public static void removeAdminData(){
        adminData = null;
    }


}
