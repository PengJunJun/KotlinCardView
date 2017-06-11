package cardview.com.cardviewtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by pengjunjun on 2017/5/27.
 */
class CardViewAdapter(var context: Context, var cardList: ArrayList<String>) : RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {

    var resArray = mutableListOf<Int>(R.mipmap.card, R.mipmap.card1, R.mipmap.card2,R.mipmap.card3)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cardview, null))
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        holder?.imageView?.background = context.resources.getDrawable(resArray.get(index = position))
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView? = null;

        init {
            imageView = itemView.findViewById(R.id.imageView) as ImageView
        }
    }

    fun onItemMove(position: Int?){
        val last = resArray[position as Int]
        resArray.removeAt(position)
        resArray.add(0,last)
        notifyDataSetChanged()
    }

    fun onItemBack(position: Int?){
        val last = resArray[0]
        resArray.removeAt(0)
        resArray.add(last)
        notifyDataSetChanged()
    }
}