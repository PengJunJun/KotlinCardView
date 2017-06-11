package cardview.com.cardviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardList = ArrayList<String>()
        cardList.add("String")
        cardList.add("Boolean")
        cardList.add("Double")
        cardList.add("Char")

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val cardAdapter = CardViewAdapter(this, cardList)
        val cardLayoutManager = CardViewLayoutManager(this)
        recyclerView.layoutManager = cardLayoutManager
        recyclerView.adapter = cardAdapter

        val itemTouchHelp = ItemTouchHelper(CardTouchCallback(cardAdapter,cardLayoutManager))
        itemTouchHelp.attachToRecyclerView(recyclerView)
    }
}
