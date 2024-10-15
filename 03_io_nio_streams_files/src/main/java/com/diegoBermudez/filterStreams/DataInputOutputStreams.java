package com.diegoBermudez.filterStreams;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;

public class DataInputOutputStreams {
    public static void main(String[] args) {

        //los DataInput/Output streams son filter streams que transforman los bytes para escribir tipos de dato
        //primitivos
        try {
            String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/filterStreams/pruebaDATA.dat";
            OutputStream ou = new FileOutputStream(path, false);
            DataOutputStream out = new DataOutputStream(ou);
            out.writeBoolean(true);
            out.writeByte(110);
            out.writeChar('h');
            out.writeDouble(102.36);
            out.writeInt(10025);
            out.writeLong(1253343422);
            System.out.println("Written succesfully");
            System.out.println("Now to read");
            out.close();
            DataInputStream oin = new DataInputStream(new FileInputStream(path));
            System.out.println(oin.readBoolean() + " and " + oin.readByte() + " and "+ oin.readChar() + " and " + oin.readDouble() + " and " +
                    oin.readInt() + " and " + oin.readLong());
        }catch(IOException e){

        }

    }
}
