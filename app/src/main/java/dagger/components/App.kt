package dagger.components

import android.app.Application
import dagger.components.di.component.ApplicationComponent
import dagger.components.di.component.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .context(this)
            .build()
    }
}