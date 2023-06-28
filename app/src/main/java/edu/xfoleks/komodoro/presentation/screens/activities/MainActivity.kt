package edu.xfoleks.komodoro.presentation.screens.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.ActivityMainBinding
import edu.xfoleks.komodoro.presentation.screens.viewmodels.SplashScreenViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                return@setKeepOnScreenCondition viewModel.onBoardingStatus.value == true
            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHost.navController

        val condition = viewModel.onBoardingStatus.value

        if (condition == true) {
            navController.graph.setStartDestination(R.id.registrationFragment)
        } else {
            navController.graph.setStartDestination(R.id.viewPagerFragment)
        }

    }
}