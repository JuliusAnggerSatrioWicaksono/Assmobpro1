package org.d3if3148.assesmentmobpro.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3148.assesmentmobpro.R
import org.d3if3148.assesmentmobpro.databinding.ItemHistoriBinding
import org.d3if3148.assesmentmobpro.db.CodEntity
import org.d3if3148.assesmentmobpro.model.hitungCod
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoriAdapter: ListAdapter<CodEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<CodEntity>() {
                override fun areItemsTheSame(
                    oldData: CodEntity, newData: CodEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: CodEntity, newData: CodEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: CodEntity) = with(binding) {
            val hasilCod = item.hitungCod()
            kategoriTextView.text = hasilCod.hasil.toString().substring(0, 1)

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            hasilTextView.text = root.context.getString(R.string.hasil_x,hasilCod.hasil)

        }
    }
}