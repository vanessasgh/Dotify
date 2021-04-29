package edu.uw.vanessasgh.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import edu.uw.vanessasgh.dotify.databinding.ActivitySongListBinding

private const val SONG_KEY = "song"

class SongListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongListBinding
    var chosenSong: Song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "All Songs"
        binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            val songs : List<Song> = SongDataProvider.getAllSongs()
            val adapter = SongListAdapter(songs)

            rvSongs.adapter = adapter.apply {
                onSongClicklistener = { song ->
                    chosenSong = song
                    tvMiniPlayer.text = root.context.getString(R.string.mini_player_text, song.title, song.artist)
                    miniPlayer.visibility = View.VISIBLE

                }
            }

            miniPlayer.setOnClickListener {
                chosenSong?.let{ navigateToSongActivity(this@SongListActivity, it)}
            }

            shuffleBtn.setOnClickListener {
                rvSongs.adapter = adapter.apply {
                    adapter.updateSongList(songs.toMutableList().shuffled())
                }
            }

            if (savedInstanceState != null) {
                chosenSong = savedInstanceState.getParcelable(SONG_KEY)
                miniPlayer.visibility = View.VISIBLE
                tvMiniPlayer.text = root.context.getString(R.string.mini_player_text, chosenSong?.title, chosenSong?.artist)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(SONG_KEY, chosenSong)
        super.onSaveInstanceState(outState)
    }
}