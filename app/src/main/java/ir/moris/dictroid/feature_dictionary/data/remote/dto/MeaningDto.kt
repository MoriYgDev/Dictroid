package ir.moris.dictroid.feature_dictionary.data.remote.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
)