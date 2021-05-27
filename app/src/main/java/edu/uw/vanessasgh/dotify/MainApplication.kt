package edu.uw.vanessasgh.dotify

import android.app.Application
import edu.uw.vanessasgh.dotify.manager.SongNotificationManager
import edu.uw.vanessasgh.dotify.manager.SongSyncManager
import edu.uw.vanessasgh.dotify.repository.DataRepository

class MainApplication: Application() {
    lateinit var dataRepository: DataRepository
    lateinit var songSyncManager: SongSyncManager
    lateinit var notificationManager: SongNotificationManager

    override fun onCreate() {
        super.onCreate()
        dataRepository = DataRepository()
        this.songSyncManager = SongSyncManager(this)
        this.notificationManager = SongNotificationManager(this)
    }
}