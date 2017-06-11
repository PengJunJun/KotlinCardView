package cardview.com.cardviewtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

class CardViewLayoutManager(context: Context) : RecyclerView.LayoutManager() {

    val DEFAULT_ITEM_OFFSET = 30
    val DEFAULT_DISPLAY_ITEM = 3
    var screenWidth: Int? = 0
    var screenHeight: Int? = 0
    var mCurrDisplayIndex = 0
    var mRecycler: RecyclerView.Recycler? = null

    init {
        val metrics = context.resources.displayMetrics
        screenHeight = metrics.heightPixels
        screenWidth = metrics.widthPixels
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        detachAndScrapAttachedViews(recycler)
        mRecycler = recycler
        while(mCurrDisplayIndex < itemCount){
            val view = recycler?.getViewForPosition(mCurrDisplayIndex)
            addView(view)
            measureChildWithMargins(view, 0, 0)
            fillChild(view)
        }
        mCurrDisplayIndex = 0
    }

    fun fillChild(view: View?) {
        val width = view?.measuredWidth
        val height = view?.measuredHeight
        val left = ((screenWidth as Int - width as Int) / 2)
        val top = ((screenHeight as Int - height as Int) / 2 - (mCurrDisplayIndex * DEFAULT_ITEM_OFFSET))
        layoutDecoratedWithMargins(view, left, top, (left + width), (top + height))
        mCurrDisplayIndex++
    }
}