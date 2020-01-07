package what.the.mvvmcounter


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import what.the.mvvmcounter.databinding.FragmentShareSeekbarBinding

/**
 * A simple [Fragment] subclass.
 */
class ShareSeekbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share_seekbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(requireActivity())[SeekbarViewModel::class.java]

        val binding = DataBindingUtil.bind<FragmentShareSeekbarBinding>(view)
        binding?.lifecycleOwner = requireActivity()
        binding?.setVariable(BR.viewmodel, viewModel)


        binding?.seekbar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textSeekbar.text = progress.toString()
                viewModel.progress.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //
            }

        })

        // databinding으로 교
//        viewModel.progress.observe(requireActivity(), Observer {
//            binding?.seekbar?.progress = it
//        })
    }

}
