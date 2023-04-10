package com.example.banking

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.banking.R

class TransactionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_transaction, container, false)
        val allTransactionsTitleHeader : ConstraintLayout = view.findViewById(R.id.allTransactionsTitleHeader)
        val scrollView : ScrollView = view.findViewById(R.id.scrollView)
        var paddingTop : Int = allTransactionsTitleHeader.paddingTop
        var paddingBottom : Int = allTransactionsTitleHeader.paddingBottom
        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY : Int = scrollView.scrollY
            println(scrollY)
            if(scrollY < (paddingTop / 3 * 2)){
                allTransactionsTitleHeader.setPadding(allTransactionsTitleHeader.paddingStart,
                    paddingTop - scrollY,
                    allTransactionsTitleHeader.paddingEnd,
                    paddingBottom - scrollY)
                allTransactionsTitleHeader.outlineProvider = null
            } else if(scrollY >= (paddingTop / 3 * 2) && scrollY < paddingTop * 4 / 3){
                allTransactionsTitleHeader.setPadding(allTransactionsTitleHeader.paddingStart,
                    paddingTop/3,
                    allTransactionsTitleHeader.paddingEnd,
                    paddingBottom /3)
                allTransactionsTitleHeader.outlineProvider = null
            }
            else{
                allTransactionsTitleHeader.setPadding(allTransactionsTitleHeader.paddingStart,
                    paddingTop/3,
                    allTransactionsTitleHeader.paddingEnd,
                    paddingBottom /3)
                allTransactionsTitleHeader.outlineProvider = ViewOutlineProvider.BACKGROUND
            }
        }
        return view
    }
}