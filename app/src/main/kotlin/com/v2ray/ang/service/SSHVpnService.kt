package com.v2ray.ang.service

import android.app.Service
import android.net.VpnService

import com.jcraft.jsch.Channel
import com.jcraft.jsch.ChannelDirectTCPIP
import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session

class SSHVpnService : VpnService(), ServiceControl {


    override fun onCreate() {
//        super.onCreate()
//        // Initialize JSch and set up the SSH connection
//        val jsch = JSch()
//        try {
//            sshSession = jsch.getSession("SERVER_USERNAME", "SERVER_IP", SERVER_PORT)
//        } catch (e: JSchException) {
//            throw RuntimeException(e)
//        }
//        sshSession.setPassword("SERVER_PASSWORD")
//        sshSession.setConfig("StrictHostKeyChecking", "no")
    }

    override fun getService(): Service {
        TODO("Not yet implemented")
    }

    override fun startService() {
        TODO("Not yet implemented")
    }

    override fun stopService() {
        TODO("Not yet implemented")
    }

    override fun vpnProtect(socket: Int): Boolean {
        TODO("Not yet implemented")
    }

    fun createSSHTunnel(
        sshHost: String,
        sshPort: Int,
        sshUsername: String,
        sshPassword: String,
        remoteHost: String,
        remotePort: Int,
        localPort: Int
    ) {
        val jsch = JSch()

        // Create an SSH session
        val session: Session = jsch.getSession(sshUsername, sshHost, sshPort)
        session.setPassword(sshPassword)

        // Avoid asking for key confirmation
        val config = java.util.Properties()
        config["StrictHostKeyChecking"] = "no"
        session.setConfig(config)

        // Connect to the SSH server
        session.connect()

        try {
            // Create a direct-tcpip channel (SSH tunnel)
            val channel: Channel = session.openChannel("direct-tcpip")
            val tunnel = channel as ChannelDirectTCPIP

            // Set up the tunnel parameters
            tunnel.setHost(remoteHost)
            tunnel.setPort(remotePort)
            tunnel.setLocalPort(localPort)

            // Connect the tunnel
            tunnel.connect()

            // The tunnel is now active and can be used for forwarding traffic
            println("SSH tunnel is established. Local port: $localPort, Remote host: $remoteHost, Remote port: $remotePort")

            // Your code to use the SSH tunnel goes here

        } finally {
            // Disconnect and clean up resources
            tunnel.disconnect()
            session.disconnect()
        }
    }
}
