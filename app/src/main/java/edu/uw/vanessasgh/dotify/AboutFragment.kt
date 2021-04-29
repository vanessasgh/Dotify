package edu.uw.vanessasgh.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.vanessasgh.dotify.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(inflater)
        with(binding) {
            val version = BuildConfig.VERSION_NAME
            versionTv.text = getString(R.string.versionText, version)
        }
        return binding.root
    }
}