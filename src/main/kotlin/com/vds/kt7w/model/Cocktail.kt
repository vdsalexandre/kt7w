package com.vds.kt7w.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
data class Cocktail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cocktail")
    val idCocktail: Long,
    val nomCocktail: String,
    val recetteCocktail: String,
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "composer",
        joinColumns = [JoinColumn(name = "id_cocktail", referencedColumnName = "id_cocktail",
            nullable = false, updatable = false)],
        inverseJoinColumns = [JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient",
            nullable = false, updatable = false)])
    @JsonIgnoreProperties("cocktails") // to avoid recursive loop
    val ingredients: List<Ingredient> = mutableListOf())