package com.parsimony.gamewiki.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "wiki_sections")
data class WikiSection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", columnDefinition = "TEXT")
    val content: String,

    @Column(name = "section_order", nullable = false)
    val sectionOrder: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wiki_page_id", nullable = false)
    val wikiPage: WikiPage,

    @OneToMany(mappedBy = "wikiSection", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val contributionLogs: MutableList<ContributionLog> = mutableListOf(),

    @OneToMany(mappedBy = "wikiSection", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val confirms: MutableList<Confirm> = mutableListOf(),

    @OneToMany(mappedBy = "wikiSection", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val deprecationReports: MutableList<DeprecationReport> = mutableListOf()
)