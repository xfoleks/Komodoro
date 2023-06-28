package edu.xfoleks.komodoro.presentation.screens.fragments.onboatding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.FragmentOnboardingBalanceBinding

@AndroidEntryPoint
class OnboardingBalanceFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBalanceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBalanceBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.btnNext.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return binding.root
    }
}