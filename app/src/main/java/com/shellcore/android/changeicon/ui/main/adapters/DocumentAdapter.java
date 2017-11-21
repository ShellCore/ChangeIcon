package com.shellcore.android.changeicon.ui.main.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shellcore.android.changeicon.R;
import com.shellcore.android.changeicon.entities.Document;
import com.shellcore.android.changeicon.libs.base.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MOGC on 21/11/2017.
 */

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {

    // Services
    private ImageLoader imageLoader;

    // Variables
    private int selectedItem = -1;
    private List<Document> documents;
    private DocumentSelectedListener listener;


    public DocumentAdapter(ImageLoader imageLoader, List<Document> documents, DocumentSelectedListener listener) {
        this.imageLoader = imageLoader;
        this.documents = documents;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_list_element, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Document document = documents.get(position);
        holder.document = document;
        holder.txtDocumentName.setText(document.getName());
        imageLoader.loadDrawableVector(holder.imgStatus, getStatusIconSource(document.getStatus()));
        if (selectedItem == position) {
             holder.txtDocumentName.setTextColor(holder.itemView.getResources().getColor(R.color.colorAccent));
        } else {
             holder.txtDocumentName.setTextColor(holder.itemView.getResources().getColor(R.color.secondary_text_light));
        }
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    private int getStatusIconSource(int status) {
        switch (status) {
            case Document.WAIT:
                return R.drawable.ic_wait;
            case Document.SEND:
                return R.drawable.ic_upload;
            case Document.DONE:
                return R.drawable.ic_done;
            case Document.ERROR:
                return R.drawable.ic_error;
            default:
                return R.drawable.ic_wait;
        }
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Variable
        Document document;

        // Components
        @BindView(R.id.crd_container)
        CardView crdContainer;
        @BindView(R.id.txt_document_name)
        TextView txtDocumentName;
        @BindView(R.id.img_status)
        ImageView imgStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.crd_container)
        public void onClickCardContainer() {
            if (listener != null) {
                listener.onDocumentSelected(document);
                selectedItem = getAdapterPosition();
                notifyDataSetChanged();
            }
        }
    }
}
