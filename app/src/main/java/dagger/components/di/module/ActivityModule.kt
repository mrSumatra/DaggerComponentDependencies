package dagger.components.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.components.di.scope.ActivityScope

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideEvent(): MutableLiveData<Int> {
        return MutableLiveData()
    }
}