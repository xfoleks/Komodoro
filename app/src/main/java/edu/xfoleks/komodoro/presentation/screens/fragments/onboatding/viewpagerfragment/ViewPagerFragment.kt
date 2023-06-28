package edu.xfoleks.komodoro.presentation.screens.fragments.onboatding.viewpagerfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.databinding.FragmentViewpagerBinding
import edu.xfoleks.komodoro.presentation.screens.fragments.onboatding.OnboardingBalanceFragment
import edu.xfoleks.komodoro.presentation.screens.fragments.onboatding.OnboardingTasksFragment
import edu.xfoleks.komodoro.presentation.screens.fragments.onboatding.OnboardingWelcomeFragment
import edu.xfoleks.komodoro.presentation.ui.viewpager.ViewPagerAdapter


@AndroidEntryPoint
class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewpagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewpagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(

            OnboardingTasksFragment(),
            OnboardingBalanceFragment(),
            OnboardingWelcomeFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }
}