package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    // no need to explicity write any methods to talk with methods. we can use crud operations. it also supports pagination and sorting
    //it interally extends crudrepository
}
