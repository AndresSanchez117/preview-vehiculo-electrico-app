package com.example.vehiculoelectricoexperiment

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.vehiculoelectricoexperiment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = binding.viewPager
//        viewPager.adapter = sectionsPagerAdapter
//
//        binding.tabs.setupWithViewPager(viewPager)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //setupActionBarWithNavController(navController)

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // nothing
                when (tab) {
                    binding.tabs.getTabAt(0) -> navController.navigate(R.id.placeholderFragment)
                    binding.tabs.getTabAt(1) -> navController.navigate(R.id.mapsFragment)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // nothing
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // nothing
            }
        })
    }
}