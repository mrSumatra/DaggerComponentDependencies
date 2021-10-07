package dagger.components.di.component

import dagger.Component
import dagger.components.di.module.ColorModule
import dagger.components.di.scope.FragmentScope
import dagger.components.producer.FragmentProducer

@FragmentScope
@Component(modules = [ColorModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun injectFragmentProducer(fragment: FragmentProducer)

}