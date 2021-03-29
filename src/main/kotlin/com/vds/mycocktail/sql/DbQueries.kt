package com.vds.mycocktail.sql

object DbQueries {
    const val FIND_ALL_INGREDIENTS_BY_TYPE_ORDER_BY_NAME =
        "SELECT * FROM ingredient WHERE type_ingredient = ?1 ORDER BY nom_ingredient"

    const val FIND_COCKTAILS_CONTAINING_THESE_INGREDIENTS =
        "SELECT DISTINCT C.* FROM composer O JOIN ingredient I ON O.id_ingredient = I.id_ingredient " +
        "JOIN cocktail C ON C.id_cocktail = O.id_cocktail WHERE O.id_ingredient IN ?1 " +
        "GROUP BY C.id_cocktail HAVING COUNT (DISTINCT O.id_ingredient) = ?2"
}