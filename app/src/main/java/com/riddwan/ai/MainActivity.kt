package com.riddwan.ai

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import android.graphics.Typeface

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.rgb(10, 10, 20)
        window.navigationBarColor = Color.rgb(10, 10, 20)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(24, 30, 24, 24)
        layout.setBackgroundColor(Color.rgb(10, 10, 20))

        val title = TextView(this)
        title.text = "RIDD WAN AI"
        title.textSize = 30f
        title.setTextColor(Color.rgb(180, 100, 255))
        title.typeface = Typeface.DEFAULT_BOLD
        title.gravity = Gravity.CENTER
        layout.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "Your AI Study Assistant"
        subtitle.textSize = 14f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 8, 0, 30)
        layout.addView(subtitle)

        val question = EditText(this)
        question.hint = "Tulis pertanyaan lu di sini..."
        question.setHintTextColor(Color.GRAY)
        question.setTextColor(Color.WHITE)
        question.textSize = 16f
        question.gravity = Gravity.TOP
        question.minLines = 4
        question.setPadding(16, 16, 16, 16)
        question.setBackgroundColor(Color.rgb(30, 25, 45))
        layout.addView(
            question,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val button = Button(this)
        button.text = "ANALISIS PERTANYAAN"
        layout.addView(button)

        val result = TextView(this)
        result.text = "Jawaban akan tampil di sini."
        result.textSize = 16f
        result.setTextColor(Color.WHITE)
        result.setPadding(8, 24, 8, 8)
        layout.addView(result)

        button.setOnClickListener {
            val text = question.text.toString().trim()
            result.text = if (text.isEmpty()) {
                "Masukkan pertanyaan terlebih dahulu."
            } else {
                "Pertanyaan lu:\n$text\n\nAI belum terhubung. Kita akan menambahkan koneksi AI setelah aplikasi berhasil dibuat."
            }
        }

        setContentView(layout)
    }
}
