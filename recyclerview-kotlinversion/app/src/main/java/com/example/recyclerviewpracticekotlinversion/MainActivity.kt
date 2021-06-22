package com.example.recyclerviewpracticekotlinversion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val movieList = ArrayList<MovieModel>()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "KotlinApp"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        moviesAdapter = MoviesAdapter(movieList)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = moviesAdapter
        prepareMovieData()
        updateData()
//        insertData()
//        removeData()
    }

    private fun prepareMovieData() {
        val titles = arrayOf(
            "Mad Max: Fury Road", "Inside Out", "Star Wars: Episode VII - The Force Awakens",
            "Shaun the Sheep", "The Martian", "Mission: Impossible Rogue Nation", "Up",
            "Star Trek", "The LEGO MovieModel", "Aliens", "Chicken Run", "Back to the Future",
            "Raiders of the Lost Ark", "Goldfinger", "Guardians of the Galaxy"
        )

        val genres = arrayOf(
            "Action & Adventure", "Animation, Kids & Family", "Action",
            "Animation", "Science Fiction & Fantasy", "Action", "Animation",
            "Science Fiction", "Animation", "Action & Adventure", "Science Fiction", "Animation",
            "Action & Adventure", "Action & Adventure", "Science Fiction & Fantasy"
        )

        val years = arrayOf(
            "2015", "2015", "2015", "2015", "2015", "2015", "2009",
            "2009", "2014", "2008", "1986", "2000", "1985", "1981", "1965", "2014"
        )

        val index = titles.size - 1
        for (i in 0..index) {
            val movie = MovieModel(titles[i], genres[i], years[i])
            movieList.add(movie)
        }
        moviesAdapter.notifyDataSetChanged()
    }

    private fun updateData() {
        movieList.clear()
        val movie1 = MovieModel("update title1", "update genre1", "update year1")
        val movie2 = MovieModel("update title2", "update genre2", "update year2")
        movieList.add(movie1)
        movieList.add(movie2)
        moviesAdapter.notifyDataSetChanged()
    }

    private fun insertData() {
        val movie = MovieModel("insert title", "insert genre", "insert year")
        movieList.add(movie)
        moviesAdapter.notifyDataSetChanged()
    }

    private fun removeData() {
        movieList.clear()
        moviesAdapter.notifyDataSetChanged()
    }
}