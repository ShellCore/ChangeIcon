package com.shellcore.android.changeicon.libs.base;

import android.widget.ImageView;

/**
 * Created By MOGC on 05/09/2017.
 */

public interface ImageLoader {

    void load(ImageView view, String url);
    void loadDrawableVector(ImageView view, int resourceId);
}
