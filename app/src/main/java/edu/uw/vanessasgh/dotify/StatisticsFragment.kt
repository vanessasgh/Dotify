package edu.uw.vanessasgh.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import edu.uw.vanessasgh.dotify.databinding.FragmentStatisticsBinding


class StatisticsFragment : Fragment() {
    private val safeArgs: StatisticsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentStatisticsBinding.inflate(inflater)
        val plays = safeArgs.plays
        val song = safeArgs.song
        val albumPicID = song.largeImageID

        with(binding) {
            statsTv.text = getString(R.string.statsText, plays)
            albumPicSetting.setImageResource(albumPicID)
        }

        return binding.root
    }

}