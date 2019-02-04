package `in`.jamian.mvvm_livedata

import androidx.lifecycle.ViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        username.doAfterTextChanged{ text -> viewModel.username = text}
        password.doAfterTextChanged { text -> viewModel.password = text }

        viewModel.isFormValid.observe(this, Observer { valid ->
            login.isEnabled = valid ?: false
        })
    }


    private fun EditText.doAfterTextChanged(doAfterTextChanged: (String) -> Unit){

        this.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable?) {
                doAfterTextChanged.invoke(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }
}
