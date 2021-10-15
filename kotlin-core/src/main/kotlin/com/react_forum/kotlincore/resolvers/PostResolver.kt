package com.react_forum.kotlincore.resolvers

import org.springframework.stereotype.Component
import com.graphql-java-kickstart.tools.GraphQLResolver
import com.react_forum.kotlincore.entities.Post
import com.react_forum.kotlincore.services.PostService

@Component
class PostResolver (private val postService: PostService): GraphQLResolver<Post> {
   

    //############################################################### 
    //#########################   Queries   #########################
    //############################################################### 
    
    fun postsByDiscussion(discussionId: Long): List<Post> {
        
    }

    fun postsByUser(userId: Long): List<Post> {

    }


    //############################################################### 
    //########################   Mutations   ########################
    //############################################################### 
    
    fun createPost(content: String, discussionId: Long, userId: Long): Post {

    }

    fun updatePost(postId: Long, content: String): Post {

    }

    fun removePost(postId: Long): Boolean {

    }

}

