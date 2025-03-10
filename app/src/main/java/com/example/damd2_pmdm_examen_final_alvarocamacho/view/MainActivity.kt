package com.example.damd2_pmdm_examen_final_alvarocamacho.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.damd2_pmdm_examen_final_alvarocamacho.R
import com.example.damd2_pmdm_examen_final_alvarocamacho.adapter.ProductAdapter
import com.example.damd2_pmdm_examen_final_alvarocamacho.databinding.ActivityMainBinding
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.Product
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.RetrofitClient
import com.example.damd2_pmdm_examen_final_alvarocamacho.repository.ProductRepository
import com.example.damd2_pmdm_examen_final_alvarocamacho.viewModel.ProductViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        val productsList = mutableListOf<Product>()
        val adapter = ProductAdapter(productsList) { product ->
            onItemSelected(product)
        }

        binding.rvProducts.adapter = adapter
        val service = RetrofitClient.service
        val repo = ProductRepository(service)
        viewModel = ProductViewModel(repo)

        loadElectronicsProducts(adapter)
        this.setTitle("Electrónica")

        binding.tbProducts.setOnMenuItemClickListener { menuItem->
            when (menuItem.itemId) {
                R.id.electronica-> {
                    loadElectronicsProducts(adapter)
                    binding.tbProducts.setTitle("Electrónica")
                    this.setTitle("Electrónica")
                    true
                }
                R.id.joyeria -> {
                    loadElectronicsProducts(adapter)
                    binding.tbProducts.setTitle("Joyería")
                    this.setTitle("Joyería")
                    true
                }
                R.id.hombre-> {
                    loadElectronicsProducts(adapter)
                    binding.tbProducts.setTitle("Hombre")
                    this.setTitle("Hombre")
                    true
                }
                R.id.mujer-> {
                    loadElectronicsProducts(adapter)
                    binding.tbProducts.setTitle("Mujer")
                    this.setTitle("Mujer")
                    true
                }

                else -> false
            }
        }
    }


    private fun loadElectronicsProducts(adapter: ProductAdapter) {
        viewModel.loadElectronicsProducts(1)
        viewModel.electronicsProducts.observe(this) { products ->
            products?.let { adapter.updateData(it) }
        }
    }

    private fun loadJewelleryProducts(adapter: ProductAdapter) {
        viewModel.loadElectronicsProducts(1)
        viewModel.jewelleryProducts.observe(this) { products ->
            products?.let { adapter.updateData(it) }
        }
    }

    private fun loadMenProducts(adapter: ProductAdapter) {
        viewModel.loadElectronicsProducts(1)
        viewModel.menProducts.observe(this) { products ->
            products?.let { adapter.updateData(it) }
        }
    }

    private fun loadWomenProducts(adapter: ProductAdapter) {
        viewModel.loadElectronicsProducts(1)
        viewModel.womenProducts.observe(this) { products ->
            products?.let { adapter.updateData(it) }
        }
    }



    private fun onItemSelected(product: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product", product)
        this.startActivity(intent)
    }
}