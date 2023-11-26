package com.example.exempelanim
//kan gora rorande bollar som aker nedat eller diagonalt om man tar bort kod: att boll2 inte ska sta stilal och touchEvent
//kan rora ena bollen sa den foljer mig och den andra aker runt hur som helst, precode till collision

import android.graphics.Paint
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.View
import com.example.exempelanim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.surfaceView.holder.addCallback(GameView(this))
//        binding.surfaceView.setOnTouchListener(this)
        val gameView = GameView(this)
        val container = binding.root
        container.addView(gameView)

//hade kunnat satta gameview i set content view istallet for rad21-23

    }
}







