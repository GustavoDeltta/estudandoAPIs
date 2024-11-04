package com.example.MyStores

import java.util.*

data class Store(val id: Int, val name: String, val type: String)

class Response<T>(val data: T)

class Stores {
    private val myStores: MutableList<Store> = mutableListOf(
        Store(1,"Leleo Moveis", "moveis"),
        Store(2,"Mafalda Magazine", "roupas"),
        Store(3,"Bunny Store","celulares"),
        Store(4,"Lojas Maravilhas", "moveis"),
        Store(5,"Lucinete Modas", "roupas")
    )

    fun getAllMyStores(): List<Store>{
        return myStores
    }
    fun getMyStoreById(id: Any): Response<out Any>{
        var storeAux = Store(0,"","")
        for (store: Store in myStores){
            if (store.id.toString() == id.toString()){
                storeAux = store
                break
            }
        }
        if (storeAux.id != 0){
            val response = Response(storeAux)
            return response
        }else{
            val response = Response("Error 404! Store Not Found")
            return response
        }
    }
    fun getMyStoreByType(type: Any): Response<out Any>{
        val storeAux: MutableList<Store> = mutableListOf(Store(0,"",""))
        for (store: Store in myStores){
            if (store.type == type.toString().lowercase(Locale.getDefault())){
                storeAux.add(store)
            }
        }
        storeAux.removeFirst()
        if (storeAux.isNotEmpty()){
            val response = Response(storeAux)
            return response
        }else{
            val response = Response("Error 404! Type Not Found")
            return response
        }
    }
}