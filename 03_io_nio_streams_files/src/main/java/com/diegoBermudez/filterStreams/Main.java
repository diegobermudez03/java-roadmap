package com.diegoBermudez.filterStreams;

import com.diegoBermudez.AuxiliarObtenerPath;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //FilterInput/Output streams are classes that actually rely on any Input/Output Stream, but they apply one more layer
        //in between in order to apply any kind of filtering or additional work, that's why they receive an Input/OutputStream as the parameter

        //basic implementation of a FilterInputStream
        String path = AuxiliarObtenerPath.obtenerPath() + "03_io_nio_streams_files/src/main/java/com/diegoBermudez/filterStreams/prueba.txt";
        //the Filter Stream implemented only converts lower case characters into upper stream
        InputStream rand = new RandomFilterStream(new FileInputStream(path));
        byte[] arreglo = new byte[rand.available()];
        rand.read(arreglo);
        System.out.write(arreglo);
        System.out.flush();
        rand.close();

        //EXAMPLE OF MY OWN OUTPUT BUFFER STREAM

        OutputStream buffer = new MyBufferStream(new FileOutputStream(path));
        String frase1 = "Moment of Glory es un álbum de estudio de la banda alemana de hard rock y heavy metal Scorpions y " +
                "la Orquesta Filarmónica de Berlín, publicado en 2000 por EMI Classics. En 1995, la orquesta escogió a Scorpions " +
                "para realizar un crossover que unificara la música clásica con la popular. Después de considerar al británico Andrew " +
                "Powell y luego al estadounidense Michael Kamen, al final el austríaco Christian Kolonovits asumió el cargo de director " +
                "de orquesta y arreglista. En 1998, el canciller de Alemania y amigo de Klaus Meine, Gerhard Schröder, supo de la " +
                "colaboración y le propuso al grupo que formara parte de la EXPO 2000 que se iba a realizar ese año en Hannover, " +
                "ciudad natal de Scorpions. Después de conversarlo con la filarmónica, acordaron presentar el proyecto en esa exposición " +
                "universal.";
        String frase2 = "The Simpsons is an American animated sitcom created by Matt Groening for the Fox Broadcasting Company.[1][2][3] Developed by Groening, James L. Brooks, and Sam " +
                "Simon, the series is a satirical depiction of American life, epitomized by the Simpson family, " +
                "which consists of Homer, Marge, Bart, Lisa, and Maggie. Set in the fictional town of Springfield, it caricatures society, Western culture, television, and the human condition.\n" +
                "\n" +
                "The family was conceived by Groening shortly before a solicitation for a series of animated shorts with producer Brooks. He " +
                "created a dysfunctional family and named the characters after his own family members, substituting Bart for his own name; he thought Simpson was a funny name in that it " +
                "sounded similar to \"simpleton\".[4] The shorts became a part of The Tracey Ullman Show on April 19, 1987. After three seasons, the sketch was developed into a half-hour prime time " +
                "show and became Fox's first series to land in the Top 30 ratings in a season (1989–1990).[citation needed]\n" +
                "\n" +
                "Since its debut on December 17, 1989, 768 episodes of the show have been broadcast. It is the longest-running American animated " +
                "series, longest-running American sitcom, and the longest-running American scripted primetime television series, both in seasons and individual episodes. A feature-length film, " +
                "The Simpsons Movie, was released in theaters worldwide on July 27, 2007, to critical and commercial success, with a sequel in development as of 2018. The series has also spawned numerous comic book series, video games, books, and other related media, " +
                "as well as a billion-dollar merchandising industry. The Simpsons is a joint production by Gracie Films and 20th Television.[5]\n" +
                "\n" +
                "On January 26, 2023, the series was renewed for its 35th and 36th seasons, taking the show through the 2024–25 television" +
                " season.[6] Both seasons contain a combined total of 51 episodes. Seven of these episodes are season 34 holdovers, while the " +
                "other 44 will be produced in the production cycle of the upcoming seasons, bringing the show's overall episode total up to 801.[7] Season 35 premiered on October 1, 2023.[8]\n" +
                "\n" +
                "The Simpsons received widespread acclaim throughout its early seasons in the 1990s, which are generally considered its \"golden " +
                "age\". Since then, it has been criticized for a perceived decline in quality. Time named it the 20th century's best television " +
                "series,[9] and Erik Adams of The A.V. Club named it \"television's crowning achievement regardless of format\".[10] On January 14, 2000, the Simpson family was awarded a star on the Hollywood Walk of Fame. " +
                "It has won dozens of awards since it debuted as a series, including 37 Primetime Emmy Awards, 34 Annie Awards, and 2 Peabody Awards. Homer's exclamatory catchphrase of \"D'oh!\" has been adopted into the English language, while The Simpsons has influenced many other later adult-oriented animated " +
                "sitcom television series.";
        buffer.write(frase1.getBytes(), 0 , 500);
        buffer.write(frase2.getBytes(), 0, 1000);
        Thread.sleep(5000);
        System.out.println("\nTiempo 1 completado");
        //para probar que el buffer funciona, para este punto no se debio haber escrito nada aun
        buffer.write(frase2.getBytes(), 0, 1000);
        //ahora aca si se deberia escribir
        Thread.sleep(5000);
        System.out.println("Tiempo 2 completado");
        //y aca se deberian escribir los restantes
        buffer.flush();
        System.out.println("Final completado");
    }
}
