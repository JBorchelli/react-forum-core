package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query
import com.react_forum.kotlincore.entities.Group

/**
 * JPA data repository corresponding to the Group entity.
 */
@Repository
interface GroupRepository: JpaRepository<Group, Long> {

    @Query("SELECT g.id, g.group_name FROM groups g INNER JOIN users_groups ug ON g.id = ug.group_id WHERE ug.user_id = ?1", nativeQuery = true)
    fun findByUserId(userId: Long): Iterable<Group>

    
}
