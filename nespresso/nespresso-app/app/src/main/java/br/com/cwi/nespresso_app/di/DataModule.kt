package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.mapper.CategoryAccessoryMapper
import br.com.cwi.nespresso_app.data.mapper.CategoryCoffeeMapper
import br.com.cwi.nespresso_app.data.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.network.RetrofitConfig
import br.com.cwi.nespresso_app.data.repository.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CategoryCoffeeMapper() }
    single { CategoryAccessoryMapper() }
    single { MachineMapper() }

    factory<CoffeeRepository> { CoffeeRepositoryImpl(get(), get(), get(), get()) }
}