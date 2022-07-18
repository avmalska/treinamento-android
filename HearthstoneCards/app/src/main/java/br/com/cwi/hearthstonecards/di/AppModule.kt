package br.com.cwi.hearthstonecards.di

import org.koin.core.module.Module

val appModules : List<Module> = listOf(dataModule, presentationModule)