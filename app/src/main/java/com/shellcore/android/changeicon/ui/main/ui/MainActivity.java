package com.shellcore.android.changeicon.ui.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shellcore.android.changeicon.ChangeIconApplication;
import com.shellcore.android.changeicon.R;
import com.shellcore.android.changeicon.entities.Document;
import com.shellcore.android.changeicon.libs.base.ImageLoader;
import com.shellcore.android.changeicon.ui.main.adapters.DocumentAdapter;
import com.shellcore.android.changeicon.ui.main.adapters.DocumentSelectedListener;
import com.shellcore.android.changeicon.ui.main.di.MainComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DocumentSelectedListener {

    // Variables
    private List<Document> documents;
    private Document selectedDocument;
    private DocumentAdapter adapter;

    // Services
    @Inject
    ImageLoader imageLoader;

    // Components
    @BindView(R.id.rec_documents)
    RecyclerView recDocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeList();
        setupInjection();

        setupRecyclerView();
    }

    @OnClick(R.id.btn_wait)
    public void onClickBtnWait() {
        if (selectedDocument != null) {
            selectedDocument.setStatus(Document.WAIT);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @OnClick(R.id.btn_send)
    public void onClickBtnSend() {
        if (selectedDocument != null) {
            selectedDocument.setStatus(Document.SEND);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @OnClick(R.id.btn_done)
    public void onClickBtnEnd() {
        if (selectedDocument != null) {
            selectedDocument.setStatus(Document.DONE);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @OnClick(R.id.btn_error)
    public void onClickBtnError() {
        if (selectedDocument != null) {
            selectedDocument.setStatus(Document.ERROR);
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initializeList() {
        documents = new ArrayList<>();
        documents.add(new Document("Archivo 1", Document.WAIT));
        documents.add(new Document("Archivo 2", Document.SEND));
        documents.add(new Document("Archivo 3", Document.DONE));
        documents.add(new Document("Archivo 4", Document.ERROR));
    }

    private void setupInjection() {
        ChangeIconApplication app = (ChangeIconApplication) getApplication();
        MainComponent component = app.getMainComponent(this);
        component.inject(this);
    }

    private void setupRecyclerView() {
        adapter = new DocumentAdapter(imageLoader, documents, this);
        recDocuments.setLayoutManager(new LinearLayoutManager(this));
        recDocuments.setHasFixedSize(true);
        recDocuments.setAdapter(adapter);
    }

    @Override
    public void onDocumentSelected(Document document) {
        selectedDocument = document;
    }
}
