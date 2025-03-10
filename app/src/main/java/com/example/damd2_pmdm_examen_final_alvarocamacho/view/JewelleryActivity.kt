package com.example.damd2_pmdm_examen_final_alvarocamacho.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.damd2_pmdm_examen_final_alvarocamacho.R
import com.example.damd2_pmdm_examen_final_alvarocamacho.databinding.ActivityJewelleryBinding
import com.example.damd2_pmdm_examen_final_alvarocamacho.databinding.ActivityMainBinding
import com.example.damd2_pmdm_examen_final_alvarocamacho.viewModel.ProductViewModel

class JewelleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJewelleryBinding
    private lateinit var viewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityJewelleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}