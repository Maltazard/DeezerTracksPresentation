package gratigny.guillaume.deezeralbum.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gratigny.guillaume.deezeralbum.R
import gratigny.guillaume.deezeralbum.models.DeezerData

class MainRecyclerViewAdapater(context: Activity, dataList: List<DeezerData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext: Activity = context
    private var data: List<DeezerData> = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View =
            LayoutInflater.from(mContext).inflate(R.layout.main_recyclerview_adapter, parent, false)
        return MainRecyclerViewViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val albumImage = data[position]
        val viewHolder: MainRecyclerViewViewHolder = holder as MainRecyclerViewViewHolder

        Glide.with(mContext)
            .asDrawable()
            .load(albumImage.cover_big)
            .placeholder(
                ContextCompat.getDrawable(
                    mContext,
                    R.drawable.ic_launcher_foreground
                )
            ) //todo a changer plus tard & ajouter fade in
            .into(viewHolder.albumImage)

    }

    internal class MainRecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var albumImage: ImageView = itemView.findViewById(R.id.album_image)

    }

}