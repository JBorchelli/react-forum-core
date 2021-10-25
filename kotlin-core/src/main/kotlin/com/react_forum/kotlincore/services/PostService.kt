package com.react_forum.kotlincore.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.react_forum.kotlincore.entities.Post
import com.react_forum.kotlincore.entities.User
import com.react_forum.kotlincore.entities.Discussion
import com.react_forum.kotlincore.toNullable
import com.react_forum.kotlincore.data_access.DiscussionRepository
import com.react_forum.kotlincore.data_access.PostRepository
import com.react_forum.kotlincore.data_access.UserRepository
import com.react_forum.kotlincore.exceptions.PostDoesNotExistException
import com.react_forum.kotlincore.exceptions.DiscussionDoesNotExistException
import com.react_forum.kotlincore.exceptions.UserDoesNotExistException

class PostService(
    private val postRepository: PostRepository, 
    private val discussionRepository: DiscussionRepository, 
    private val userRepository: UserRepository) {

    fun getPostsByDiscussion(discussionId: Long): List<Post> {

        val discussion: Discussion = discussionRepository.findById(discussionId).toNullable() ?: throw DiscussionDoesNotExistException()
        return postRepository.findByDiscussion(discussion).toList()     
    
    }

    fun createPost(content: String, userId: Long, discussionId: Long): Post {
        
        val user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        val discussion: Discussion = discussionRepository.findById(discussionId).toNullable() ?: throw DiscussionDoesNotExistException()
        var post: Post = Post()
        post.content = content
        post.discussion = discussion
        post.user = user
        return postRepository.save(post)

    }

    fun updatePostContent(postId: Long, postContent: String): Post {

       var updatePost: Post = postRepository.findById(postId).toNullable() ?: throw PostDoesNotExistException()
       updatePost.content = postContent
       return updatePost

    }

    fun removePost(postId: Long): Boolean {

        postRepository.deleteById(postId)
        return !postRepository.existsById(postId)
    
    }

} 

