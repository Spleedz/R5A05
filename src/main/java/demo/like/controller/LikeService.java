package demo.like.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.article.controller.Article;
import demo.like.modele.LikeRepository;
import demo.user.controller.User;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Collection<Like> getAllLikes() {
        return likeRepository.findAll().stream().map(Like::new).collect(Collectors.toList());
    }

    public void addLike(Likes liked, User user, Article article) {
        Like l = new Like(liked, user, article);
        likeRepository.save(l.toData());
    }

    public void editLike(Integer id, Likes liked, User user, Article article) {
        Like l = new Like(liked, user, article);
        l.setId(id);
        likeRepository.save(l.toData());
    } 
}
