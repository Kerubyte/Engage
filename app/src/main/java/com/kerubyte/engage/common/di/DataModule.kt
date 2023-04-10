package com.kerubyte.engage.common.di

import com.kerubyte.engage.common.data.DatabaseInteractorImpl
import com.kerubyte.engage.common.data.ProductRepositoryImpl
import com.kerubyte.engage.common.domain.data.DatabaseInteractor
import com.kerubyte.engage.common.domain.data.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindDatabaseInteractor(
        databaseInteractorImpl: DatabaseInteractorImpl
    ) : DatabaseInteractor

    @Binds
    abstract fun bindProductRepository(
        productServiceImpl: ProductRepositoryImpl
    ) : ProductRepository
}