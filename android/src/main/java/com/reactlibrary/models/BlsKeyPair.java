package com.reactlibrary;

public class BlsKeyPair {
    public byte[] SecretKey;
    public byte[] PublicKey;

    public int PublicKeySize = BbsLibrary.INSTANCE.bls_public_key_size();
    public int SecretKeySize = BbsLibrary.INSTANCE.bls_secret_key_size();

    private BlsKeyPair(byte[] secretKey, byte[] deterministicPublicKey) {
        SecretKey = secretKey;
        PublicKey = deterministicPublicKey;
    }

    public BlsKeyPair(byte[] keyData) throws Exception {
        if (keyData.length == SecretKeySize) {
            SecretKey = keyData;

            // TODO: get public key
            // TODO: set public key
        } else if (keyData.length == PublicKeySize) {
            PublicKey = keyData;
        } else {
            // TODO: BbsException
            throw new Exception("Invalid key size");
        }
    }

    public BbsKeyPair GenBbsKeyPair(int messageCount) {
        if (SecretKey == null) {
            // TODO: public key to bbs key
        } else {
            // TODO: secret key to bbs key
        }
    }
}