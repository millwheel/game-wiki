package com.parsimony.gamewiki.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "guides")
data class Guide(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    val content: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "guide_patch_note_tags",
        joinColumns = [JoinColumn(name = "guide_id")],
        inverseJoinColumns = [JoinColumn(name = "patch_note_tag_id")]
    )
    val patchNoteTags: MutableSet<PatchNoteTag> = mutableSetOf(),

    @OneToMany(mappedBy = "guide", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val confirms: MutableList<Confirm> = mutableListOf()
)
