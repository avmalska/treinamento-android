package br.com.cwi.hearthstonecards.di

import br.com.cwi.hearthstonecards.data.database.AppDatabase
import br.com.cwi.hearthstonecards.data.network.RetrofitConfig
import br.com.cwi.hearthstonecards.data.network.mapper.CardMapper
import br.com.cwi.hearthstonecards.data.network.mapper.InfoMapper
import br.com.cwi.hearthstonecards.data.repository.HearthstoneLocalRepositoryImpl
import br.com.cwi.hearthstonecards.data.repository.HearthstoneRepositoryImpl
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneLocalRepository
import br.com.cwi.hearthstonecards.domain.repository.HearthstoneRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.hearthstoneService }

    single { InfoMapper() }
    single { CardMapper() }
    single { AppDatabase.create(androidApplication()) }

    factory<HearthstoneRepository> { HearthstoneRepositoryImpl(get(), get(), get()) }
    factory<HearthstoneLocalRepository> { HearthstoneLocalRepositoryImpl(get()) }

}