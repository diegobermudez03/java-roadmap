package com.diegoBermudez.syncBlocks;

import java.util.*;

public class Youtube {

    private Object additionalActions =  new Object();
    private Object lookingForVideos = new Object();
    private List<InnerComment> comments = new LinkedList<>();
    private Map<Integer, Integer> playlists = new HashMap<>();
    private int currentVideo;
    private int seekVideo = 0;
    private StringBuilder name;
    private boolean reproduciendo = false;

    private class InnerComment{
        public int video;
        public String comment;
        public InnerComment(int video, String comment){
            this.video = video;
            this.comment = comment;
        }
    }

    public void reproduceVideo(int nVideo){
        for(int i = 0; i < 10; i++){
            System.out.println("loading new video " + nVideo + " in background");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized(this){
            currentVideo = nVideo;
            for(int i = 0; i < 30; i++){
                System.out.println("reproducing video " + nVideo);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("THE VIDEO " + nVideo + " ENDED");
        }
    }

    public void editAccount(){
        synchronized (this){
            Scanner myScan = new Scanner(System.in);
            System.out.println("\n\nLets edit your account, introduce your new name");
            name = new StringBuilder(myScan.nextLine());
            System.out.println("ACCOUNT EDITED");
        }
    }

    public void commentVideo(){
        synchronized (additionalActions){
            Scanner myScan = new Scanner(System.in);
            System.out.println("\n\nLets leave a comment, write your comment");
            String comment = myScan.nextLine();
            //since this line reads the currentVideo, and that variable is modifiedd by another
            //method which is synchronized by another lock, then, this could cause issues, but
            //this is only for the example, but just for you to know, here is a possible leak
            comments.add(new InnerComment(currentVideo, comment));
            System.out.println("COMMENT LEFT SUCCESFULLYYYYY");

        }
    }

    public void addToPlaylist(){
        synchronized (additionalActions){
            System.out.println("Adding video " + currentVideo + " to playlist");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Video added to playlist " + currentVideo);
        }
    }

    public void seekingVideo(){
        synchronized (lookingForVideos){
            for(int i = 0; i < 10; i++){
                System.out.println("seeking video " + seekVideo);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String getName() {
        return this.name.toString();
    }

    public void writeComments() {

    }
}
