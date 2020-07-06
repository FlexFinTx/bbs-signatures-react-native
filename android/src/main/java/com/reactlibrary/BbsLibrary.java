package com.reactlibrary;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import java.util.List;

public interface BbsLibrary extends Library {
    BbsLibrary INSTANCE = (BbsLibrary) Native.loadLibrary("bbs", BbsLibrary.class);

    // Resources
    void bbs_string_free(String string);
    void bbs_byte_buffer_free(ByteBuffer data);

    // BLS
    int bls_secret_key_size();
    int bls_public_key_size();
    int bls_generate_key(ByteBuffer.ByValue seed, ByteBuffer public_key, ByteBuffer secret_key, ExternError err);
    int bls_get_public_key(ByteBuffer.ByValue secret_key, ByteBuffer public_key, ExternError err);
    int bls_public_key_to_bbs_key(ByteBuffer.ByValue d_public_key, int message_count, ByteBuffer public_key, ExternError err);
    int bls_secret_key_to_bbs_key(ByteBuffer.ByValue secret_key, int message_count, ByteBuffer public_key, ExternError err);

    // BBS Blind Commitment
    int bbs_blind_signature_size();
    long bbs_blind_commitment_context_init(ExternError err);
    int bbs_blind_commitment_context_finish(long handle, ByteBuffer commitment, ByteBuffer out_context, ByteBuffer blinding_factor, ExternError err);
    int bbs_blind_commitment_context_add_message_string(long handle, int index, String message, ExternError err);
    int bbs_blind_commitment_context_add_message_bytes(long handle, int index, ByteBuffer.ByValue message, ExternError err);
    int bbs_blind_commitment_context_add_message_prehashed(long handle, int index, ByteBuffer.ByValue message, ExternError err);
    int bbs_blind_commitment_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_blind_commitment_context_set_nonce_string(long handle, String message, ExternError err);
    int bbs_blind_commitment_context_set_nonce_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_blind_commitment_context_set_nonce_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);

    // BBS Blind Sign
    long bbs_blind_sign_context_init(ExternError err);
    int bbs_blind_sign_context_finish(long handle, ByteBuffer blinded_signature, ExternError err);
    int bbs_blind_sign_context_add_message_string(long handle, int index, String message, ExternError err);
    int bbs_blind_sign_context_add_message_bytes(long handle, int index, ByteBuffer.ByValue message, ExternError err);
    int bbs_blind_sign_context_add_message_prehashed(long handle, int index, ByteBuffer.ByValue message, ExternError err);
    int bbs_blind_sign_context_set_secret_key(long handle, ByteBuffer.ByValue secret_key, ExternError err);
    int bbs_blind_sign_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_blind_sign_context_set_commitment(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_unblind_signature(ByteBuffer.ByValue blind_signature, ByteBuffer.ByValue blinding_factor, ByteBuffer unblind_signature, ExternError err);

    // BBS Create Proof
    long bbs_create_proof_context_init(ExternError err);
    int bbs_create_proof_context_finish(long handle, ByteBuffer proof, ExternError err);
    int bbs_create_proof_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_create_proof_context_set_signature(long handle, ByteBuffer.ByValue signature, ExternError err);
    int bbs_create_proof_context_set_nonce_string(long handle, String message, ExternError err);
    int bbs_create_proof_context_set_nonce_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_create_proof_context_set_nonce_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_create_proof_context_add_proof_message_string(long handle, String message, proof_message_t xtype, ByteBuffer.ByValue blinding_factor, ExternError err);
    int bbs_create_proof_context_add_proof_message_bytes(long handle, ByteBuffer.ByValue message, proof_message_t xtype, ByteBuffer.ByValue blinding_factor, ExternError err);
    int bbs_create_proof_context_add_proof_message_prehashed(long handle, ByteBuffer.ByValue message, proof_message_t xtype, ByteBuffer.ByValue blinding_factor, ExternError err);

    // BBS Sign
    int bbs_signature_size();
    long bbs_sign_context_init(ExternError err);
    int bbs_sign_context_finish(long handle, ByteBuffer signature, ExternError err);
    int bbs_sign_context_add_message_string(long handle, String message, ExternError err);
    int bbs_sign_context_add_message_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_sign_context_add_message_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_sign_context_set_secret_key(long handle, ByteBuffer.ByValue secret_key, ExternError err);
    int bbs_sign_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);

    // BBS Verify
    long bbs_verify_context_init(ExternError err);
    int bbs_verify_context_finish(long handle, ExternError err);
    int bbs_verify_context_add_message_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_context_add_message_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_context_add_message_string(long handle, String message, ExternError err);
    int bbs_verify_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_verify_context_set_signature(long handle, ByteBuffer.ByValue signature, ExternError err);

    // BBS Verify Blind Commitment
    long bbs_verify_blind_commitment_context_init(ExternError err);
    int bbs_verify_blind_commitment_context_finish(long handle, ExternError err);
    int bbs_verify_blind_commitment_context_add_blinded(long handle, int index, ExternError err);
    int bbs_verify_blind_commitment_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_verify_blind_commitment_context_set_nonce_string(long handle, String message, ExternError err);
    int bbs_verify_blind_commitment_context_set_nonce_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_blind_commitment_context_set_nonce_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_blind_commitment_context_set_proof(long handle, ByteBuffer.ByValue proof, ExternError err);

    // BBS Verify Proof
    long bbs_verify_proof_context_init(ExternError err);
    int bbs_verify_proof_context_finish(long handle, ExternError err);
    int bbs_verify_proof_context_add_revealed_index(long handle, int index, ExternError err);
    int bbs_verify_proof_context_set_proof(long handle, ByteBuffer.ByValue proof, ExternError err);
    int bbs_verify_proof_context_set_public_key(long handle, ByteBuffer.ByValue public_key, ExternError err);
    int bbs_verify_proof_context_set_nonce_string(long handle, String message, ExternError err);
    int bbs_verify_proof_context_set_nonce_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_proof_context_set_nonce_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_proof_context_add_message_string(long handle, String message, ExternError err);
    int bbs_verify_proof_context_add_message_bytes(long handle, ByteBuffer.ByValue message, ExternError err);
    int bbs_verify_proof_context_add_message_prehashed(long handle, ByteBuffer.ByValue message, ExternError err);
}
