package com.saqeeb.emvassignment.di

import android.content.Context
import androidx.room.Room
import com.saqeeb.emvassignment.db.AppDatabase
import com.saqeeb.emvassignment.db.dao.TagInfoDao
import com.saqeeb.emvassignment.db.dao.TlvDataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideTlvDao(appDatabase: AppDatabase): TlvDataDao {
        return appDatabase.tlvDataDao()
    }
    @Provides
    fun provideTagDao(appDatabase: AppDatabase): TagInfoDao {
        return appDatabase.tagInfoDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}