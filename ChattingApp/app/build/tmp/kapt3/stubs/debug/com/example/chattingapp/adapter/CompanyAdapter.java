package com.example.chattingapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/example/chattingapp/adapter/CompanyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/chattingapp/adapter/CompanyAdapter$Holder;", "companyList", "Ljava/util/ArrayList;", "Lcom/example/chattingapp/data/model/Corporation;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getCompanyList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_debug"})
public final class CompanyAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.chattingapp.adapter.CompanyAdapter.Holder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.chattingapp.data.model.Corporation> companyList = null;
    
    public CompanyAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chattingapp.data.model.Corporation> companyList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.chattingapp.data.model.Corporation> getCompanyList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.chattingapp.adapter.CompanyAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.adapter.CompanyAdapter.Holder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/example/chattingapp/adapter/CompanyAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/chattingapp/adapter/CompanyAdapter;Landroid/view/View;)V", "corpDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCorpDesc", "()Landroid/widget/TextView;", "corpLogo", "Landroid/widget/ImageView;", "getCorpLogo", "()Landroid/widget/ImageView;", "corpName", "getCorpName", "bind", "", "corp", "Lcom/example/chattingapp/data/model/Corporation;", "position", "", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView corpLogo = null;
        private final android.widget.TextView corpDesc = null;
        private final android.widget.TextView corpName = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final android.widget.ImageView getCorpLogo() {
            return null;
        }
        
        public final android.widget.TextView getCorpDesc() {
            return null;
        }
        
        public final android.widget.TextView getCorpName() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.chattingapp.data.model.Corporation corp, int position) {
        }
    }
}