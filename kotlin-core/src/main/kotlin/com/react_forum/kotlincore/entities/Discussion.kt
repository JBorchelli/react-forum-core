package com.react_forum.kotlincore.entities

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.CascadeType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.JoinColumn

@Entity
@Table(name="discussions")
class Discussion(

    @Column(name="heading")
    var heading: String? = null,

    @Column(name="sub")
    var sub: String? = null,

    @JoinColumn(name="category_id")
    @ManyToOne
    var category: Category? = null,

    @JoinColumn(name="user_id")
    @ManyToOne
    var user: User? = null,
    
    @OneToMany(mappedBy ="discussion", cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
    var posts: MutableSet<Post> = mutableSetOf(),

): AbstractJpaEntity() {

    
    fun addPost(post: Post): Boolean {
        return posts.add(post)
    }

    fun removePost(postId: Long): Boolean {

        val postToRemove: Post = posts.find{post -> post.getId() == postId} ?: return false
        return posts.remove(postToRemove)
    }

    fun removePost(post: Post): Boolean {
        return posts.remove(post)
    }


}

