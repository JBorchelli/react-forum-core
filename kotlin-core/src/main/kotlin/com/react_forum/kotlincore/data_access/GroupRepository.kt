package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.react_forum.kotlincore.entities.Group

/**
 * JPA data repository corresponding to the Group entity.
 */
@Repository
interface GroupRepository: JpaRepository<Group, Long> {

}