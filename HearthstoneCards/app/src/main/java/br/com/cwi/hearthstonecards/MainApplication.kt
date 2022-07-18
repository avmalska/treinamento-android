package br.com.cwi.hearthstonecards

import android.app.Application
import br.com.cwi.hearthstonecards.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Iniciar koin
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(appModules)
        }
    }
}