package demo.like.modele;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeData, Integer> { 
       
}
