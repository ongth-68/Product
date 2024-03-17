package com.example.product

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.product.databinding.ActivityMainBinding
import com.example.product.databinding.ActivityPostProductBinding

class PostProduct : AppCompatActivity() {
    private lateinit var binding : ActivityPostProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostProductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                // There are no request codes
//                val data: Intent? = result.data
//
//                binding.IVpostProductImage.setImageURI(data?.data)
//            }
//        }
//
//        binding.IVaddImage.setOnClickListener {
//            val gallery = Intent(Intent.ACTION_PICK)
//            gallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            resultLauncher.launch(gallery)
//        }

    }

}