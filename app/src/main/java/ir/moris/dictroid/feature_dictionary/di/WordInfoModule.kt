package ir.moris.dictroid.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.moris.dictroid.feature_dictionary.data.local.WordInfoDao
import ir.moris.dictroid.feature_dictionary.data.local.WordInfoDatabase
import ir.moris.dictroid.feature_dictionary.data.remote.DictionaryApi
import ir.moris.dictroid.feature_dictionary.data.repository.WordInfoRepositoryImpl
import ir.moris.dictroid.feature_dictionary.data.util.GsonParser
import ir.moris.dictroid.feature_dictionary.domain.repository.WordInfoRepository
import ir.moris.dictroid.feature_dictionary.domain.use_cases.GetWordInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(GsonParser(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder().baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

}