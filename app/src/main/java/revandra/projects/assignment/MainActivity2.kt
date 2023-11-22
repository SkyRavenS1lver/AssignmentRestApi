package revandra.projects.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import revandra.projects.assignment.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var mLastClickTime:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val text = "Welcome "+intent.getStringExtra("Email")
        binding.email.text = text
    }

    fun Logout(view: View) {
        finish()
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