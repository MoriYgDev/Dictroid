package ir.moris.dictroid.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.moris.dictroid.feature_dictionary.domain.model.Meaning
import ir.moris.dictroid.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String ,
    @PrimaryKey val id : Int? = null
){
    fun toWordInfo():WordInfo{
        return WordInfo(meanings, origin, phonetic, word)
    }
}
