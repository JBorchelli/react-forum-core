package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.react_forum.kotlincore.entities.Group
import com.react_forum.kotlincore.entities.Category

/**
 * JPA data repository for the Category entity.
 */
@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
    
    fun findByGroup(group: Group): Iterable<Category>
    
}
