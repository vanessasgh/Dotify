package edu.uw.vanessasgh.dotify

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import edu.uw.vanessasgh.dotify.databinding.FragmentNotificationBinding
import edu.uw.vanessasgh.dotify.manager.SongNotificationManager
import edu.uw.vanessasgh.dotify.manager.SongSyncManager


class NotificationFragment : Fragment() {
    private lateinit var mainApp: MainApplication
    private val songSyncManager: SongSyncManager by lazy{mainApp.songSyncManager}
//    private val songNotificationManager: SongNotificationManager by lazy {mainApp.notificationManager}

    override fun onAttach(context: Context) {
        this.mainApp = context.applicationContext as MainApplication
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationBinding.inflate(inflater)
        with(binding) {

            notificationSwitch.isChecked = songSyncManager.isSongSyncRunning()

            notificationSwitch.setOnCheckedChangeListener{buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(mainApp, "Notification has been turned on", Toast.LENGTH_SHORT).show()
                    songSyncManager.syncSongsPeriodically()
//                    songSyncManager.syncSongs()
                } else {
                    Toast.makeText(mainApp, "Notification has been stopped", Toast.LENGTH_SHORT).show()
                    songSyncManager.stopPeriodicallySyncing()
                }
            }
        }
        return binding.root
    }
}