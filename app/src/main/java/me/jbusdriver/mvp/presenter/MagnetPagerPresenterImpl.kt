package me.jbusdriver.mvp.presenter

import me.jbusdriver.base.mvp.presenter.BasePresenterImpl
import me.jbusdriver.mvp.MagnetPagerContract

class MagnetPagerPresenterImpl : BasePresenterImpl<MagnetPagerContract.MagnetPagerView>(), MagnetPagerContract.MagnetPagerPresenter {
    override fun lazyLoad() {
        onFirstLoad()
    }
}