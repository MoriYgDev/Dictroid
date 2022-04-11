package ir.moris.dictroid.feature_dictionary.domain.repository

import ir.moris.dictroid.feature_dictionary.core.util.Resource
import ir.moris.dictroid.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>


}