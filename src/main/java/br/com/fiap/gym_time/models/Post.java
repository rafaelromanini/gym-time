package br.com.fiap.gym_time.models;

import java.time.LocalDate;
import java.util.Random;

// Attributes
public class Post {
    private Long id;
    private String account;
    private String urlImage;
    private String content;
    private LocalDate date;
    private Long likes;
    private Long comments;
    private Long shares;


    // Constructors

    public Post(Long id, String account, String urlImage, String content, LocalDate date, Long likes, Long comments, Long shares) {
        this.id = (id == null) ? new Random().nextLong() : id;
        this.account = account;
        this.urlImage = urlImage;
        this.content = content;
        this.date = date;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }



}
