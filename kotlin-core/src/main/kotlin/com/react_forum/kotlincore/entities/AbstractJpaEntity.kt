package com.react_forum.kotlincore.entities

import org.springframework.data.util.ProxyUtils
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.MappedSuperclass

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter

@MappedSuperclass
abstract class AbstractJpaEntity {

    companion object {
        private val serialVersionUID: Long = -7656554325787898
    }

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "pooled-lo"
    )
    @GenericGenerator(
        name = "pooled-lo",
        strategy = "sequence",
        parameters = [
            Parameter(name = "sequence_name", value = "post_sequence"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1"),
            Parameter(name = "optimizer", value = "pooled-lo")
        ]
    )
    @Column(name = "id")
    private var id: Int? = null

    fun getId(): Int? {
        return id
    }

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if(javaClass != ProxyUtils.getUserClass(other)) return false

        other as AbstractJpaEntity

        if (this.getId() == null) return false
        return this.getId() == other.getId()

    }

    override fun hashCode(): Int {
        return this.getId() ?: 0
    }

    override fun toString(): String {
        return "${javaClass.name}(id: ${this.getId()})"
    }

}