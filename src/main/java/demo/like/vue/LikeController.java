package demo.like.vue;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import demo.article.controller.ArticleService;
import demo.like.controller.Like;
import demo.like.controller.LikeService;
import demo.like.controller.Likes;
import demo.user.controller.User;
import demo.article.controller.Article  ;
import demo.user.controller.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path="/like")
public class LikeController {

    private UserService userService;

    private ArticleService articleService;   
    
    @Autowired
    private LikeService likeService;

    LikeController(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @GetMapping(path="/all")
    public @ResponseBody Collection<Like> getAllLikes() {
        return likeService.getAllLikes();
    }
    

    @PostMapping(path="/add")
    public @ResponseBody String addLike(@RequestParam Integer idUser, 
        @RequestParam Integer idArticle, @RequestParam  Likes liked) {
        User user = userService.getUserById(idUser).get();
        Article article = articleService.getArticleById(idArticle).get();
        likeService.addLike(liked,user,article); 
        return "Saved";       
    }

    @PutMapping(path="edit/{pathId}")
    public String editArticle(@PathVariable String pathId,
        @RequestParam  Likes liked, @RequestParam Integer idUser, @RequestParam Integer idArticle) {
        int id = Integer.parseInt(pathId);
        User user = userService.getUserById(idUser).get();
        Article article = articleService.getArticleById(idArticle).get();
        likeService.editLike(id, liked, user, article);
        return "Edited";
    }    
}