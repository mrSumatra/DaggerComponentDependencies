package dagger.components.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.components.ColorGenerator
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    @Named("activityContext") private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val provideEvent: MutableLiveData<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        provideEvent.value = colorGenerator.generateColor()
    }
}