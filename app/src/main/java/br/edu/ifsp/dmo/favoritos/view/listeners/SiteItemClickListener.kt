package br.edu.ifsp.dmo.favoritos.view.listeners

interface SiteItemClickListener {
    fun clickSiteItem(position: Int)
    fun clickHeartSiteItem(position : Int)

    fun clickDeleteSiteItem(position: Int)

}