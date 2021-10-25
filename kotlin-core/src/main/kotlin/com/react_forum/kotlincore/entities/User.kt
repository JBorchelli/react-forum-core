package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import javax.persistence.JoinTable
import javax.persistence.JoinColumn
import javax.persistence.FetchType

@Entity
@Table(name="users")
class User(

    @Column(name="username")
    var username: String? = null,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "groups_users",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "group_id", referencedColumnName = "id")],
    )
    var groups: MutableSet<Group> = mutableSetOf(),

    @OneToMany(mappedBy = "user",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    var discussions: MutableSet<Discussion> = mutableSetOf(),
    
    @OneToMany(mappedBy = "user",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    var posts: MutableSet<Post> = mutableSetOf(),

): AbstractJpaEntity() {

    fun addGroup(group: Group): Boolean {
       return groups.add(group)
    }

    fun removeGroup(groupId: Long): Boolean {
        val groupToRemove: Group = groups.find{group -> group.getId() == groupId} ?: return false
        return groups.remove(groupToRemove)
    }

    fun removeGroup(group: Group): Boolean {
        return groups.remove(group)
    }

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

    fun addPost(post: Post): Boolean {
        return posts.add(post)
    }

    fun removePost(postId: Long): Boolean {
        val postToRemove: Post = posts.find{post -> post.getId() == postId} ?: return false
        return posts.remove(postToRemove)
    }

    fun removePost(post: Post): Boolean {
        return this.posts.remove(post)
    }

}

