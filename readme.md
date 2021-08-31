

#  PermissionsRequestor

# 一个Android申请敏感权限的组件

## Description

一个快捷请求android敏感权限的库


# Usage

在你的项目里添加依赖：

```groovy
dependencies {
    api "com.github.xiaofanqingzjj:PermissionsRequestor:1.0.0"
}
```

请求权限

```kotlin


class DemoActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        

        val permissions = arrayOf(Manifest.permission.READ_CONTACTS)
        
        val permissionsRequestor = PermissionsRequestor(this)
        
        permissionsRequestor.request(
                permissions = permissions,
                onShowRationale = { process->
                   
                    AlertDialog.Builder(this@DemoActivity)
                        .setTitle("权限设置")
                        .setMessage("因为要XX，需要申请XXX权限。")
                        .setPositiveButton("授权", DialogInterface.OnClickListener { dialog, which ->
                            process.proced()
                        })
                        .setNegativeButton("不干了", DialogInterface.OnClickListener { dialog, which ->
                            process.cancel()   
                        }).create().show()
                },
                onGranted = {
                    toast("已正确授权")
                },
                onDeny = { withNeverAskAgain ->
                
                    if (withNeverAskAgain) {
                        toast("用户选了拒绝且勾选了不再提示")
                    } else {
                        toast("用户选了拒绝")
                        RuntimePermissionHelper.showStartPermissionsDeny(context =  this@PermissionByMyPermissionsActivity, onKnownItClickListener = View.OnClickListener {

                        }, onSetClickListener = View.OnClickListener {

                        // 继续请求
                        permissionsRequestor.requestDirect(permissions)

                        })
                    }
                   
                })
    }


    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}


```
