package com.example.acalculator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListStorage private constructor(){

    private val storage = mutableListOf<Operation>()

    companion object {

        private var instance: ListStorage? = null

        fun getInstance(): ListStorage {
            synchronized(this) {
                if(instance == null) {
                    instance = ListStorage()
                }
                return instance as ListStorage
            }
        }
    }

    suspend fun insert(operation: Operation) {
        withContext(Dispatchers.IO) {
            Thread.sleep(30000)
            storage.add(operation)
        }

    }

    suspend fun getAll(): List<Operation> {
        var list = mutableListOf<Operation>()
        withContext(Dispatchers.IO) {
            Thread.sleep(30000)
            list = storage
        }
        return list.toList()
    }

    suspend fun delete(operation: Operation) {
        withContext(Dispatchers.IO) {
            Thread.sleep(30000)
            storage.remove(operation)
        }
    }
}