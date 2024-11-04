package com.example.MyStores

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class MyStoresController {

    private val myStores = Stores()

    @GetMapping("/all")
    fun getStores():List<Store>{
        return myStores.getAllMyStores()
    }
    @GetMapping("/search")
    fun getStoresById(@RequestParam("id") id:Any): Response<out Any>{
        return myStores.getMyStoreById(id)
    }
    @GetMapping("/stores")
    fun getStoresByType(@RequestParam("type") type:Any): Response<out Any>{
        return myStores.getMyStoreByType(type)
    }
}