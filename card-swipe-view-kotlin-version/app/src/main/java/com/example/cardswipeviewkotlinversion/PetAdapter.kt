package com.example.cardswipeviewkotlinversion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import java.util.*

class PetAdapter : PagerAdapter {

    private var models: ArrayList<PetsModel>? = null
    private lateinit var layoutInflater: LayoutInflater
    private var context: Context? = null

    constructor(models: ArrayList<PetsModel>?, context: Context?) : super() {
        this.models = models
        this.context = context
    }

    override fun getCount(): Int {
        return models!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item, container, false)

        val imageView = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.txt_des)

        imageView.setImageResource(models!![position].image)
        title.text = models!![position].title
        desc.text = models!![position].desc

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}