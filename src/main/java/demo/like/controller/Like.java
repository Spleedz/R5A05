package demo.like.controller;

import demo.article.controller.Article;
import demo.like.modele.LikeData;
import demo.user.controller.User;

public class Like {
    private Integer id;

    private Likes liked;

    private User user;

    private Article article;

    public Like(LikeData likeData) {
        this.id = likeData.getId();
        this.liked = likeData.getLiked();
        this.user = new User(likeData.getUser());
        this.article = new Article(likeData.getArticle());
    }

    public Like(Likes liked, User user, Article article) {
        this.liked = liked;
        this.user = user;
        this.article = article;
    }

    public LikeData toData() {
        LikeData l = new LikeData();
        l.setId(id);
        l.setLiked(liked);
        l.setUser(user.toData());
        l.setArticle(article.toData());
        return l;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Likes getLiked() {
        return liked;
    }

    public void setLiked(Likes liked) {
        this.liked = liked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}