package edu.uw.vanessasgh.dotify

import android.app.Application
import edu.uw.vanessasgh.dotify.repository.DataRepository

class ProfileApplication: Application() {
    lateinit var dataRepository: DataRepository

    override fun onCreate() {
        super.onCreate()
        dataRepository = DataRepository()
    }
}