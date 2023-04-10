package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.EditText
import android.widget.ImageView
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.example.banking.R
import com.google.android.material.card.MaterialCardView

class OpenNewAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_new_account)
        val headerConstraintLayout : ConstraintLayout = findViewById(R.id.headerConstraint)
        val scrollView : ScrollView = findViewById(R.id.scrollView)
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
        val pinForm : EditText = findViewById(R.id.pinForm);
        var value : Editable? = null;
        pinForm.filters = arrayOf(InputFilter.LengthFilter(4))
        val showPasswordBtn : ImageView = findViewById(R.id.showPin)
        var isHidden : Boolean = true;
        val colorImg1 : ImageView = findViewById(R.id.colorImg1)
        val colorImg2 : ImageView = findViewById(R.id.colorImg2)
        val colorImg3 : ImageView = findViewById(R.id.colorImg3)
        val colorImg4 : ImageView = findViewById(R.id.colorImg4)
        val colorImg5 : ImageView = findViewById(R.id.colorImg5)
        val colorCardView1 : MaterialCardView = findViewById(R.id.colorCardview1)
        val colorCardView2 : MaterialCardView = findViewById(R.id.colorCardview2)
        val colorCardView3 : MaterialCardView = findViewById(R.id.colorCardview3)
        val colorCardView4 : MaterialCardView = findViewById(R.id.colorCardview4)
        val colorCardView5 : MaterialCardView = findViewById(R.id.colorCardview5)
        val cardBack : ConstraintLayout = findViewById(R.id.cardCardviewConstraint)
        colorCardView1.setOnClickListener{
            colorImg1.visibility = View.VISIBLE
            colorImg2.visibility = View.INVISIBLE
            colorImg3.visibility = View.INVISIBLE
            colorImg4.visibility = View.INVISIBLE
            colorImg5.visibility = View.INVISIBLE
            cardBack.background = resources.getDrawable(R.drawable.darkblue_back)
        }
        colorCardView2.setOnClickListener{
            colorImg1.visibility = View.INVISIBLE
            colorImg2.visibility = View.VISIBLE
            colorImg3.visibility = View.INVISIBLE
            colorImg4.visibility = View.INVISIBLE
            colorImg5.visibility = View.INVISIBLE
            cardBack.background = resources.getDrawable(R.drawable.gradient1)
        }
        colorCardView3.setOnClickListener{
            colorImg1.visibility = View.INVISIBLE
            colorImg2.visibility = View.INVISIBLE
            colorImg3.visibility = View.VISIBLE
            colorImg4.visibility = View.INVISIBLE
            colorImg5.visibility = View.INVISIBLE
            cardBack.background = resources.getDrawable(R.drawable.gradient2)
        }
        colorCardView4.setOnClickListener{
            colorImg1.visibility = View.INVISIBLE
            colorImg2.visibility = View.INVISIBLE
            colorImg3.visibility = View.INVISIBLE
            colorImg4.visibility = View.VISIBLE
            colorImg5.visibility = View.INVISIBLE
            cardBack.background = resources.getDrawable(R.drawable.gradient3)
        }
        colorCardView5.setOnClickListener{
            colorImg1.visibility = View.INVISIBLE
            colorImg2.visibility = View.INVISIBLE
            colorImg3.visibility = View.INVISIBLE
            colorImg4.visibility = View.INVISIBLE
            colorImg5.visibility = View.VISIBLE
            cardBack.background = resources.getDrawable(R.drawable.gradient4)
        }
        showPasswordBtn.setOnClickListener{
            if(isHidden){
                pinForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                isHidden = false
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye_off))
            }
            else{
                pinForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                isHidden = true;
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye))
            }
        }
    }
}