package com.example.banking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.banking.model.Person
import com.example.banking.retrofit.PersonApi
import com.example.banking.retrofit.RetrofitService
import com.google.android.material.card.MaterialCardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        val nextBtn = findViewById<MaterialCardView>(R.id.nextBtn)
        val signInBtn = findViewById<MaterialCardView>(R.id.signInBtn)
        val birthForm = findViewById<EditText>(R.id.birthForm)
        val showPasswordBtn : ImageView = findViewById(R.id.showPassword)
        val passwordForm : EditText = findViewById(R.id.passwordForm)
        val fullNameForm : EditText = findViewById(R.id.fullNameForm);
        val usernameForm : EditText = findViewById(R.id.usernameForm);
        var username : String
        var name : String
        var password : String
        var dateOfBirth : String
        var isHidden : Boolean = true;
        val retrofitService = RetrofitService()
        val personApi = retrofitService.retrofit.create<PersonApi>(PersonApi::class.java)
        showPasswordBtn.setOnClickListener{
            if(isHidden){
                passwordForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                isHidden = false
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye_off));
            }
            else{
                passwordForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                isHidden = true;
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye));
            }
        }

        birthForm.filters = arrayOf(InputFilter.LengthFilter(10))
        birthForm.doOnTextChanged { text, start, before, count ->
            if(text?.length==4){
                birthForm.text.insert(4, "-")
            }
            else if(text?.length == 7){
                birthForm.text.insert(7, "-")
            }
        }
        nextBtn.setOnClickListener {
            name = fullNameForm.text.toString()
            password = passwordForm.text.toString()
            username = usernameForm.text.toString()
            dateOfBirth = birthForm.text.toString()
            val person = Person(name, username, password, dateOfBirth)
            personApi.addPerson(person)
                .enqueue(object : Callback<List<Person>> {
                    override fun onResponse(
                        call: Call<List<Person>>,
                        response: Response<List<Person>>
                    ) {
                        println("succes");
                        addLoggedPerson(person)
                    }

                    override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                        println("failure " + t)
                    }


                })
            val intent = Intent(this@CreateAccountActivity, MenuActivity::class.java)
            startActivity(intent)
        }
        signInBtn.setOnClickListener {
            val intent = Intent(this@CreateAccountActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
    fun addLoggedPerson(person: Person){
        val sharedPref = getSharedPreferences("myUser", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", person.name)
        editor.putString("username", person.username)
        editor.putBoolean("isLogged", true)
        editor.apply()
    }
}