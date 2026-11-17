package com.example.pertemuan9

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- 1. IMPLEMENTASI IMAGEVIEW[cite: 1] ---
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setImageResource(R.drawable.sample_image)

        // --- 2. IMPLEMENTASI VIDEOVIEW & MEDIACONTROLLER[cite: 1] ---
        val videoView: VideoView = findViewById(R.id.videoView)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.sample_video
        videoView.setVideoURI(Uri.parse(videoPath))

        // Menambahkan panel kontrol pemutaran video
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Menambahkan event listener saat video selesai diputar
        videoView.setOnCompletionListener {
            Toast.makeText(this, "Video selesai diputar!", Toast.LENGTH_SHORT).show()
        }

        videoView.requestFocus()
        videoView.start()

        // --- 3. MENYISIPKAN CUSTOMVIEW (CANVAS) KE DALAM LAYOUT[cite: 1] ---
        val canvasContainer: FrameLayout = findViewById(R.id.canvasContainer)
        val customView = CustomView(this)
        canvasContainer.addView(customView)

        // --- 4. IMPLEMENTASI ANIMASI GABUNGAN (ANIMATORSET)[cite: 1] ---
        fun playAnimations() {
            val fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f)
            val translate = ObjectAnimator.ofFloat(imageView, "translationY", -50f, 0f)
            val rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f)

            AnimatorSet().apply {
                playTogether(fadeIn, translate, rotate)
                duration = 1500
                start()
            }
        }

        // Jalankan animasi saat aplikasi pertama kali dibuka
        playAnimations()

        // Tombol untuk memicu animasi ulang
        val btnAnimate: Button = findViewById(R.id.btnAnimate)
        btnAnimate.setOnClickListener {
            playAnimations()
        }
    }
}