package ru.itmo.medicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.itmo.medicalapp.home.HomeFragment
import ru.itmo.medicalapp.patients.PatientsFragment
import ru.itmo.medicalapp.profile.ProfileFragment
import ru.itmo.medicalapp.tasks.TasksFragment

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            actionBar?.title = item.title
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.tasks -> {
                    loadFragment(TasksFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.patients -> {
                    loadFragment(PatientsFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        setToolbar()
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.selectedItemId = R.id.home
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun setToolbar() {
        setActionBar(findViewById(R.id.my_toolbar))
        actionBar?.title = resources.getString(R.string.home)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
