package gratigny.guillaume.deezeralbum.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gratigny.guillaume.deezeralbum.R
import gratigny.guillaume.deezeralbum.models.TrackData
import java.util.concurrent.TimeUnit

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

        viewHolder.title.text = specificTitle.title.trim()
        viewHolder.number.text = specificTitle.track_position.toString().trim() + "."


        val time = String.format("%d:%d",
            TimeUnit.SECONDS.toMinutes(specificTitle.duration.toLong()),
            TimeUnit.SECONDS.toSeconds(specificTitle.duration.toLong()) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(specificTitle.duration.toLong()))
        )
        viewHolder.duration.text = time
    }

    internal class TrackListRecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.track_title)
        var number: TextView = itemView.findViewById(R.id.track_number)
        var duration: TextView = itemView.findViewById(R.id.duration)
    }
}