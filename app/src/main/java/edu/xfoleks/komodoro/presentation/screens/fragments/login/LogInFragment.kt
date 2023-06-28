package edu.xfoleks.komodoro.presentation.screens.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.FragmentLoginBinding
import edu.xfoleks.komodoro.presentation.screens.viewmodels.SharedViewModel

@AndroidEntryPoint
class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)

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

        binding.loginButton.setOnClickListener {
            with(binding) {
                context?.let { context ->

                   val result =  viewModel.logIn(
                       userName.text.toString(),
                       password.text.toString()
                   )

                    if (result) {
                        Toast.makeText(
                            context,
                            getString(R.string.login_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else{
                        Toast.makeText(
                            context,
                            getString(R.string.login_error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding.signUpLink.setOnClickListener {
            findNavController().navigate(R.id.navigateToRegistration)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}