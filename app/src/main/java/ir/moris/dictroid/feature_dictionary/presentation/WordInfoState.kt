package ir.moris.dictroid.feature_dictionary.presentation

import ir.moris.dictroid.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItem: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)