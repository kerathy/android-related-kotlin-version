package com.example.cardswipeviewkotlinversion

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PetAdapter
    private lateinit var models: ArrayList<PetsModel>
    private lateinit var viewPager: ViewPager
    var sliderDotspanel: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        sliderDotspanel = findViewById(R.id.slider_dots)

        models = ArrayList()
        val titles = arrayOf("Dobby", "Kitto", "Cozmo", "Tiger", "Husky", "Cat")
        val descs = arrayOf("Dog", "Cat", "Lambardor", "German Shepherd", "Husky", "Unknown")

        for (i in titles.indices) {
            models.add(PetsModel(R.drawable.dummy_image, titles[i], descs[i]))
        }

        adapter = PetAdapter(models, this)
//        adapter = PetAdapter(models, this@MainActivity)
        viewPager.adapter = adapter
    }
}