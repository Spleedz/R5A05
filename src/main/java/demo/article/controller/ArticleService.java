package demo.article.controller;
import java.util.Collection;
import java.util.Optional;
import java.sql.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.article.modele.ArticleRepository;
import demo.user.controller.User;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void addArticle(Date publicationDate, User author, String content) {
        Article a = new Article(publicationDate, author, content);
        a.setPublicationDate(publicationDate);
        a.setAuthor(author);
        a.setContent(content);
        articleRepository.save(a.toData());
    }

    public Optional<Article> getArticleById(Integer id) {
        return articleRepository.findById(id).map(Article::new);
    }

    public Collection<Article> getAllArticles() {
        return articleRepository.findAll().stream().map(Article::new).collect(Collectors.toList());
    }

    public void editArticle(Integer id, Date publicationDate, User author, String content) {
        Article a = new Article(publicationDate, author, content);
        a.setId(id);
        a.setPublicationDate(publicationDate);
        a.setAuthor(author);
        a.setContent(content);        
        articleRepository.save(a.toData());
    }

    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
