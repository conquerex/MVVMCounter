package what.the.mvvmcounter

import android.content.Intent
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
        binding.lifecycleOwner = this

        var vm = ViewModelProviders.of(this)[CounterViewModel::class.java]
        binding.setVariable(BR.vm, vm)

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

        binding.buttonShowSeekbar.setOnClickListener {
            var intent = Intent(this, ShareActivity::class.java)
            startActivity(intent)
        }

        /**
         * Data binding으로 생략됨
         *
        vm.cnt.observe(this, Observer {
            // UI 업데이트
//            val counter = vm.cnt.value
            binding.textResult.text = "count : $it"
        })*/
    }
}
