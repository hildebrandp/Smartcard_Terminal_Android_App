package com.example.hilde.smartcardreader;

/**
 * Created by hilde on 02.02.2018.
 */

public class bluetoothDevice {

    private String btMacAddress,btPIN,btAESKey,btSeed,scDebug;

    public bluetoothDevice(String btMacAddress, String btPIN, String btAESKey, String btSeed, String scDebug){
        this.btMacAddress = btMacAddress;
        this.btPIN = btPIN;
        this.btAESKey = btAESKey;
        this.btSeed = btSeed;
        this.scDebug = scDebug;
    }

    public String getMACAddress(){
        return btMacAddress;
    }

    public String getBtPIN(){
        return btPIN;
    }

    public String getBtAESKey(){
        return btAESKey;
    }

    public String getBtSeed() {
        return  btSeed;
    }

    public String getScDebug() {
        return scDebug;
    }
}
