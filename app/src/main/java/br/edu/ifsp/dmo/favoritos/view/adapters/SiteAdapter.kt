package br.edu.ifsp.dmo.favoritos.view.adapters

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.dmo.favoritos.R
import br.edu.ifsp.dmo.favoritos.databinding.ItemViewBinding
import br.edu.ifsp.dmo.favoritos.model.Site
import br.edu.ifsp.dmo.favoritos.view.listeners.SiteItemClickListener

class SiteAdapter(val context: Context, val dataset: MutableList<Site>, val listener: SiteItemClickListener) : RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding: ItemViewBinding = ItemViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = dataset[position]
        holder.binding.textviewApelido.setText(item.apelido)
        holder.binding.textviewUrl.setText(item.url)
        if(item.favorito){
            holder.binding.imgHeart.setColorFilter(context.getColor(R.color.red))}
        else{
            holder.binding.imgHeart.setColorFilter(context.getColor(R.color.gray))
        }

        holder.binding.imgHeart.setOnClickListener{listener.clickHeartSiteItem(position)}
        holder.binding.imgDelete.setOnClickListener{listener.clickDeleteSiteItem(position)}
        holder.binding.layoutItem.setOnClickListener{listener.clickSiteItem(position)}
    }

    override fun getItemCount(): Int{
        return dataset.size
    }
}