package edu.xfoleks.komodoro.presentation.screens.fragments.onboatding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.FragmentOnboardingWelcomeBinding
import edu.xfoleks.komodoro.presentation.screens.viewmodels.OnBoardingViewModel

@AndroidEntryPoint
class OnboardingWelcomeFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingWelcomeBinding

    private val viewModel: OnBoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingWelcomeBinding.inflate(inflater, container, false)

        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.navigateToRegistrationFromOnBoarding)
            context?.let { context ->
                viewModel.saveOnBoardingProgress(context, true)
            }
        }

        return binding.root
    }
}