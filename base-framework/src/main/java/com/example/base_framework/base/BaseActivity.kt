package com.example.base_framework.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.util_framework.util.ColorUtils
import com.example.util_framework.util.StatusUtils

abstract class BaseActivity:AppCompatActivity(){

    private var acitivtyProvider:ViewModelProvider?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { setContentView(it) }
        setStatusColor()
        setSystemInvadeBlack()
        initViewModel()
        observe()
        init(savedInstanceState)
    }

    /**
     * 设置状态栏背景颜色
     */
    open fun setStatusColor() {
        StatusUtils.setUseStatusBarColor(this, ColorUtils.parseColor("#00ffffff"))
    }

    /**
     * 沉浸式状态
     */
    open fun setSystemInvadeBlack() {
        //第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。
        StatusUtils.setSystemStatus(this, true, true)
    }

    /**
     * 初始化viewModel
     * 之所以没有设计为抽象，是因为部分简单activity可能不需要viewModel
     * observe同理
     */
    open fun initViewModel() {
    }

    /**
     * 注册观察者
     */
    open fun observe() {

    }

    /**
     * 通过activity获取viewModel，跟随activity生命周期
     */
    protected fun<T:ViewModel> getActivityViewModel(modelClass:Class<T>):T?{
        if(acitivtyProvider!=null)
        {
            acitivtyProvider = ViewModelProvider(this)

        }
        return acitivtyProvider?.get(modelClass)
    }

    abstract fun getLayoutId():Int?

    /**
     * activity入口
     */
    abstract fun init(savedInstanceState: Bundle?)
}