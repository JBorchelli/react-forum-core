package com.react_forum.kotlincore.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.react_forum.kotlincore.entities.Category
import com.react_forum.kotlincore.entities.Discussion
import com.react_forum.kotlincore.entities.User
import com.react_forum.kotlincore.toNullable
import com.react_forum.kotlincore.data_access.CategoryRepository
import com.react_forum.kotlincore.data_access.DiscussionRepository
import com.react_forum.kotlincore.data_access.UserRepository
import com.react_forum.kotlincore.exceptions.CategoryDoesNotExistException
import com.react_forum.kotlincore.exceptions.DiscussionDoesNotExistException
import com.react_forum.kotlincore.exceptions.UserDoesNotExistException

class DiscussionService(
    private val discussionRepository: DiscussionRepository, 
    private val categoryRepository: CategoryRepository, 
    private val userRepository: UserRepository) {

    fun getDiscussionsByCategory(categoryId: Long): List<Discussion> {
        
        val category: Category = categoryRepository.findById(categoryId).toNullable() ?: throw CategoryDoesNotExistException()
        return discussionRepository.findByCategory(category).toList()     
    
    }

    fun createDiscussion(heading: String, sub: String? = null, categoryId: Long, userId: Long): Discussion {

        val category: Category = categoryRepository.findById(categoryId).toNullable() ?: throw CategoryDoesNotExistException()
        val user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        var discussion: Discussion = Discussion()
        discussion.heading = heading
        discussion.sub = sub
        discussion.category = category
        discussion.user = user
        return discussionRepository.save(discussion)

    }

    fun updateDiscussion(discussionId: Long, heading: String? = null, sub: String? = null): Discussion {
       
        var updateDiscussion: Discussion = discussionRepository.findById(discussionId).toNullable() ?: throw DiscussionDoesNotExistException()
        heading?.let { updateDiscussion.heading = heading }
        sub?.let { updateDiscussion.sub = sub }
        return updateDiscussion

    }

    fun removeDiscussion(discussionId: Long): Boolean {
        
        discussionRepository.deleteById(discussionId)
        return !discussionRepository.existsById(discussionId)
    
    }

}
