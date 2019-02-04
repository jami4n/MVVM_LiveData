package `in`.jamian.mvvm_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    private val _isFormValid = MutableLiveData<Boolean>()

    val isFormValid : LiveData<Boolean> //returns a Mutable Live Data Variable _isFormValid
        get() = _isFormValid

    var username = ""
        set(value) {
            field = value
            validateForm()
        }

    var password = ""
        set(value) {
            field = value
            validateForm()
        }



    private fun validateForm() { //changes data of LiveData Variable according to validation

        if(username.length > 8 && password.length > 8){
            _isFormValid.postValue(true)
        }else{
            _isFormValid.postValue(false)
        }
    }


}