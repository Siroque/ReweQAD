package com.example.sin.reweqad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sin.reweqad.R
import com.example.sin.reweqad.data.Entity
import kotlinx.android.synthetic.main.fragment_entity_list.view.*
import kotlinx.android.synthetic.main.list_item_entity.view.*

/**
 * Adapter for the [RecyclerView] in [EntityListFragment].
 */
class EntityListAdapter(private val entityList: List<Entity>) : RecyclerView.Adapter<EntityListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindEntity(entity: Entity) {
            with(entity) {
                itemView.entity_item_name.text = entity.name.orEmpty()
                itemView.entity_item_warranty.text = entity.warranty?.toString()
                itemView.entity_item_created.text = entity.created.toString()
                itemView.entity_item_criterion.text = entity.criterion.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_entity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = entityList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindEntity(entityList.elementAt(position))
    }
}