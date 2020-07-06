package com.reactlibrary;

import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.List;

public class ByteBuffer extends Structure {
    public static class ByValue extends ByteBuffer implements Structure.ByValue {}
    public long len;
    public IntByReference data;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("len", "data");
    }
}