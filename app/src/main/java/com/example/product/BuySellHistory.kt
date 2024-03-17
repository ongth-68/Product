package com.example.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date
import com.example.product.databinding.ActivityBuySellHistoryBinding

class BuySellHistory : AppCompatActivity() {

    private lateinit var binding: ActivityBuySellHistoryBinding

    private lateinit var newRecyclerview : RecyclerView

    private lateinit var newArrayList : ArrayList<SoldData>
    lateinit var productImage : Array<Int>
    lateinit var productName : Array<String>
    lateinit var productPrice : Array<Float>
    lateinit var productRating : Array<Float>
    lateinit var soldAmount : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBuySellHistoryBinding.inflate(layoutInflater)
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

        soldAmount = arrayOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        )

        newRecyclerview = findViewById(R.id.rvHistory)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = ArrayList<SoldData>()
        getUserData()

    }

    private fun getUserData(){
        for(i in productImage.indices){
            val product = ProductData(productImage[i], productName[i], productPrice[i].toString(), productRating[i].toString())
            val soldData = SoldData(product, soldAmount[i], Date())
            newArrayList.add(soldData)
        }

        newRecyclerview.adapter = HistoryAdapter(newArrayList)
    }
}