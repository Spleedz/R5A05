package demo.like.modele;

import demo.article.modele.ArticleData;
import demo.like.controller.Likes;
import demo.user.modele.UserData;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LikeData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Likes liked;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserData user;

    @ManyToOne(fetch=FetchType.LAZY)
    private ArticleData article;

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

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public ArticleData getArticle() {
        return article;
    }

    public void setArticle(ArticleData article) {
        this.article = article;
    }
}
