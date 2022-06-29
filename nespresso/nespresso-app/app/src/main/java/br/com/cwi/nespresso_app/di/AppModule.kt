package br.com.cwi.nespresso_app.di

import org.koin.core.module.Module

val appModules : List<Module> = listOf(dataModule, presentationModule)