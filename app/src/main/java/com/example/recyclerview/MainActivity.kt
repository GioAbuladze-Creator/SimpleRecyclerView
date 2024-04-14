package com.example.recyclerview

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val adapter= BrandAdapter(brandList())

        recyclerView.adapter=adapter
    }

    private fun brandList(): ArrayList<BrandModel> {
        return arrayListOf(
            BrandModel("Bmw",R.drawable.bmw),
            BrandModel("Mercedes",R.drawable.mercedes),
            BrandModel("Audi",R.drawable.audi),
            BrandModel("Toyota",R.drawable.toyota),
            BrandModel("Volkswagen",R.drawable.volkswagen),
            BrandModel("Lexus",R.drawable.lexus),
            BrandModel("Nissan",R.drawable.nissan)
        )
    }
}