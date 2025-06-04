package com.parsimony.gamewiki.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "patch_note_tags")
data class PatchNoteTag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "tag_name", nullable = false, unique = true)
    val tagName: String,

    @ManyToMany(mappedBy = "patchNoteTags", fetch = FetchType.LAZY)
    val guides: MutableSet<Guide> = mutableSetOf()
)
