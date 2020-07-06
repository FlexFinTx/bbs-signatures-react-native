package com.reactlibrary;

public class BbsKeyPair {
    public byte[] PublicKey;
    public int MessageCount;

    public BbsKeyPair(byte[] publicKey, int messageCount) {
        PublicKey = publicKey;
        MessageCount = messageCount;    
    }    
}