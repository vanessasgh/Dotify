package edu.uw.vanessasgh.dotify

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ericchee.songdataprovider.Song
import edu.uw.vanessasgh.dotify.databinding.ItemSongBinding

class SongListAdapter(private var listOfSongs: List<Song>): RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {

    public var onSongClicklistener: (song: Song) -> Unit = {_ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context))
        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfSongs.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = listOfSongs[position]
        with(holder.binding) {
            tvSongName.text = song.title
            tvSongArtist.text = song.artist
            ivSongImage.setImageResource(song.smallImageID)

            itemRoot.setOnClickListener {
                onSongClicklistener(song)
            }
        }
    }

    fun updateSongList(newListOfSongs: List<Song>) {
        this.listOfSongs = newListOfSongs
        notifyDataSetChanged()
    }

    class SongViewHolder(val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root)
}