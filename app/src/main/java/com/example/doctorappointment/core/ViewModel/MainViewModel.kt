package com.example.doctorappointment.core.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctorappointment.core.model.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel: ViewModel() {
    private val db= FirebaseDatabase.getInstance()

    private val _category = MutableLiveData<List<CategoryModel>>(emptyList())

    val category: LiveData<List<CategoryModel>> = _category

    private var categoryLoaded = false

    fun loadCategory(
        force: Boolean = false
    ) {
        if(categoryLoaded && !force)
            return
        categoryLoaded = true
        var ref = db.getReference("Category")
        ref.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val items = mutableListOf<CategoryModel>()
                    for(child in snapshot.children) {
                        child.getValue(CategoryModel::class.java)?.let {
                            items.add(it)
                        }
                    }
                    _category.value = items
                }

                override fun onCancelled(error: DatabaseError) {
                    categoryLoaded = false
                }

            }
        )
    }
}