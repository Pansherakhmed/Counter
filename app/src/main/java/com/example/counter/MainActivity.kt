package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var count = 0
    private val presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnPlus.setOnClickListener {
               presenter.increment()
            }
            btnMinus.setOnClickListener {
                presenter.decrement()
            }
        }

    }

    override fun showCounter(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast() {
        showToast("Congratulation")
    }

    override fun changeColor() {
        binding.tvCount.setTextColor( getColor(R.color.green))
    }

}