package com.lucaslara.reflucaslara

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucaslara.reflucaslara.bases.Redes
import com.lucaslara.reflucaslara.databinding.ResItemLinksBinding

class LinksAdapter() : RecyclerView.Adapter<LinksAdapter.RedesViewHolder>() {

    private var listaDeLinks: List<Redes> = ArrayList()
    private var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedesViewHolder {
        val binding = ResItemLinksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RedesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaDeLinks.size
    }

    fun setDataSet(redes: List<Redes>) {
        this.listaDeLinks = redes
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RedesViewHolder, position: Int) {
        holder.bind(listaDeLinks[position])
    }

    inner class RedesViewHolder(private val binding: ResItemLinksBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(listaDeLinks[adapterPosition])
            }
        }

        fun bind(rede: Redes) {
            binding.tituloLink.text = rede.nomeRede
            binding.inkAcesso.text = rede.link
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(rede: Redes)
    }
}

