package org.d3if3148.assesmentmobpro.ui.hitung

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3148.assesmentmobpro.R
import org.d3if3148.assesmentmobpro.databinding.HitungFragmentBinding
import org.d3if3148.assesmentmobpro.db.CodDb
import org.d3if3148.assesmentmobpro.model.HasilHitung

class HitungFragment : Fragment() {
    private lateinit var binding: HitungFragmentBinding

    private val viewModel: HitungViewModel by lazy {
        val db = CodDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("HitungFragment", "onAttach dijalankan")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("HitungFragment", "onCreate dijalankan")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = HitungFragmentBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonHitung.setOnClickListener {konversiRupiah()}
        binding.shareButton.setOnClickListener {shareData()}
        binding.lihatKursbutton.setOnClickListener{lihatKurs()}
        viewModel.getHasilCod().observe(requireActivity(), {showResult(it)})
    }

    override fun onStart() {
        super.onStart()
        Log.i("HitungFragment", "onStart dijalankan")
    }

    override fun onResume() {
        super.onResume()
        Log.i("HitungFragment", "onResume dijalankan")
    }

    override fun onPause() {
        Log.i("HitungFragment", "onPause dijalankan")
        super.onPause()
    }

    override fun onStop() {
        Log.i("HitungFragment", "onStop dijalankan")
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("HitungFragment", "onDestroyView dijalankan")
    }

    override fun onDestroy() {
        Log.i("HitungFragment", "onDestroy dijalankan")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("HitungFragment", "onDetach dijalankan")
        super.onDetach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_hitungFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(R.id.action_hitungFragment_to_aboutFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun konversiRupiah() {
        val uang = binding.inputanJumlahUang.text.toString()
        if (TextUtils.isEmpty(uang)) {
            Toast.makeText(context, R.string.inputanRupiah, Toast.LENGTH_LONG).show()
            return
        }

        viewModel.konversiRupiah(
            uang.toFloat()
        )
    }

    private fun showResult(result: HasilHitung?) {
        if (result == null) return
        binding.textHasil.text = getString(R.string.hasil_x, result.hasil)
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.textHasil.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    private fun lihatKurs() {
            findNavController().navigate(R.id.action_hitungFragment_to_kursFragment)
        }
    }
