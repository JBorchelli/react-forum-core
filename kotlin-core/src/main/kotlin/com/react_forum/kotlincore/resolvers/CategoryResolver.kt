package com.react_forum.kotlincore.resolvers

import org.springframework.stereotype.Component
import com.graphql-java-kickstart.tools.GraphQLResolver
import com.react_forum.kotlincore.entities.Category
import com.react_forum.kotlincore.services.CategoryService

@Component
class CategoryResolver (private val categoryService: CategoryService): GraphQLResolver<Category> {
   

    //############################################################### 
    //#########################   Queries   #########################
    //############################################################### 
    
    fun categoriesByGroup(groupId: Long): List<Category> {
        
    }


    //############################################################### 
    //########################   Mutations   ########################
    //############################################################### 
    
    fun createCategory(categoryTitle: String, groupId: Long): Category {

    }

    fun updateCategoryTitle(categoryId: Long, categoryTitle: String): Category {
        
    }

    fun removeCategory(categoryId: Long): Boolean {

    }

}

