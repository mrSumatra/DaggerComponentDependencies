package dagger.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.components.di.component.DaggerMainActivityComponent
import dagger.components.di.component.MainActivityComponent
import dagger.components.producer.FragmentProducer
import dagger.components.receiver.FragmentReceiver

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val appComponent = (application as App).appComponent
        mainActivityComponent = DaggerMainActivityComponent.builder().activityContext(this)
            .applicationComponent(appComponent).build()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_receiver, FragmentReceiver())
            .commit()
    }
}