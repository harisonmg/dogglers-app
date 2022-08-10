/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dogs = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // declare and initialize all of the list item UI components
        val dogImage = view?.findViewById<ImageView>(R.id.dog_image)
        val dogName = view?.findViewById<TextView>(R.id.dog_name)
        val dogAge = view?.findViewById<TextView>(R.id.dog_age)
        val dogHobbies = view?.findViewById<TextView>(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // determine the layout type and set it accordingly.
        var listItem = R.layout.vertical_horizontal_list_item

        if (layout == Layout.GRID) {
            listItem = R.layout.grid_list_item
        }

        // inflate the layout
        val inflatedLayout = LayoutInflater.from(parent.context).inflate(listItem, parent, false)
        return DogCardViewHolder(inflatedLayout)
    }

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = dogs[position]

        // set the attributes for the current dog
        // val resources = context?.resources
        holder.dogImage?.setImageResource(dog.imageResourceId)
        holder.dogName?.text = dog.name
        holder.dogAge?.text = dog.age // resources?.getString(R.string.dog_age, dog.age)
        holder.dogHobbies?.text =
            dog.hobbies // resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
