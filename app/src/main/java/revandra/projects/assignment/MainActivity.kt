package revandra.projects.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import revandra.projects.assignment.Retrofit.APIClient
import revandra.projects.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mLastClickTime:Long = 0
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun Login(view: View) {
        APIClient.apiService.login(Login(binding.email.text.toString(), binding.password.text.toString()))
            .enqueue(object : Callback<revandra.projects.assignment.Response> {
                override fun onResponse(call: Call<revandra.projects.assignment.Response>, response: Response<revandra.projects.assignment.Response>) {
                    if (response.body()?.message == "Logged in"){
                        startActivity(Intent(this@MainActivity, MainActivity2::class.java).putExtra("Email", binding.email.text.toString()))
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<revandra.projects.assignment.Response>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Something's wrong", Toast.LENGTH_SHORT).show()
                }

            })

    }
    override fun onBackPressed() {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 3000){
            finishAffinity()
            finish()
        }
        else{
            mLastClickTime = SystemClock.elapsedRealtime()
            Toast.makeText(this, "Back Again To Close The App", Toast.LENGTH_SHORT).show()
            return
        }
        super.onBackPressed()
    }
}