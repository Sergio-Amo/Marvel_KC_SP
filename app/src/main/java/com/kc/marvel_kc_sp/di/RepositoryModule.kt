package com.kc.marvel_kc_sp.di

import com.kc.marvel_kc_sp.data.RepositoryImpl
import com.kc.marvel_kc_sp.data.RepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): RepositoryInterface

}