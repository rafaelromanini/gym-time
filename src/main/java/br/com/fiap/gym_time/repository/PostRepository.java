package br.com.fiap.gym_time.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.gym_time.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
