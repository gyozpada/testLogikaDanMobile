package com.sagalang.loginregisterforgotpassworddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_register.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {

            when {
                TextUtils.isEmpty(et_login_email.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity, "Please input email", Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(et_login_password.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity, "Please input password", Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = et_login_email.text.toString().trim{ it <= ' ' }
                    val password: String = et_login_password.text.toString().trim{ it <= ' ' }

                    //Log-in using firebaseauth
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener{ task ->
                            if (task.isSuccessful){
                                Toast.makeText(
                                    this@LoginActivity, "Login Successfull", Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                    Intent(this@LoginActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {

                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}