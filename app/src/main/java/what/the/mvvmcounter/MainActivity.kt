package what.the.mvvmcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import what.the.mvvmcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var vm = ViewModelProviders.of(this)[CounterViewModel::class.java]

        binding.buttonPlus.setOnClickListener {
//            vm.counter += 1
            vm.increase()
//            val counter = vm.cnt.value
//            binding.textResult.text = "Up : $counter"
        }

        binding.buttonMinus.setOnClickListener {
//            vm.counter -= 1
            vm.decrease()
//            val counter = vm.cnt.value
//            binding.textResult.text = "Down : $counter"
        }

        vm.cnt.observe(this, Observer {
            // UI 업데이트
//            val counter = vm.cnt.value
            binding.textResult.text = "count : $it"
        })
    }
}
