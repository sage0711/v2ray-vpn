package com.v2ray.ang.ui;

import android.os.Bundle
import android.widget.ArrayAdapter
import com.v2ray.ang.databinding.ActivitySshConBinding
import com.v2ray.ang.ui.BaseActivity
import com.v2ray.ang.R

class SshConActivity : BaseActivity() {

    private lateinit var binding: ActivitySshConBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySshConBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "SSH Mode"

        // Display the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val ssh_protocols = resources.getStringArray(R.array.ssh_protocol_select)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ssh_protocols)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerSshProtocol.adapter = adapter
    }
}
