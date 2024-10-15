package com.diegoBermudez.nio_files;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferNIO {

    public static void main(String[] args) throws IOException {
        //Tranfer allows us to transfer from a channel to another, without storing the sata in the memory, avoiding that intermediate
        //step, it's really useful for instance when copying and pasting
        //I'm adding the example here with files, but it can be used with sockets, it would be actually useful for instance
        //in a group chat to redirect the message (transfer) to all the other members
        File f1 = new File(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/nio_files/file.txt");
        File f2 = new File((AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/nio_files/copyFile1.txt"));
        File f3 = new File((AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/nio_files/copyFile2.txt"));
        f2.createNewFile();
        f3.createNewFile();
        try(
                FileInputStream f1in = new FileInputStream(f1);
                FileOutputStream f2out = new FileOutputStream(f2);
                FileInputStream f2in = new FileInputStream(f2);
                FileOutputStream f3out = new FileOutputStream(f3);
            FileChannel f1inChannel = f1in.getChannel();
            FileChannel f2outChannel = f2out.getChannel();
            FileChannel f2inChannel = f2in.getChannel();
            FileChannel f3outChannel = f3out.getChannel();
        ){
            f2outChannel.transferFrom(f1inChannel, 0, f1inChannel.size());
            //or
            f2in.readAllBytes();
            f2inChannel.transferTo(0, f2inChannel.size(), f3outChannel);

        }
    }
}
