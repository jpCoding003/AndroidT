package com.tops.tutorialapp

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.window.SplashScreen
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.tops.tutorialapp.Fragments.LoginFragment
import com.tops.tutorialapp.databinding.ActivityDashboardDawerBinding

class DashboardDawer : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDashboardDawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardDawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDashboardDawer.toolbar)

        binding.appBarDashboardDawer.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard_dawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_vendors, R.id.nav_customer, R.id.nav_product
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(
                menu: Menu,
                menuInflater: MenuInflater
            ) {
                menu.clear()
                menuInflater.inflate(R.menu.dashboard_dawer, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                if (menuItem.itemId == R.id.action_logout) {
                    val sharePref= getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE) ?: return false
                    with(sharePref.edit()) {
                        putBoolean(IS_Login, false)
                        apply()
                    }
                    val intent = Intent(applicationContext, SplashScreenActivity::class.java)
                    startActivity(intent)
                    return true
                }
                return false
            }
        },this, Lifecycle.State.RESUMED)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dashboard_dawer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}