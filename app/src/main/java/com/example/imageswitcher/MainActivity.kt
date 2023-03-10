package com.example.imageswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val images = intArrayOf(R.drawable.image1 , R.drawable.image2 , R.drawable.image3 , R.drawable.image4)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSwitcher = findViewById<ImageSwitcher>(R.id.imageSwitcher)

        imageSwitcher?.setFactory {
            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(8, 300, 8, 8)
            imageView
        }

        imageSwitcher?.setImageResource(images[index])

        val imageIn = AnimationUtils.loadAnimation(
            this , android.R.anim.slide_in_left)
        imageSwitcher?.inAnimation = imageIn

        val imageOut = AnimationUtils.loadAnimation(
            this,android.R.anim.slide_out_right)
        imageSwitcher?.inAnimation = imageOut

        val previousButton = findViewById<Button>(R.id.previousButton)
        previousButton.setOnClickListener {
            index = if(index -1 >= 0) index - 1 else 3
            imageSwitcher?.setImageResource(images[index])
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            index = if (index + 1 < images.size) index + 1 else 0
            imageSwitcher?.setImageResource(images[index])
        }
    }
}