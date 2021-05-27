package edu.uw.vanessasgh.dotify.manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import edu.uw.vanessasgh.dotify.MainApplication

class SongSyncWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val application by lazy {context.applicationContext as MainApplication}
    private val songNotificationManager by lazy {application.notificationManager}

    override suspend fun doWork(): Result {

        Log.i("SongSyncWorker", "syncing songs now")
        songNotificationManager.publishNewSongNotification(SongDataProvider.getAllSongs().random())
        return Result.success()
    }
}