package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.react_forum.kotlincore.entities.Discussion
import com.react_forum.kotlincore.entities.Post

/**
 * JPA data repository for the Post entity.
 */
@Repository
interface PostRepository: JpaRepository<Post, Long> {
    
    fun findByDiscussion(discussion: Discussion): Iterable<Post>

}
