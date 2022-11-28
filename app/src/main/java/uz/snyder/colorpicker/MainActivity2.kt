package uz.snyder.colorpicker

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        image_view.isDrawingCacheEnabled = true
        image_view.buildDrawingCache(true)

        image_view.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE){
                bitmap = image_view.drawingCache
                var pixel = bitmap.getPixel(event.x.toInt(), event.y.toInt())

                var r = Color.red(pixel)
                var g = Color.green(pixel)
                var b = Color.blue(pixel)

                val hex = "#" + Integer.toHexString(pixel)

                color_view.setBackgroundColor(Color.rgb(r,g,b))

                var color_ = color_view.setBackgroundColor(Color.rgb(r,g,b))

                text_result.text = "RGB: $r, $g, $b \nHex: $hex"
            }
            true
        }


        bottom2.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            MyObject.color = color_view.background
            MyObject.text = text_result.text.toString().substring(text_result.text.toString().indexOf('#'))

            startActivity(intent)

        }
    }
}