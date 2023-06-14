package org.d3if3148.assesmentmobpro.ui.kurs

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3148.assesmentmobpro.R
import org.d3if3148.assesmentmobpro.data.DataCod
import org.d3if3148.assesmentmobpro.databinding.KursItemListBinding
import org.d3if3148.assesmentmobpro.network.CodApi

class KursAdapter : RecyclerView.Adapter<KursAdapter.ViewHolder>() {
    private val data = mutableListOf<DataCod>()
    fun updateData(newData: List<DataCod>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: KursItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(cod: DataCod) = with(binding) {
            mataUangTextView.text = cod.mataUang
            nilaiTextView.text = cod.nilai
            Glide.with(imageView.context)
                .load(CodApi.getCodUrl(cod.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, cod.mataUang)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = KursItemListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}