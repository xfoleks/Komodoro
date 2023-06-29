package edu.xfoleks.komodoro.presentation.screens.activities.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.xfoleks.komodoro.R
import edu.xfoleks.komodoro.databinding.ActivityHomeBinding

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private  lateinit var homeNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeNavHost = supportFragmentManager
            .findFragmentById(R.id.homeFragmentContainer) as NavHostFragment

        homeNavController = homeNavHost.navController

        setupWithNavController(binding.bottomNavView, homeNavController)

    }
}