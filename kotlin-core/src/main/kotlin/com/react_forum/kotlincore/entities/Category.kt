package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

@Entity
@Table(name="categories")
class Category(

    @Column(name="title")
    var title: String? = null,

    @JoinColumn(name="group_id")
    @ManyToOne
    var group: Group? = null,

    @OneToMany(mappedBy = "category",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true
    )
    var discussions: MutableSet<Discussion> = mutableSetOf(),

): AbstractJpaEntity() {

    fun addDiscussion(discussion: Discussion): Boolean {
        return discussions.add(discussion)
    }

    fun removeDiscussion(discussionId: Long): Boolean {
        val discussionToRemove: Discussion = discussions.find{discussion -> discussion.getId() == discussionId} ?: return false
        return discussions.remove(discussionToRemove)
    }

    fun removeDiscussion(discussion: Discussion): Boolean {
        return discussions.remove(discussion)
    }

}


