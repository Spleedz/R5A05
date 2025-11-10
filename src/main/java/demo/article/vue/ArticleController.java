package demo.article.vue;

import java.sql.Date;
import java.util.Collection;
import demo.user.controller.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.article.controller.Article;
import demo.article.controller.ArticleService;
import demo.user.controller.User;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path="/article")
public class ArticleController {

    private UserService userService;

    @Autowired
    private ArticleService articleService;

    ArticleController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addArticle(@RequestParam Integer idAuthor,
        @RequestParam String content) {
        Date publicationDate = new Date(System.currentTimeMillis());
        User authorUser = userService.getUserById(idAuthor).get();
        articleService.addArticle(publicationDate, authorUser, content);        
        return "Saved";
    }
    

    @GetMapping(path="/all")
    public @ResponseBody Collection<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PutMapping(path="edit/{pathId}")
    public String editArticle(@PathVariable String pathId,
        @RequestParam Integer idAuthor, @RequestParam String content) {
        int id = Integer.parseInt(pathId);
        User authorUser = userService.getUserById(idAuthor).get();
        Date publicationDate = new Date(System.currentTimeMillis());
        articleService.editArticle(id, publicationDate, authorUser, content);
        return "Edited";
    }

    @DeleteMapping(path="delete/{pathId}")
    public String deleteArticle(@PathVariable String pathId) {
        int id = Integer.parseInt(pathId);
        articleService.deleteArticle(id);
        return "Deleted";
    }
}
