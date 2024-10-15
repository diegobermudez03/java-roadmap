package com.diegoBermudez.filterStreams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RandomFilterStream extends FilterInputStream {

    protected RandomFilterStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte b[]) throws IOException {
        int readed = super.read(b);
        for(int i = 0; i < b.length; i++){
            if(b[i] >= 97 && b[i] <= 122){
                b[i] -= 32;
            }
        }
        return readed;
    }
}
