package api.app.weather.layout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Fischer on 2016/9/21.
 */
public class ItemSpaceDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ItemSpaceDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildPosition(view) != 0){
            outRect.top =space;
            outRect.left =space;
            outRect.bottom =space;
            outRect.right =space;
        }
    }
}
