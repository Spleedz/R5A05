package demo.article.controller;

import java.sql.Date;

import demo.article.modele.ArticleData;
import demo.user.controller.User;

public class Article {
    private Integer id;

    private Date publicationDate;

    private User author;

    private String content;

    public Article(ArticleData articleData) {
        this.id = articleData.getId();
        this.publicationDate = articleData.getPublicationDate();
        this.author = new User(articleData.getAuthor());
        this.content = articleData.getContent();
    }

    public Article(Date publicationDate, User author, String content) {
        this.publicationDate = publicationDate;
        this.author = author;
        this.content = content;
    }

    public ArticleData toData() {
        ArticleData a = new ArticleData();
        a.setId(id);
        a.setPublicationDate(publicationDate);
        a.setAuthor(author.toData());
        a.setContent(content);
        return a;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
