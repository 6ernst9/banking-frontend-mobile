package com.example.banking

import android.graphics.Color
import android.media.Image
import android.os.Build
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.banking.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.card.MaterialCardView

class MenuActivity : AppCompatActivity() {
    private var selectedTab : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val homeIcon : ImageView = findViewById(R.id.homeIcon)
        val walletIcon : ImageView = findViewById(R.id.walletIcon)
        val addIcon : ImageView = findViewById(R.id.addIcon)
        val transactionIcon : ImageView = findViewById(R.id.transactionIcon)
        val reportIcon : ImageView = findViewById(R.id.reportIcon)
        val homeTitle : TextView = findViewById(R.id.homeTextTitle)
        val walletTitle : TextView = findViewById(R.id.walletTextTitle)
        val addTitle : TextView = findViewById(R.id.addTextTitle)
        val reportTitle : TextView = findViewById(R.id.reportTextTitle)
        val transactionTitle : TextView = findViewById(R.id.transactionTextTitle)
        val homeBar : MaterialCardView = findViewById(R.id.homeBar)
        val walletBar : MaterialCardView = findViewById(R.id.walletBar)
        val addBar : MaterialCardView = findViewById(R.id.addBar)
        val transactionBar : MaterialCardView = findViewById(R.id.transactionBar)
        val reportBar : MaterialCardView = findViewById(R.id.reportBar)
        val homeLayout : ConstraintLayout = findViewById(R.id.homeLayout)
        val walletLayout : ConstraintLayout = findViewById(R.id.walletLayout)
        val addLayout : ConstraintLayout = findViewById(R.id.addLayout)
        val transactionLayout : ConstraintLayout = findViewById(R.id.transactionLayout)
        val reportLayout : ConstraintLayout = findViewById(R.id.reportLayout)
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainerView, HomeFragment::class.java, null)
            .commit()
        homeLayout.setOnClickListener{
            if(selectedTab!=1){
                walletIcon.visibility = View.VISIBLE
                addIcon.visibility = View.VISIBLE
                transactionIcon.visibility = View.VISIBLE
                reportIcon.visibility = View.VISIBLE

                walletBar.visibility = View.GONE
                addBar.visibility = View.GONE
                transactionBar.visibility = View.GONE
                reportBar.visibility = View.GONE

                walletTitle.visibility = View.GONE
                addTitle.visibility = View.GONE
                transactionTitle.visibility = View.GONE
                reportTitle.visibility = View.GONE

                homeIcon.visibility = View.GONE
                homeBar.visibility = View.VISIBLE
                homeTitle.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, HomeFragment::class.java, null)
                    .commit()
                selectedTab = 1;
            }
        }
        walletLayout.setOnClickListener{
            if(selectedTab!=2){
                homeIcon.visibility = View.VISIBLE
                addIcon.visibility = View.VISIBLE
                transactionIcon.visibility = View.VISIBLE
                reportIcon.visibility = View.VISIBLE

                homeBar.visibility = View.GONE
                addBar.visibility = View.GONE
                transactionBar.visibility = View.GONE
                reportBar.visibility = View.GONE

                homeTitle.visibility = View.GONE
                addTitle.visibility = View.GONE
                transactionTitle.visibility = View.GONE
                reportTitle.visibility = View.GONE

                walletIcon.visibility = View.GONE
                walletBar.visibility = View.VISIBLE
                walletTitle.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, WalletManagement::class.java, null)
                    .commit()
                selectedTab = 2
            }
        }
        addLayout.setOnClickListener{
            if(selectedTab!=3){
                homeIcon.visibility = View.VISIBLE
                walletIcon.visibility = View.VISIBLE
                transactionIcon.visibility = View.VISIBLE
                reportIcon.visibility = View.VISIBLE

                homeBar.visibility = View.GONE
                walletBar.visibility = View.GONE
                transactionBar.visibility = View.GONE
                reportBar.visibility = View.GONE

                homeTitle.visibility = View.GONE
                walletTitle.visibility = View.GONE
                transactionTitle.visibility = View.GONE
                reportTitle.visibility = View.GONE

                addIcon.visibility = View.GONE
                addBar.visibility = View.VISIBLE
                addTitle.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, AddTransaction::class.java, null)
                    .commit()
                selectedTab = 3
            }
        }
        transactionLayout.setOnClickListener{
            if(selectedTab!=4){
                homeIcon.visibility = View.VISIBLE
                walletIcon.visibility = View.VISIBLE
                addIcon.visibility = View.VISIBLE
                reportIcon.visibility = View.VISIBLE

                homeBar.visibility = View.GONE
                walletBar.visibility = View.GONE
                addBar.visibility = View.GONE
                reportBar.visibility = View.GONE

                homeTitle.visibility = View.GONE
                walletTitle.visibility = View.GONE
                addTitle.visibility = View.GONE
                reportTitle.visibility = View.GONE

                transactionIcon.visibility = View.GONE
                transactionBar.visibility = View.VISIBLE
                transactionTitle.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, TransactionFragment::class.java, null)
                    .commit()
                selectedTab = 4
            }
        }
        reportLayout.setOnClickListener{
            if(selectedTab!=5){
                homeIcon.visibility = View.VISIBLE
                walletIcon.visibility = View.VISIBLE
                addIcon.visibility = View.VISIBLE
                transactionIcon.visibility = View.VISIBLE

                homeBar.visibility = View.GONE
                walletBar.visibility = View.GONE
                addBar.visibility = View.GONE
                transactionBar.visibility = View.GONE

                homeTitle.visibility = View.GONE
                walletTitle.visibility = View.GONE
                addTitle.visibility = View.GONE
                transactionTitle.visibility = View.GONE

                reportIcon.visibility = View.GONE
                reportBar.visibility = View.VISIBLE
                reportTitle.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, ReportFragment::class.java, null)
                    .commit()
                selectedTab = 5
            }
        }
    }
    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}