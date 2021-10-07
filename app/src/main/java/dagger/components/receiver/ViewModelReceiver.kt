package dagger.components.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver(
    private val context: Context,
    private val provideEvent: MutableLiveData<Int>
) : ViewModel() {

    val event = provideEvent

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}

class ViewModelReceiverFactory @Inject constructor(
    @Named("appContext") private val context: Context,
    private val provideEvent: MutableLiveData<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            return ViewModelReceiver(context, provideEvent) as T
        } else {
            throw java.lang.RuntimeException()
        }
    }

}

@Module
interface ViewModelModule {

    @Binds
    fun provideViewModel(arg: ViewModelReceiverFactory): ViewModelProvider.Factory

}