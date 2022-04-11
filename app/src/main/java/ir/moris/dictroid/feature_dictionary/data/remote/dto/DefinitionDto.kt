package ir.moris.dictroid.feature_dictionary.data.remote.dto

import ir.moris.dictroid.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){
    fun toDefinition() : Definition{
        return Definition(antonyms, definition, example, synonyms)
    }
}