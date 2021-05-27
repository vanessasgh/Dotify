package edu.uw.vanessasgh.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.uw.vanessasgh.dotify.databinding.FragmentSettingsBinding



class SettingsFragment : Fragment() {
    private val navController by lazy {findNavController()}
    private val safeArgs: SettingsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(inflater)
        val receivedSong = safeArgs.song
        val receivedPlays = safeArgs.plays

        with(binding) {
            profileBtn.setOnClickListener {
                navController.navigate(R.id.profileFragment)
            }

            profileStatBtn.setOnClickListener {
                navController.navigate(SettingsFragmentDirections.actionSettingsFragmentToStatisticsFragment(receivedSong, receivedPlays))
            }

            aboutBtn.setOnClickListener {
                navController.navigate(R.id.aboutFragment)
            }

            notificationBtn.setOnClickListener {
                navController.navigate(R.id.notificationFragment)
            }
        }

        return binding.root
    }
}