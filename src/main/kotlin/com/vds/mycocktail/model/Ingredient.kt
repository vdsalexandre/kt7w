package com.vds.mycocktail.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Ingredient(
    @Id @GeneratedValue @Column(name = "id_ingredient") val idIngredient: Long,
    val nomIngredient: String,
    val typeIngredient: String,
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("ingredients") // to avoid recursive loop
    val cocktails: List<Cocktail> = mutableListOf()
)