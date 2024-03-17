package com.example.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.product.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var newRecyclerview : RecyclerView

    //Later change to get data from database
    private lateinit var newArrayList : ArrayList<ProductData>
    lateinit var productImage : Array<Int>
    lateinit var productName : Array<String>
    lateinit var productPrice : Array<Float>
    lateinit var productRating : Array<Float>
    lateinit var LLproduct : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productImage = arrayOf(
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
        )
        productName = arrayOf(
            "This is a product1",
            "This is a product2",
            "This is a product3",
            "This is a product4",
            "This is a product5",
            "This is a product6",
            "This is a product1",
            "This is a product2",
            "This is a product3",
            "This is a product4",
            "This is a product5",
            "This is a product6"
        )
        productPrice = arrayOf(
            12.30f,
            12.31f,
            12.32f,
            12.33f,
            12.38f,
            12.39f,
            12.30f,
            12.31f,
            12.32f,
            12.33f,
            12.38f,
            12.39f
        )
        productRating = arrayOf(
            4.5f,
            4.3f,
            5.0f,
            2.0f,
            3.0f,
            4.0f,
            4.5f,
            4.3f,
            5.0f,
            2.0f,
            3.0f,
            4.0f,
        )

        newRecyclerview = findViewById(R.id.recycleView)
        newRecyclerview.layoutManager = GridLayoutManager(this, 2)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = ArrayList<ProductData>()
        getUserData()

    }

    private fun getUserData(){
        for(i in productImage.indices){
            val product = ProductData(productImage[i], productName[i], productPrice[i].toString(), productRating[i].toString())
            newArrayList.add(product)
        }

        newRecyclerview.adapter = ProductAdapter(newArrayList)
    }

}