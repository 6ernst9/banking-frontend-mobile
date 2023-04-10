package com.example.banking

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val addCardView : MaterialCardView = view.findViewById(R.id.addCardView) as MaterialCardView
        val headerConstraintLayout : ConstraintLayout = view.findViewById(R.id.headerConstraint)
        val scrollView : ScrollView = view.findViewById(R.id.scrollView)
        var paddingTop : Int = headerConstraintLayout.paddingTop
        var paddingBottom : Int = headerConstraintLayout.paddingBottom
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY : Int = scrollView.scrollY
            println(scrollY)
            if(scrollY < (paddingTop / 3 * 2)){
                headerConstraintLayout.setPadding(headerConstraintLayout.paddingStart,
                    paddingTop - scrollY,
                    headerConstraintLayout.paddingEnd,
                    paddingBottom - scrollY)
                headerConstraintLayout.outlineProvider = null
            } else if(scrollY >= (paddingTop / 3 * 2) && scrollY < paddingTop * 4 / 3){
                headerConstraintLayout.setPadding(headerConstraintLayout.paddingStart,
                    paddingTop/3,
                    headerConstraintLayout.paddingEnd,
                    paddingBottom /3)
                headerConstraintLayout.outlineProvider = null
            }
            else{
                headerConstraintLayout.setPadding(headerConstraintLayout.paddingStart,
                    paddingTop/3,
                    headerConstraintLayout.paddingEnd,
                    paddingBottom /3)
                headerConstraintLayout.outlineProvider = ViewOutlineProvider.BACKGROUND
            }
        }

        addCardView.setOnClickListener{
            val intent  = Intent (this.activity, OpenNewAccount::class.java);
            activity?.startActivity(intent);
        }
        return view;
    }


}