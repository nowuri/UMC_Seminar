package com.example.umc_4week

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.umc_4week.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    var inputMessage : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // onCreate되는지 확인
        Log.e("onCreate","onCreate")
        //NextButton click시 Result 화면으로 바뀌도록
        viewBinding.NextButton.setOnClickListener(){
            val intent = Intent(this, ResultActivity::class.java)

            //strText에 EditText에 입력한 text 저장
            var strText = viewBinding.inputtext.getText().toString()

            //strText를 담아서 보냄
            intent.putExtra("Input",strText)

            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()

        //onPause되는지 확인
        Log.e("onStop","onStop")

        //EditText의 현재 값을 전역변수 inputMessage에 담아두기
        inputMessage = viewBinding.inputtext.getText().toString()

        //메모를 입력하는 EditText는 비우기
        viewBinding.inputtext.setText(null)
    }

    override fun onRestart() {
        super.onRestart()

        //OnRestart되는지 확인
        Log.e("onRestart","onRestart")

        // Dialog를 활용하여 이어서 작성할거냐고 묻는 창 띄우기
        val builder = AlertDialog.Builder(this)
        builder.setTitle("onRestart")
        builder.setMessage("메모장을 이어서 입력하시겠습니까?")

        // 예를 누르면, onStop에서 저장하 전역변수 내용으로 EditText 내용 설정
        builder.setPositiveButton("예",DialogInterface.OnClickListener { dialog, which ->
            viewBinding.inputtext.setText(inputMessage)
        })

        //아니요를 눌렀다면, 저장했던 변수를 비우고 EditText 비우기
        builder.setNegativeButton("아니요", DialogInterface.OnClickListener({dialog, which ->
            viewBinding.inputtext.setText(null)
            inputMessage = ""
        }))

        builder.show()
    }

}