package edu.uw.vanessasgh.dotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import edu.uw.vanessasgh.dotify.databinding.ActivitySongListBinding

class SongListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)
        this.title = "All Songs"
        binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            val songs : List<Song> = SongDataProvider.getAllSongs()
            val adapter = SongListAdapter(songs)
            rvSongs.adapter = adapter

            adapter.onSongClicklistener = { song ->
                tvMiniPlayer.text = root.context.getString(R.string.mini_player_text, song.title, song.artist)
                binding.miniPlayer.visibility = View.VISIBLE

                miniPlayer.setOnClickListener {
                    navigateToSongActivity(this@SongListActivity, song)
                }
            }

            shuffleBtn.setOnClickListener {
                rvSongs.adapter = adapter.apply {
                    adapter.updateSongList(songs.toMutableList().shuffled())
                }
            }
        }
    }
}