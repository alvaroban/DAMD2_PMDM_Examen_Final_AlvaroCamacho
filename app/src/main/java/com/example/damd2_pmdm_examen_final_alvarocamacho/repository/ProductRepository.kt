package com.example.damd2_pmdm_examen_final_alvarocamacho.repository

import com.example.damd2_pmdm_examen_final_alvarocamacho.model.Product
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.ProductService

class ProductRepository(private val apiService: ProductService) {
    suspend fun getElectronicsProducts():List<Product>? {
        val response = apiService.getElectronics()
        return if (response.isSuccessful) {
            response.body()?.results
        } else null
    }

    suspend fun getJewelleryProducts():List<Product>? {
        val response = apiService.getJewelery()
        return if (response.isSuccessful) {
            response.body()?.results
        } else null
    }

    suspend fun getMenProducts():List<Product>? {
        val response = apiService.getMen()
        return if (response.isSuccessful) {
            response.body()?.results
        } else null
    }

    suspend fun getWomenProducts():List<Product>? {
        val response = apiService.getWomen()
        return if (response.isSuccessful) {
            response.body()?.results
        } else null
    }
}