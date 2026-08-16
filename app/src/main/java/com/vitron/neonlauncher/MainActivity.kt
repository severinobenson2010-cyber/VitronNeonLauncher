package com.vitron.neonlauncher

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var appAdapter: AppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.appList)
        recyclerView.layoutManager = GridLayoutManager(this, 4)

        loadApps()
    }

    private fun loadApps() {
        val pm: PackageManager = packageManager
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val apps = pm.queryIntentActivities(intent, 0)

        appAdapter = AppAdapter(apps, pm) { appInfo ->
            val launchIntent = pm.getLaunchIntentForPackage(appInfo.activityInfo.packageName)
            startActivity(launchIntent)
        }
        recyclerView.adapter = appAdapter
    }
}
