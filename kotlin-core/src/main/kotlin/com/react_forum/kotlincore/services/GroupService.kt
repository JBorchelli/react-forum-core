package com.react_forum.kotlincore.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.react_forum.kotlincore.entities.Group
import com.react_forum.kotlincore.entities.User
import com.react_forum.kotlincore.data_access.GroupRepository
import com.react_forum.kotlincore.data_access.UserRepository
import com.react_forum.kotlincore.exceptions.GroupDoesNotExistException
import com.react_forum.kotlincore.exceptions.UserDoesNotExistException
import com.react_forum.kotlincore.toNullable

@Service
@Transactional
class GroupService ( private val groupRepository: GroupRepository, private val userRepository: UserRepository ) {
    
    fun getGroupsByUser(userId: Long): List<Group> {
        
        return groupRepository.findByUserId(userId).toList()
        
    }

    fun createGroup(groupName: String): Group {
        
        var group: Group = Group()
        group.name = groupName
        return groupRepository.save(group)
    
    }

    fun updateGroupName(groupId: Long, groupName: String): Group {
       
       var updateGroup: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
       updateGroup.name = groupName
       return updateGroup
    
    }

    fun removeGroup(groupId: Long): Boolean {
        
        groupRepository.deleteById(groupId)
        return !groupRepository.existsById(groupId)
    
    }

    fun addUserToGroup(groupId: Long, userId: Long): Group {
    
        val user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        group.addUser(user)
        return group

    }
    
    fun removeUserFromGroup(groupId: Long, userId: Long): Group {
    
        val user: User = userRepository.findById(userId).toNullable() ?: throw UserDoesNotExistException()
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        group.removeUser(user)
        return group

    }

}

