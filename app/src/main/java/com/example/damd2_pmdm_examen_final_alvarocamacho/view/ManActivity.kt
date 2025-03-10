package com.example.damd2_pmdm_examen_final_alvarocamacho.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.damd2_pmdm_examen_final_alvarocamacho.R
import com.example.damd2_pmdm_examen_final_alvarocamacho.databinding.ActivityManBinding
import com.example.damd2_pmdm_examen_final_alvarocamacho.viewModel.ProductViewModel

class ManActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityManBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}