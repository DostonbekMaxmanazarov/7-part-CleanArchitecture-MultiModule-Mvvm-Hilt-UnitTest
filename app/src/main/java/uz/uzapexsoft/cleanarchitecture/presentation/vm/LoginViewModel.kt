package uz.uzapexsoft.cleanarchitecture.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.uzapexsoft.domain.models.params.LoginParam
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getAuthUseCase: GetAuthUseCase
) : ViewModel() {

    private var _resultLiveData = MutableLiveData<Boolean>()
    val resultLiveData: LiveData<Boolean> get() = _resultLiveData

    fun login(phoneNumber: String, password: String) {
        val loginParam = LoginParam(phoneNumber = phoneNumber, password = password)
        val success = getAuthUseCase(param = loginParam)
        _resultLiveData.value = success
    }
}