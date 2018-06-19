package me.jbusdriver.interceptors

import android.util.Log
import com.billy.cc.core.component.CCResult
import com.billy.cc.core.component.Chain
import com.billy.cc.core.component.IGlobalCCInterceptor

/**
 * 示例全局拦截器：日志打印
 * @author billy.qi
 * @since 18/5/26 11:42
 */


class LogInterceptor : IGlobalCCInterceptor {
    private val TAG = "LogInterceptor"
    override fun priority() = 1

    override fun intercept(chain: Chain): CCResult {
        Log.i(TAG, "============log before:" + chain.cc)
        val result = chain.proceed()
        Log.i(TAG, "============log after:$result")
        return result
    }
}