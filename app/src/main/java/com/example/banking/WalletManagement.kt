package com.example.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.banking.R

class WalletManagement : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wallet_management, container, false)
        val manageWalletManagement : ConstraintLayout = view.findViewById(R.id.manageWalletManagement)
        val scrollView : ScrollView = view.findViewById(R.id.scrollView)
        var paddingTop : Int = manageWalletManagement.paddingTop
        var paddingBottom : Int = manageWalletManagement.paddingBottom
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY : Int = scrollView.scrollY
            println(scrollY)
            if(scrollY < (paddingTop / 3 * 2)){
                manageWalletManagement.setPadding(manageWalletManagement.paddingStart,
                    paddingTop - scrollY,
                    manageWalletManagement.paddingEnd,
                    paddingBottom - scrollY)
                manageWalletManagement.outlineProvider = null
            } else if(scrollY >= (paddingTop / 3 * 2) && scrollY < paddingTop * 4 / 3){
                manageWalletManagement.setPadding(manageWalletManagement.paddingStart,
                    paddingTop/3,
                    manageWalletManagement.paddingEnd,
                    paddingBottom /3)
                manageWalletManagement.outlineProvider = null
            }
            else{
                manageWalletManagement.setPadding(manageWalletManagement.paddingStart,
                    paddingTop/3,
                    manageWalletManagement.paddingEnd,
                    paddingBottom /3)
                manageWalletManagement.outlineProvider = ViewOutlineProvider.BACKGROUND
            }
        }
        return view;
    }
}