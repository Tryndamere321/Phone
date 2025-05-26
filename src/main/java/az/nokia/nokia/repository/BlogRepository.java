package az.nokia.nokia.repository;

import az.nokia.nokia.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Blog findByTitle(String title);
}
