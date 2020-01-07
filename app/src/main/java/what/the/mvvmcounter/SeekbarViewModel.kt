package what.the.mvvmcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekbarViewModel : ViewModel() {
    var progress = MutableLiveData<Int>()
}