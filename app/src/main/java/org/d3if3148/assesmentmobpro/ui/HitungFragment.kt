package org.d3if3148.assesmentmobpro.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3148.assesmentmobpro.R
import org.d3if3148.assesmentmobpro.databinding.HitungFragmentBinding
import org.d3if3148.assesmentmobpro.model.HasilHitung

class HitungFragment: Fragment() {
    private lateinit var binding: HitungFragmentBinding
    private val viewModel: HitungViewModel by lazy {
        ViewModelProvider(requireActivity())[HitungViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {
        binding = HitungFragmentBinding.inflate(layoutInflater,container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, saveInstanceState: Bundle?) {
        binding.buttonHitung.setOnClickListener{ konversiRupiah()}
            viewModel.getHasilCod1().observe(requireActivity(),{showResult1(it)})

        binding.buttonHitung2.setOnClickListener{ konversiDollar()}
            viewModel.getHasilCod2().observe(requireActivity(),{showResult2(it)})

        binding.shareButton.setOnClickListener { shareData() }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
        findNavController().navigate(
            R.id.action_hitungFragment_to_aboutFragment)
        return true
    }
        return super.onOptionsItemSelected(item)
    }

    private fun konversiRupiah(){
        val input = binding.inputanJumlahUang.text.toString()
        if(TextUtils.isEmpty(input)) {
            Toast.makeText(context, "Masukkan Jumlah Uang", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.konversiRupiah(
            input.toFloat()
        )
    }

    private fun konversiDollar() {
        val input = binding.inputanJumlahUang.text.toString()
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(context, "Masukkan Jumlah Uang!", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.konversiDollar(
            input.toFloat()
        )
    }

    private fun showResult1(result: HasilHitung?){
        if (result == null) return
        binding.textHasil.text = getString(R.string.hasil_x, result.hasil)
    }

    private fun showResult2(result: HasilHitung?){
        if (result == null) return
        binding.textHasil.text = getString(R.string.hasil_y, result.hasil)
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.textHasil.text,
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

}