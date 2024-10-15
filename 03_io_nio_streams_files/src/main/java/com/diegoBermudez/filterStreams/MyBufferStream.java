package com.diegoBermudez.filterStreams;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class MyBufferStream extends FilterOutputStream {

    private int BUFFER_SIZE = 2000;
    private byte[] buffer = new byte[BUFFER_SIZE];
    private int filled = 0;

    public MyBufferStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        if(filled == BUFFER_SIZE){
            liberate();
        }
        buffer[++filled] = (byte)b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        if(b.length > BUFFER_SIZE-filled){
            liberate();
            if(b.length > BUFFER_SIZE){
                super.out.write(b, 0, BUFFER_SIZE);
            }
            if(b.length > BUFFER_SIZE) write(Arrays.copyOfRange(b, BUFFER_SIZE, b.length-1));
        }
        else{
            int end = filled + b.length;
            for(int i = filled, j = 0; i < end; i++, j++, filled++){
                buffer[i] = b[j];
            }
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
       this.write(Arrays.copyOfRange(b, off, off+len));
    }

    @Override
    public void flush() throws IOException {
        super.out.write(buffer,0, filled);
        super.out.flush();
    }

    private void liberate() throws IOException {
        super.out.write(buffer, 0, filled);
        filled = 0;
    }

}
