package ir.moris.dictroid.feature_dictionary.data.remote.dto

import ir.moris.dictroid.feature_dictionary.data.local.entity.WordInfoEntity
import ir.moris.dictroid.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWordInfoEntity():WordInfoEntity{
        return WordInfoEntity(meanings.map { it.toMeaning() }, origin, phonetic, word)
    }

}