package edu.uw.vanessasgh.dotify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ericchee.songdataprovider.Song
import edu.uw.vanessasgh.dotify.databinding.ActivitySettingsBinding

private const val SONG_KEY = "song"
private const val PLAY_KEY = "plays"

fun navigateToSettingsActivity(context: Context, song: Song, plays: Int) = with(context) {
    startActivity(Intent(this, SettingsActivity::class.java).apply {
        putExtra(SONG_KEY, song)
        putExtra(PLAY_KEY, plays)
    })
}

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private val navController by lazy {findNavController(R.id.navHost)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater).apply {setContentView(root)}

        with(binding) {
            navController.setGraph(R.navigation.nav_graph, intent.extras)
            setupActionBarWithNavController(navController)
        }

    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}