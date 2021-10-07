package dagger.components.di.module

import dagger.Module
import dagger.Provides
import dagger.components.ColorGenerator
import dagger.components.ColorGeneratorImpl
import dagger.components.di.scope.FragmentScope

@Module
class ColorModule {

    @Provides
    @FragmentScope
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}