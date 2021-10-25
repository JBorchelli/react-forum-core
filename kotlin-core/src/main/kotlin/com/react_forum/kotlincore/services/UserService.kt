package com.react_forum.kotlincore.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.react_forum.kotlincore.entities.Group
import com.react_forum.kotlincore.entities.User
import com.react_forum.kotlincore.toNullable
import com.react_forum.kotlincore.data_access.GroupRepository
import com.react_forum.kotlincore.data_access.UserRepository
import com.react_forum.kotlincore.exceptions.GroupDoesNotExistException
import com.react_forum.kotlincore.exceptions.UserDoesNotExistException

@Service
@Transactional
class UserService(private val userRepository: UserRepository, private val groupRepository: GroupRepository) {
    
    fun getUsersByGroup(groupId: Long): List<User> {
        
        return userRepository.findByGroupId(groupId).toList()
        
    }

    fun createUser(username: String): User {
        
        val user: User = User()
        user.username = username
        return userRepository.save(user)
    
    }

    fun updateUserName(userId: Long, username: String): User {
       
       var updateUser: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
       updateUser.username = username
       return updateUser
    
    }

    fun removeUser(userId: Long): Boolean {
        
        userRepository.deleteById(userId)
        return !userRepository.existsById(userId)
    
    }

    fun addGroupToUser(userId: Long, groupId: Long): User {
    
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        var user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        user.addGroup(group)
        return user

    }
    
    fun removeGroupFromUser(userId: Long, groupId: Long): User {
    
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        var user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        user.removeGroup(group)
        return user

    }
}

