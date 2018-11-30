package com.example.hilde.smartcardreader;

import java.math.BigInteger;
import java.security.SecureRandom;

public class diffieHellman {

    private BigInteger public_p;
    private BigInteger public_g;

    private BigInteger private_a;
    private BigInteger public_A;
    private BigInteger public_B;

    private BigInteger private_Shared;

    public diffieHellman(String publicp, String publicg, String publicB){
        this.public_p = new BigInteger(publicp);
        this.public_g = new BigInteger(publicg);
        this.public_B = new BigInteger(publicB);

        SecureRandom rand = new SecureRandom();
        byte randomByte[] = new byte[8];

        do{
            rand.nextBytes(randomByte);
            private_a = new BigInteger(randomByte);
            private_a = private_a.abs();
        } while (private_a.compareTo(public_p) >= 0);

        public_A = public_g.modPow(private_a, public_p);

        private_Shared = public_B.modPow(private_a, public_p);
    }

    public String Get_public_A(){
        return public_A.toString();
    }

    public String Get_shared_secret(){
        return private_Shared.toString();
    }

}
