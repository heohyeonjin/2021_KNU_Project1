package com.example.chattingapp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/example/chattingapp/ui/ChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ChatActivityRecycleview", "Landroidx/recyclerview/widget/RecyclerView;", "datas", "", "Lcom/example/chattingapp/data/model/Chat;", "getDatas", "()Ljava/util/List;", "viewAdapter", "Lcom/example/chattingapp/adapter/ChatRoomAdapter;", "getViewAdapter", "()Lcom/example/chattingapp/adapter/ChatRoomAdapter;", "setViewAdapter", "(Lcom/example/chattingapp/adapter/ChatRoomAdapter;)V", "initRecycler", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ChatActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.chattingapp.adapter.ChatRoomAdapter viewAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.chattingapp.data.model.Chat> datas = null;
    private androidx.recyclerview.widget.RecyclerView ChatActivityRecycleview;
    
    public ChatActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chattingapp.adapter.ChatRoomAdapter getViewAdapter() {
        return null;
    }
    
    public final void setViewAdapter(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.adapter.ChatRoomAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.chattingapp.data.model.Chat> getDatas() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRecycler() {
    }
}