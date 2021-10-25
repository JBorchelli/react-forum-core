package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query

import com.react_forum.kotlincore.entities.User

/**
 * JPA data repository for the User entity.
 */
@Repository
interface UserRepository: JpaRepository<User, Long> {

    @Query(value = "SELECT u.id, u.username FROM users u INNER JOIN users_groups ug ON u.id = ug.user_id WHERE ug.group_id = ?1", nativeQuery = true)
    fun findByGroupId(groupId: Long): Iterable<User>
}
