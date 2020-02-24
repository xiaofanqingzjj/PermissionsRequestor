package com.example.permissionsrequestor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.testpermission2.PermissionByMyPermissionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.ll_container, PermissionByMyPermissionsFragment()).commit()
    }
}
