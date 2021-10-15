package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.react_forum.kotlincore.entities.Group

/**
 * JPA data repository corresponding to the Group entity.
 */
@Repository
interface GroupRepository: JpaRepository<Group, Long> {
    
    @Query(value = "SELECT g.id, g.group_name FROM groups g INNER JOIN users_groups ug ON g.id = ug.group_id WHERE ug.user_id = ?1", nativeQuery = true)
    findByUserId(userId: Long): Iterable<Group>
    
}
