package com.example.day1;

public class WiseSaying {
    private int id;
    private String say;
    private String author;

    public WiseSaying(int id, String say, String author) {
        this.id = id;
        this.say = say;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getSay() {
        return say;
    }

    public String getAuthor() {
        return author;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
