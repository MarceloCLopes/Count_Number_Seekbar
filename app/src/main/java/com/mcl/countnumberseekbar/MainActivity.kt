package com.mcl.countnumberseekbar

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var initialTextViewTranslationY = textProgress.translationY

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                textProgress.text = progress.toString()

                val translationDistance =
                    (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textProgress.animate().translationY(translationDistance)

                if (!fromUser)
                    textProgress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        btnReset.setOnClickListener {
            seekBar.progress = 0
        }
    }
}