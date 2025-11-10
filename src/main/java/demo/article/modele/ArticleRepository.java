package demo.article.modele;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleData, Integer> { 
       
}
