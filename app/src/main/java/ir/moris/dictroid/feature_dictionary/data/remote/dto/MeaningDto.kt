package ir.moris.dictroid.feature_dictionary.data.remote.dto

import ir.moris.dictroid.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning {
        return Meaning(definitions.map { it.toDefinition() }, partOfSpeech)
    }
}