package com.example.exempelanim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.graphics.Paint
import android.view.MotionEvent

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private var thread: Thread? = null
    private var running = false
    lateinit var canvas: Canvas
    lateinit var ball1: Ball
    lateinit var ball2: Ball

    var mHolder: SurfaceHolder? = holder
    //var holder: SurfaceHolder? = getHolder()

    init {
        if (mHolder != null) {
            mHolder?.addCallback(this)
        }
        setup()
    }

    private fun setup() {
        ball1 = Ball(this.context)
        ball2 = Ball(this.context)
        ball1.posX = 100f
        ball1.posY = 100f
        ball2.posX = 500f
        ball2.speed = 0f //nar man ska kontrollera en av bollarna samaste speed vara 0
        ball2.posY = 400f
        ball1.paint.color = Color.RED
        ball2.paint.color = Color.GREEN


    }

    fun start() {
        running = true
        thread =
            Thread(this) //en trad har en konstruktor som tar in en runnable, vilket sker i denna klass se rad 10
        thread?.start()
    }

    fun stop() {
        running = false
        try {
            thread?.join() //join betyder att huvudtraden komemr vanta in att traden dor ut av sig sjalv
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun update() {
        ball1.update()
        ball2.update()
    }
    //med denna kod kan jag rora pa boll2 som star stilla annars
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val vX = event?.x.toString() //ett satt att hantera att en vill ha null och en nonnull versioner av datatyperna
        val vY = event?.y.toString()
        ball2.posX = vX.toFloat()
        ball2.posY = vY.toFloat()
        return true
       // return super.onTouchEvent(event)

    }


    fun draw() {
        canvas = holder!!.lockCanvas()
        canvas.drawColor(Color.BLUE)
        ball1.draw(canvas)
        ball2.draw(canvas)
        holder!!.unlockCanvasAndPost(canvas)
    }
 //dessa startar och stoppar min thread:
    override fun surfaceCreated(holder: SurfaceHolder) {
        start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stop()
    }

    //run/metoden ar en metod som vi fick fran interface Runnable och ar kopplat till dess Thread.Run anropas nar vi kor Thread.start()
    //den kor en while loop med var running variable pch anropar update och draw:
    override fun run() {
        while (running) {
            update()
            draw()
        }
    }

}