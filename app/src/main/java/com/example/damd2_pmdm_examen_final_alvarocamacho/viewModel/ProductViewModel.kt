package com.example.damd2_pmdm_examen_final_alvarocamacho.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.Product
import com.example.damd2_pmdm_examen_final_alvarocamacho.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    private val electronicsProductsMutable = MutableLiveData<List<Product>?>()
    private val jewelleryProductsMutable = MutableLiveData<List<Product>?>()
    private val menProductsMutable = MutableLiveData<List<Product>?>()
    private val womenProductsMutable = MutableLiveData<List<Product>?>()



    val electronicsProducts: LiveData<List<Product>?> = electronicsProductsMutable
    val jewelleryProducts: LiveData<List<Product>?> = jewelleryProductsMutable
    val menProducts: LiveData<List<Product>?> = menProductsMutable
    val womenProducts: LiveData<List<Product>?> = womenProductsMutable

    fun loadElectronicsProducts(page: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = repository.getElectronicsProducts()

                if (products != null) {
                    electronicsProductsMutable.postValue(products)
                } else {
                    Log.e("ProductsViewModel","No se ha recibido respuesta del servidor")
                }
            } catch (e: Exception) {
                Log.e("ProductsViewModel", "Error al obtener productos", e)
            }
        }
    }

    fun loadJewelleryProducts(page: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = repository.getJewelleryProducts()

                if (products != null) {
                    jewelleryProductsMutable.postValue(products)
                } else {
                    Log.e("ProductsViewModel","No se ha recibido respuesta del servidor")
                }
            } catch (e: Exception) {
                Log.e("ProductsViewModel", "Error al obtener productos", e)
            }
        }
    }

    fun loadMenProducts(page: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = repository.getMenProducts()

                if (products != null) {
                    jewelleryProductsMutable.postValue(products)
                } else {
                    Log.e("ProductsViewModel","No se ha recibido respuesta del servidor")
                }
            } catch (e: Exception) {
                Log.e("ProductsViewModel", "Error al obtener productos", e)
            }
        }
    }

    fun loadWomenProducts(page: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = repository.getWomenProducts()

                if (products != null) {
                    jewelleryProductsMutable.postValue(products)
                } else {
                    Log.e("ProductsViewModel","No se ha recibido respuesta del servidor")
                }
            } catch (e: Exception) {
                Log.e("ProductsViewModel", "Error al obtener productos", e)
            }
        }
    }
}