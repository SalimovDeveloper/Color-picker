package uz.snyder.colorpicker

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val msg = intent.getStringExtra("keyBackround")


//        bottom.setBackgroundColor(Color.parseColor(backround2))
//        view_1.setBackgroundColor(Color.parseColor(backround2))
        view_1.background = MyObject.color
        text_color.text = MyObject.text

        bottom.setOnClickListener {

            var intent = Intent(this, MainActivity2::class.java)


            startActivity(intent)

        }

    }
}