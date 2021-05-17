package edu.uw.vanessasgh.dotify

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import edu.uw.vanessasgh.dotify.databinding.FragmentProfileBinding
import edu.uw.vanessasgh.dotify.model.Profile
import kotlinx.coroutines.launch
import java.net.URL

class ProfileFragment : Fragment() {
    private lateinit var profileApp: ProfileApplication
    private val dataRepository by lazy { profileApp.dataRepository}

    override fun onAttach(context: Context) {
        this.profileApp = context.applicationContext as ProfileApplication
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater)
        with(binding) {
            lifecycleScope.launch {
                val userInfo = dataRepository.getUserInfo()
                binding.fullnameTv.text = getString(R.string.fullname, userInfo.firstname, userInfo.lastname)
                binding.userNameTv.text = userInfo.username
            }
        }
        return binding.root
    }

}