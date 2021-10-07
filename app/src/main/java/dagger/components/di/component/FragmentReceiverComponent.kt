package dagger.components.di.component

import dagger.Component
import dagger.components.di.scope.FragmentScope
import dagger.components.receiver.FragmentReceiver
import dagger.components.receiver.ViewModelModule

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [ViewModelModule::class])
interface FragmentReceiverComponent {

    fun injectFragmentReceiver(fragment: FragmentReceiver)

}