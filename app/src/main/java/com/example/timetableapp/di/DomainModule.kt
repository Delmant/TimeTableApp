package com.example.timetableapp.di

import com.example.timetableapp.data.local_data_source.UserProfileRepositoryImpl
import com.example.timetableapp.data.repository_impl.TimetableRepositoryImpl
import com.example.timetableapp.domain.timetable.repository.TimetableRepository
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module

interface DomainModule {

    @Binds
    @Singleton
    fun bindUserProfileRepository(userProfileRepository: UserProfileRepositoryImpl): UserProfileRepository

    @Binds
    @Singleton
    fun bindTimetableRepository(impl: TimetableRepositoryImpl): TimetableRepository

}