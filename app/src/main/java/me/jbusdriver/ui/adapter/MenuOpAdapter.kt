package me.jbusdriver.ui.adapter

import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import jbusdriver.me.jbusdriver.R
import me.jbusdriver.base.mvp.bean.Expand_Type_Head
import me.jbusdriver.base.mvp.bean.Expand_Type_Item
import me.jbusdriver.base.mvp.ui.adapter.BaseMultiItemAppAdapter
import me.jbusdriver.mvp.bean.MenuOp
import me.jbusdriver.mvp.bean.MenuOpHead

/**
 * Created by Administrator on 2017/9/12 0012.
 */

class MenuOpAdapter(data: List<MultiItemEntity>) : BaseMultiItemAppAdapter<MultiItemEntity, BaseViewHolder>(data) {

    init {
        addItemType(Expand_Type_Head, R.layout.layout_menu_op_head)
        addItemType(Expand_Type_Item, R.layout.layout_menu_op_item)
    }


    override fun convert(holder: BaseViewHolder, item: MultiItemEntity) {
        when (item.itemType) {
            Expand_Type_Head -> {
                (item as? MenuOpHead)?.let { head ->
                    holder.setText(R.id.tv_nav_menu_name, " ${if (head.isExpanded) "👆" else "👉"} ${head.name}")
                    holder.itemView.setOnClickListener {
                        head.changeItemState(holder.adapterPosition)
                        holder.setText(R.id.tv_nav_menu_name, " ${if (head.isExpanded) "👆" else "👉"} ${head.name}")
                    }
                }
            }
            Expand_Type_Item -> {
                (item as? MenuOp)?.let {
                    holder.setText(R.id.tv_menu_op_name, it.name)
                            .setChecked(R.id.cb_nav_menu, it.isHow)
                }
            }
        }
    }

    private fun MenuOpHead.changeItemState(pos: Int) {
        if (this.isExpanded) {
            collapse(pos)
        } else {
            expand(pos)
        }
    }
}