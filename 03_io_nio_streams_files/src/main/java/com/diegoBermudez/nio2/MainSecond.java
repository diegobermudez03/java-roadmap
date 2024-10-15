package com.diegoBermudez.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class MainSecond {
    //this constant was obtained with reverse enginerring checking the contentType
    private static final String WORD_TYPE = "vnd.openxmlformats-officedocument.wordprocessingml.document";

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("C:\\Users\\Usuario\\Documents\\universidad\\Semestre 4\\Fundamentos ing\\Diapositivas");
        String workingDir = "C:\\Users\\Usuario\\Documents\\0 DEVELOPER CAREER\\pruebaNIO";

        //THIS TRY WITH RESOURCS WHAT DOES IS THAT, IN THE () WE INCLUDE THE RESOURCES THAT WE'LL USE, THOSE ARE THE ONES THAT NEED
        //TO BE CLOSED, THEY ARE CLOSED AUTOMATICALLY
        try(Stream<Path> paths = Files.list(p)){
            paths.forEach((path)->{
                if(isWord(path)) System.out.println("this file is WORD");
                else if(isPdf(path)) {
                    System.out.println("this file is PDF");
                    Path destiny = Paths.get(workingDir + "\\" + path.getFileName());
                    try {
                        Files.copy(path, destiny, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(isZip(path)) System.out.println("this file is ZIP");
                else System.out.println("this file is something else");

            });
        }


        //WALK METHOD, THIS IS SIMILAR TO LIST, BUT THIS ONE GOES INSIDE ALL THE SUBDIRECTORIES
        System.out.println("----------------------------------------------------------------");
        Path dir = Paths.get("C:\\Users\\Usuario\\Documents\\universidad\\Semestre 4\\Fundamentos ing\\proyecto");
        Files.walk(dir).forEach((path)-> System.out.println(path.getFileName()));
    }

    private static boolean checkType(Path p, String type){
        try {
            String content = Files.probeContentType(p);
            if(content != null){
                String[] aux = content.split("/");
                return aux[0].equals("application") && aux[1].equals(type);
            }
            return false;
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isWord(Path p){
      return checkType(p, WORD_TYPE);
    }

    private static boolean isZip(Path p){
        return checkType(p, "zip");
    }

    private static boolean isPdf(Path p){
        return checkType(p, "pdf");
    }
}
