package com.react_forum.kotlincore.resolvers

import org.springframework.stereotype.Component
import com.graphql-java-kickstart.tools.GraphQLResolver
import com.react_forum.kotlincore.entities.User
import com.react_forum.kotlincore.services.UserService

@Component
class UserResolver (private val userService: UserService): GraphQLResolver<User> {
   

    //############################################################### 
    //#########################   Queries   #########################
    //############################################################### 
    
    fun usersByGroup(groupId: Long): List<User> {
        
    }


    //############################################################### 
    //########################   Mutations   ########################
    //############################################################### 
    
    fun createUser(username: String): User {

    }

    fun updateUsername(userId: Long, username: String): User {

    }

    fun removeUser(userId: Long): Boolean {

    }

}
