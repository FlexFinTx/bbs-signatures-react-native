package com.reactlibrary;

import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.List;

public class ExternError extends Structure {
    public int code;
    public String message;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("code", "message");
    }
}