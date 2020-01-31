package gratigny.guillaume.deezeralbum.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {

    /**
     * Create a padding on left, right and bottom at the size on spaceHeight
     */
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            left = spaceHeight
            right = spaceHeight
            bottom = spaceHeight
        }
    }
}