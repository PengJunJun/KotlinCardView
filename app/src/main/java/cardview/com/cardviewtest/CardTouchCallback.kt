package cardview.com.cardviewtest

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

/**
 * Created by pengjunjun on 2017/5/27.
 */
class CardTouchCallback(var adapter: CardViewAdapter, var layoutManager: CardViewLayoutManager) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.DOWN or ItemTouchHelper.UP or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(recyclerView: RecyclerView?,
                        viewHolder: RecyclerView.ViewHolder?,
                        target: RecyclerView.ViewHolder?): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        adapter.onItemMove(viewHolder?.layoutPosition)
    }

    override fun onChildDraw(c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?,
                             dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}