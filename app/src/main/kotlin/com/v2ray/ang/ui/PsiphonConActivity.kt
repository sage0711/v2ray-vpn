package com.v2ray.ang.ui;

import android.os.Bundle
import com.v2ray.ang.databinding.ActivityPsiphonConBinding
import com.v2ray.ang.ui.BaseActivity

class PsiphonConActivity : BaseActivity() {

    private lateinit var binding: ActivityPsiphonConBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPsiphonConBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "Psiphon Mode"

        // Display the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
