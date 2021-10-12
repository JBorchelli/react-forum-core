package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.react_forum.kotlincore.entities.User

/**
 * JPA data repository for the User entity.
 */
@Repository
interface UserRepository: JpaRepository<User, Long> {

}