package com.example.hilde.smartcardreader;

/**
 * Created by hilde on 02.02.2018.
 */

public class bluetoothDevice {

    private String btMacAddress,dh_pub_p,dh_pub_g,dh_pub_B,scDebug;
    private String AES_KEY, AES_IV;


    public bluetoothDevice(String btMacAddress, String dh_pub_p, String dh_pub_g, String dh_pub_B, String scDebug){
        this.btMacAddress = btMacAddress;
        this.dh_pub_p = dh_pub_p;
        this.dh_pub_g = dh_pub_g;
        this.dh_pub_B = dh_pub_B;
        this.scDebug = scDebug;
    }

    public String getMACAddress(){
        return btMacAddress;
    }

    public String getdh_pub_p(){
        return dh_pub_p;
    }

    public String getdh_pub_g() {
        return  dh_pub_g;
    }

    public String getdh_pub_B() {
        return  dh_pub_B;
    }

    public String getScDebug() {
        return scDebug;
    }

    public void set_AES_KEY(String key){
        AES_KEY = key;
    }

    public void set_AES_IV(String iv){
        AES_IV = iv;
    }

    public String get_AES_KEY(){
        return AES_KEY;
    }

    public String get_AES_IV(){
        return AES_IV;
    }
}
