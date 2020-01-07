package what.the.mvvmcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counter = 0

    var cnt = MutableLiveData(0)

    fun increase() {
        cnt.value = cnt.value?.plus(1)
    }

    fun decrease() {
        cnt.value = cnt.value?.minus(1)
    }
}