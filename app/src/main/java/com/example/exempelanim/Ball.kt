package com.example.exempelanim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint

class Ball(context: Context) {
    var posX = 0f
    var posY = 0f
    var paint = Paint()
    var size = 50f
    var speed = 15f

    fun update() {



        posY = posY + speed // bollar som aker nerat pa vanster sidan
        posX += speed //diagonalt akande bollar

    }

    fun draw(canvas: Canvas?) {
    canvas?.drawCircle(posX, posY, size,paint)
    }

}
