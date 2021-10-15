package com.react_forum.kotlincore.resolvers

import org.springframework.stereotype.Component
import com.graphql-java-kickstart.tools.GraphQLResolver
import com.react_forum.kotlincore.entities.Group
import com.react_forum.kotlincore.services.GroupService

@Component
class GroupResolver (private val groupService: GroupService): GraphQLResolver<Group> {
   

    //############################################################### 
    //#########################   Queries   #########################
    //############################################################### 
    
    fun groupsByUser(userId: Long): List<Group> {
        
    }


    //############################################################### 
    //########################   Mutations   ########################
    //############################################################### 

    fun createGroup(groupName: String): Group {
        
    }

    fun updateGroupName(groupId: Long, groupName: String): Group {
        
    }

    fun removeGroup(groupId: Long): Boolean {
        
    }

    fun addUserToGroup(groupId: Long, userID: Long): Group {
        
    }

    fun removeUserFromGroup(groupId: Long, userId: Long): Group {

    }

}
