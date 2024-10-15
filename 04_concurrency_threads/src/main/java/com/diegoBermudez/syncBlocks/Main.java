package com.diegoBermudez.syncBlocks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Youtube youtube = new Youtube();
        System.out.println("options\n\n1.Reproduce video\n2.edit account" +
                "\n3.comment video\n4.add to playlist\n5.seeking video\n6.logout");
        Scanner myScan = new Scanner(System.in);
        while(true){
            System.out.println("WAITING FOR OPTION PRESSED");
            int option = myScan.nextInt();
            myScan.nextLine();
            switch (option){
                case 1: {
                    (new MyThread() {
                        @Override
                        public void run() {
                            nvideo++;
                            youtube.reproduceVideo(nvideo);
                        }
                    }).start();
                }; break;
                case 2: {
                    (new Thread(){
                        @Override
                        public void run(){
                            youtube.editAccount();
                        }
                    }).start();
                }; break;
                case 3: {
                    (new Thread(){
                        @Override
                        public void run(){
                            youtube.commentVideo();
                        }
                    }).start();
                }; break;
                case 4: {
                    (new Thread(){
                        @Override
                        public void run(){
                            youtube.addToPlaylist();
                        }
                    }).start();
                };break;
                case 5: {
                    (new Thread(){
                        @Override
                        public void run(){
                            youtube.seekingVideo();
                        }
                    }).start();
                }; break;
            }
            if(option == 6) break;
        }

        System.out.println("THE NAME IS: " + youtube.getName());
        youtube.writeComments();
    }
}
