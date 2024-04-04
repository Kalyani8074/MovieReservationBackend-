package com.movie.services;

import com.movie.entites.*;

public class CustomerProfileSessionService {

    static private Users customerData;

    public static void setCustomerData(Users customerDataRequest){
          customerData = customerDataRequest;
    }

    public static Users getCustomerData(){
             return customerData;
    }

    public static void removeCustomerData(){
        customerData = null;
    }


}
