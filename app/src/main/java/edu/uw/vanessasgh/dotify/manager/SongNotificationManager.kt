package edu.uw.vanessasgh.dotify.manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ericchee.songdataprovider.Song
import edu.uw.vanessasgh.dotify.MainActivity
import edu.uw.vanessasgh.dotify.R
import kotlin.random.Random

private const val NEW_SONG_CHANNEL_ID = "NEW_SONG_CHANNEL_ID"
private const val SONG_KEY="song"

class SongNotificationManager(
    private val context: Context
) {
    private val notificationManager = NotificationManagerCompat.from(context)

    init {
        initNotificationChannels()
    }

    fun publishNewSongNotification(song: Song) {
        val intent = Intent(context, MainActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(SONG_KEY, song)
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val title = context.getString(R.string.title_notif, song.artist)
        val desc = context.getString(R.string.desc_notif, song.title)

        var builder = NotificationCompat.Builder(context, NEW_SONG_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_music_library)
            .setContentTitle(title)
            .setContentText(desc)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(notificationManager) {
            val notificationId = Random.nextInt()
            notify(notificationId, builder.build())
        }


    }

    private fun initNotificationChannels() {
        initNewSongsChannel()
//        initPromotionChannel()
    }

    private fun initNewSongsChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.new_songs)
            val descriptionText = context.getString(R.string.new_songs_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NEW_SONG_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            notificationManager.createNotificationChannel(channel)
        }
    }

//    private fun initPromotionChannel() {
//
//    }
}