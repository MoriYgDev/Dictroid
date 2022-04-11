package ir.moris.dictroid.feature_dictionary.domain.use_cases

import ir.moris.dictroid.feature_dictionary.core.util.Resource
import ir.moris.dictroid.feature_dictionary.domain.model.WordInfo
import ir.moris.dictroid.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo (
    private val repository: WordInfoRepository
        ){

    operator fun invoke(word : String):Flow<Resource<List<WordInfo>>>{
        if (word.isBlank()){
            return flow {  }
        }
        return repository.getWordInfo(word)
    }

}