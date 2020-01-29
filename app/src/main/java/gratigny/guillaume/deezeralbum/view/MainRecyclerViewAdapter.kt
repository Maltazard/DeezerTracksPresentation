package gratigny.guillaume.deezeralbum.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import gratigny.guillaume.deezeralbum.AdapterListener
import gratigny.guillaume.deezeralbum.R
import gratigny.guillaume.deezeralbum.models.DeezerData

class MainRecyclerViewAdapter(
    context: Activity,
    dataList: List<DeezerData>,
    listener: AdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext: Activity = context
    private var data: List<DeezerData> = dataList
    private val listener: AdapterListener? = listener

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
            .transform(RoundedCorners(16))
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(
                ContextCompat.getDrawable(
                    mContext,
                    R.drawable.ic_launcher_foreground
                )
            ) //todo placeholder ?
            .into(viewHolder.albumImage)

        holder.albumImage.setOnClickListener {
            listener?.onAlbumClicked(
                data[position]
            )
        }
    }


    internal class MainRecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var albumImage: ImageView = itemView.findViewById(R.id.album_image)
    }

}