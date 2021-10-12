package com.react_forum.kotlincore.data_access

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.react_forum.kotlincore.entities.Discussion

/**
 * JPA data repository for the Discussion entity.
 */
@Repository
interface DiscussionRepository: JpaRepository<Discussion, Long> {

}