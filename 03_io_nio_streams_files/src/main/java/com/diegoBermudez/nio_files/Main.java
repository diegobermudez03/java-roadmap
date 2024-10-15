package com.diegoBermudez.nio_files;


import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/nio_files/file.txt");
        if(!Files.exists(filePath)) createAndWrite(filePath);

        try(FileChannel file = FileChannel.open(filePath,  StandardOpenOption.READ )){
            while(true) {
                ByteBuffer bytes = ByteBuffer.allocate(1024);
                int readed = file.read(bytes);
                if(readed == -1) break;
                System.out.println(new String(bytes.array(),0, readed));
            }

        }

    }

    private static void createAndWrite(Path filePath) throws IOException {
        Files.createFile(filePath);
        try(FileChannel file = FileChannel.open(filePath,  StandardOpenOption.WRITE)){
            String texto = """
                    Hola, este es el mensaje de lo que estamos hablando ahorita mismo, mmmm, bueno, \
                    este es el mensaje que voy a publciar en el archivo para probar, pero quiero que tenga mas de \
                    de 1024 bytes para probar que sirva con muchos muchos caracteres, asi que voy a escribir random \s
                    dfjdsfdj hfds hjksdfh djfh dkjs hfjkdsh fhdskj fhsdjk fhjkdsh fdsh fjkdsh fjhdhd dkjsfh jdshjhd\
                     dfhksdjfh df dh jd f dkhs fjhsjk fhd hf jdhfjdhfjkd fhdjks fhjdks fhjhf fhfd kjdh js hfdfshjd\
                      hdfjkhsjk fh sd fhsf djsf sdjkh fjshfjhds fsdkjfh soiurf wefiujwe jfdkfjdghdfkj ghdfjkhgjhd g\s
                    Hola, este es el mensaje de lo que estamos hablando ahorita mismo, mmmm, bueno, \
                    este es el mensaje que voy a publciar en el archivo para probar, pero quiero que tenga mas de \
                    de 1024 bytes para probar que sirva con muchos muchos caracteres, asi que voy a escribir random \s
                    dfjdsfdj hfds hjksdfh djfh dkjs hfjkdsh fhdskj fhsdjk fhjkdsh fdsh fjkdsh fjhdhd dkjsfh jdshjhd\
                     dfhksdjfh df dh jd f dkhs fjhsjk fhd hf jdhfjdhfjkd fhdjks fhjdks fhjhf fhfd kjdh js hfdfshjd\
                      hdfjkhsjk fh sd fhsf djsf sdjkh fjshfjhds fsdkjfh soiurf wefiujwe jfdkfjdghdfkj ghdfjkhgjhd g\s
                    Hola, este es el mensaje de lo que estamos hablando ahorita mismo, mmmm, bueno, \
                    este es el mensaje que voy a publciar en el archivo para probar, pero quiero que tenga mas de \
                    de 1024 bytes para probar que sirva con muchos muchos caracteres, asi que voy a escribir random \s
                    dfjdsfdj hfds hjksdfh djfh dkjs hfjkdsh fhdskj fhsdjk fhjkdsh fdsh fjkdsh fjhdhd dkjsfh jdshjhd\
                     dfhksdjfh df dh jd f dkhs fjhsjk fhd hf jdhfjdhfjkd fhdjks fhjdks fhjhf fhfd kjdh js hfdfshjd\
                      hdfjkhsjk fh sd fhsf djsf sdjkh fjshfjhds fsdkjfh soiurf wefiujwe jfdkfjdghdfkj ghdfjkhgjhd g\s
                    Hola, este es el mensaje de lo que estamos hablando ahorita mismo, mmmm, bueno, \
                    este es el mensaje que voy a publciar en el archivo para probar, pero quiero que tenga mas de \
                    de 1024 bytes para probar que sirva con muchos muchos caracteres, asi que voy a escribir random \s
                    dfjdsfdj hfds hjksdfh djfh dkjs hfjkdsh fhdskj fhsdjk fhjkdsh fdsh fjkdsh fjhdhd dkjsfh jdshjhd\
                     dfhksdjfh df dh jd f dkhs fjhsjk fhd hf jdhfjdhfjkd fhdjks fhjdks fhjhf fhfd kjdh js hfdfshjd\
                      hdfjkhsjk fh sd fhsf djsf sdjkh fjshfjhds fsdkjfh soiurf wefiujwe jfdkfjdghdfkj ghdfjkhgjhd g\s
                    Hola, este es el mensaje de lo que estamos hablando ahorita mismo, mmmm, bueno, \
                    este es el mensaje que voy a publciar en el archivo para probar, pero quiero que tenga mas de \
                    de 1024 bytes para probar que sirva con muchos muchos caracteres, asi que voy a escribir random \s
                    dfjdsfdj hfds hjksdfh djfh dkjs hfjkdsh fhdskj fhsdjk fhjkdsh fdsh fjkdsh fjhdhd dkjsfh jdshjhd\
                     dfhksdjfh df dh jd f dkhs fjhsjk fhd hf jdhfjdhfjkd fhdjks fhjdks fhjhf fhfd kjdh js hfdfshjd\
                      hdfjkhsjk fh sd fhsf djsf sdjkh fjshfjhds fsdkjfh soiurf wefiujwe jfdkfjdghdfkj ghdfjkhgjhd g\s
                    """;
            byte[] bytes = texto.getBytes();
            int pointer = 0;
            int last = 0;
            ByteBuffer bytesBuffer = null;
            while(true){
                if((bytes.length - pointer) < 0) break;
                if((bytes.length - pointer) < 1024) last = bytes.length;
                else last = pointer + 1024;
                bytesBuffer = ByteBuffer.wrap(Arrays.copyOfRange(bytes, pointer, last));
                pointer += 1024;
                file.write(bytesBuffer);
            }
        }
    }
}
