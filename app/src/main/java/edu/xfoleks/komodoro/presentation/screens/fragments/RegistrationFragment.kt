package edu.xfoleks.komodoro.presentation.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.databinding.FragmentRegistrationBinding
import edu.xfoleks.komodoro.presentation.screens.viewmodels.RegistrationViewModel

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        with(binding) {
            userName.doOnTextChanged { text, _, _, _ ->
                if (text?.isEmpty() == true) {
                    textInputLayoutUserName.error = "This field is required!!"
                }
            }
            password.doOnTextChanged { text, _, _, _ ->
                if (text?.isEmpty() == true) {
                    textInputLayoutUserName.error = "This field is required!!"
                }
            }
        }

        binding.registrationButton.setOnClickListener {
            with(binding) {
                context?.let { context ->
                    viewModel.registerUser(
                        context,
                        userName.text.toString(),
                        password.text.toString()
                        )
                }
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}