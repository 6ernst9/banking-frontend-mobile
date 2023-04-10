package com.example.banking

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.banking.R
import com.google.android.material.card.MaterialCardView

class AddTransaction : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_transaction, container, false)
        val newTransactionTitleHeader : ConstraintLayout = view.findViewById(R.id.newTransactionTitleHeader)
        val bankTransfer : MaterialCardView = view.findViewById(R.id.bankTransferCardview)
        val scrollView : ScrollView = view.findViewById(R.id.scrollView)
        var paddingTop : Int = newTransactionTitleHeader.paddingTop
        var paddingBottom : Int = newTransactionTitleHeader.paddingBottom
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY : Int = scrollView.scrollY
            println(scrollY)
            if(scrollY < (paddingTop / 3 * 2)){
                newTransactionTitleHeader.setPadding(newTransactionTitleHeader.paddingStart,
                    paddingTop - scrollY,
                    newTransactionTitleHeader.paddingEnd,
                    paddingBottom - scrollY)
                newTransactionTitleHeader.outlineProvider = null
            } else if(scrollY >= (paddingTop / 3 * 2) && scrollY < paddingTop * 4 / 3){
                newTransactionTitleHeader.setPadding(newTransactionTitleHeader.paddingStart,
                    paddingTop/3,
                    newTransactionTitleHeader.paddingEnd,
                    paddingBottom /3)
                newTransactionTitleHeader.outlineProvider = null
            }
            else{
                newTransactionTitleHeader.setPadding(newTransactionTitleHeader.paddingStart,
                    paddingTop/3,
                    newTransactionTitleHeader.paddingEnd,
                    paddingBottom /3)
                newTransactionTitleHeader.outlineProvider = ViewOutlineProvider.BACKGROUND
            }
        }
        bankTransfer.setOnClickListener{
            val intent  = Intent (this.activity, NewTransaction::class.java);
            activity?.startActivity(intent);
        }
        return view
    }
}