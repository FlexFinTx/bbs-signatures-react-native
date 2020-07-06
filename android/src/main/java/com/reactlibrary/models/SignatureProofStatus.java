public class SignatureProofStatus {
    
}package com.reactlibrary;

public interface signature_proof_status {
    public static final int Success = 200;
    public static final int BadSignature = 400;
    public static final int BadHiddenMessage = 401;
    public static final int BadRevealedMessage = 402;
}