package edu.xfoleks.komodoro.presentation.screens.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.FragmentRegistrationBinding
import edu.xfoleks.komodoro.presentation.screens.viewmodels.SharedViewModel

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    private lateinit var navController: NavController

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        navController = findNavController()

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
                        userName.text.toString(),
                        password.text.toString()
                    )

                    Toast.makeText(
                        context,
                        getString(R.string.registration_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.signInLink.setOnClickListener {
            findNavController().navigate(R.id.navigateToLogIn)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}