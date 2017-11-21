package com.shellcore.android.changeicon.libs;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shellcore.android.changeicon.libs.base.ImageLoader;

/**
 * Created By MOGC on 05/09/2017.
 */

public class GlideImageLoader implements ImageLoader {

    private RequestManager glideRequestManager;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public void load(ImageView view, String url) {
        glideRequestManager.load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(view);
    }

    @Override
    public void loadDrawableVector(ImageView view, int resourceId) {
        glideRequestManager.load("")
                .error(resourceId)
                .into(view);
    }
}
