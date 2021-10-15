package com.react_forum.kotlincore.resolvers

import org.springframework.stereotype.Component
import com.graphql-java-kickstart.tools.GraphQLResolver
import com.react_forum.kotlincore.entities.Discussion
import com.react_forum.kotlincore.services.DiscussionService

@Component
class DiscussionResolver (private val discussionService: DiscussionService): GraphQLResolver<Discussion> {
   

    //############################################################### 
    //#########################   Queries   #########################
    //############################################################### 
    
    fun discussionsByCategory(categoryId: Long): List<Discussion> {
        
    }
    
    fun discussionsByUser(userId: Long): List<Discussion> {

    }

    //############################################################### 
    //########################   Mutations   ########################
    //############################################################### 
    
    fun createDiscussion(heading: String, sub: String, categoryId: Long, userId: Long): Discussion {

    }

    fun updateDiscussion(discussionId: Long, heading: String, sub: String): Discussion{
    
    }

    fun removeDiscussion(discussionId: Long): Boolean {

    }

}

