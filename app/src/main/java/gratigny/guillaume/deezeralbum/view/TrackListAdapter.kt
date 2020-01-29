package gratigny.guillaume.deezeralbum.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gratigny.guillaume.deezeralbum.R
import gratigny.guillaume.deezeralbum.models.TrackData

class TrackListAdapter(
    context: Activity,
    dataList: List<TrackData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext: Activity = context
    private var data: List<TrackData> = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View =
            LayoutInflater.from(mContext).inflate(R.layout.track_list_adapter, parent, false)
        return TrackListRecyclerViewViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val specificTitle = data[position]
        val viewHolder: TrackListRecyclerViewViewHolder = holder as TrackListRecyclerViewViewHolder

        viewHolder.title.text = specificTitle.title
    }

    internal class TrackListRecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.track_title)
    }
}