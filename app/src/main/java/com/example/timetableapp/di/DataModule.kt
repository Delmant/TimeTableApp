package com.example.timetableapp.di

import android.app.Application
import androidx.room.Room
import com.example.timetableapp.data.local_data_source.user_db.UserProfileDatabase
import com.example.timetableapp.data.remote_data_source.TimetableRemoteDataSource
import com.example.timetableapp.data.remote_data_source.TimetableRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideUserProfileDataBase(app: Application): UserProfileDatabase {
        return Room.databaseBuilder(
            app,
            UserProfileDatabase::class.java,
            UserProfileDatabase.USER_PROFILE_DATA_BASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTimetableRemoteDataSource(impl: TimetableRemoteDataSourceImpl): TimetableRemoteDataSource {
        return impl
    }
}