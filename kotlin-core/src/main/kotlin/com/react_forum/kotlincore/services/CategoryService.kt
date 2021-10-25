package com.react_forum.kotlincore.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.react_forum.kotlincore.entities.Category
import com.react_forum.kotlincore.entities.Group
import com.react_forum.kotlincore.entities.Discussion
import com.react_forum.kotlincore.toNullable
import com.react_forum.kotlincore.data_access.CategoryRepository
import com.react_forum.kotlincore.data_access.GroupRepository
import com.react_forum.kotlincore.exceptions.CategoryDoesNotExistException
import com.react_forum.kotlincore.exceptions.GroupDoesNotExistException

@Service
@Transactional
class CategoryService(private val categoryRepository: CategoryRepository, private val groupRepository: GroupRepository) {

    fun getCategoriesByGroup(groupId: Long): List<Category> {
        
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        return categoryRepository.findByGroup(group).toList()     
    
    }

    fun createCategory(categoryTitle: String, groupId: Long): Category {
        
        val group: Group = groupRepository.findById(groupId).toNullable() ?: throw GroupDoesNotExistException()
        var category: Category = Category()
        category.title = categoryTitle
        category.group = group
        return categoryRepository.save(category)
    
    }

    fun updateCategoryTitle(categoryId: Long, categoryTitle: String): Category {
    
        var updateCategory: Category = categoryRepository.findById(categoryId).toNullable() ?: throw CategoryDoesNotExistException()
        updateCategory.title = categoryTitle
        return updateCategory
    
    }

    fun removeCategory(categoryId: Long): Boolean {
        
        categoryRepository.deleteById(categoryId)
        return !categoryRepository.existsById(categoryId)
    
    }
}

