package com.example.chattingapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0007H\u0016J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0011H\u0016J\u0018\u0010\'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0007H\u0016J\u0014\u0010+\u001a\u00020#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u00061"}, d2 = {"Lcom/example/chattingapp/adapter/ChatRoomAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "user", "Lcom/example/chattingapp/data/model/User;", "(Lcom/example/chattingapp/data/model/User;)V", "CENTER_POSITION", "", "getCENTER_POSITION", "()I", "LEFT_POSITION", "getLEFT_POSITION", "RIGHT_POSITION", "getRIGHT_POSITION", "dateBinding", "Lcom/example/chattingapp/databinding/DetailDateBinding;", "lst", "", "Lcom/example/chattingapp/data/model/Chat;", "getLst", "()Ljava/util/List;", "messageIdToIdx", "Ljava/util/HashMap;", "getMessageIdToIdx", "()Ljava/util/HashMap;", "receiveBinding", "Lcom/example/chattingapp/databinding/DetailReceiveMsgBinding;", "sendBinding", "Lcom/example/chattingapp/databinding/DetailSendMsgBinding;", "getUser", "()Lcom/example/chattingapp/data/model/User;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMessages", "messages", "", "CenterViewHolder", "LeftViewHolder", "RightViewHolder", "app_debug"})
public final class ChatRoomAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.example.chattingapp.data.model.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.chattingapp.data.model.Chat> lst = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.HashMap<java.lang.Integer, java.lang.Integer> messageIdToIdx = null;
    private final int CENTER_POSITION = 0;
    private final int LEFT_POSITION = 1;
    private final int RIGHT_POSITION = 2;
    private com.example.chattingapp.databinding.DetailDateBinding dateBinding;
    private com.example.chattingapp.databinding.DetailReceiveMsgBinding receiveBinding;
    private com.example.chattingapp.databinding.DetailSendMsgBinding sendBinding;
    
    public ChatRoomAdapter(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.data.model.User user) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chattingapp.data.model.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.chattingapp.data.model.Chat> getLst() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.Integer, java.lang.Integer> getMessageIdToIdx() {
        return null;
    }
    
    public final int getCENTER_POSITION() {
        return 0;
    }
    
    public final int getLEFT_POSITION() {
        return 0;
    }
    
    public final int getRIGHT_POSITION() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setMessages(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.chattingapp.data.model.Chat> messages) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chattingapp/adapter/ChatRoomAdapter$CenterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/chattingapp/databinding/DetailDateBinding;", "(Lcom/example/chattingapp/adapter/ChatRoomAdapter;Lcom/example/chattingapp/databinding/DetailDateBinding;)V", "getBinding", "()Lcom/example/chattingapp/databinding/DetailDateBinding;", "app_debug"})
    public final class CenterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.chattingapp.databinding.DetailDateBinding binding = null;
        
        public CenterViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.chattingapp.databinding.DetailDateBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.databinding.DetailDateBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chattingapp/adapter/ChatRoomAdapter$LeftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/chattingapp/databinding/DetailReceiveMsgBinding;", "(Lcom/example/chattingapp/adapter/ChatRoomAdapter;Lcom/example/chattingapp/databinding/DetailReceiveMsgBinding;)V", "getBinding", "()Lcom/example/chattingapp/databinding/DetailReceiveMsgBinding;", "app_debug"})
    public final class LeftViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.chattingapp.databinding.DetailReceiveMsgBinding binding = null;
        
        public LeftViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.chattingapp.databinding.DetailReceiveMsgBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.databinding.DetailReceiveMsgBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chattingapp/adapter/ChatRoomAdapter$RightViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/chattingapp/databinding/DetailSendMsgBinding;", "(Lcom/example/chattingapp/adapter/ChatRoomAdapter;Lcom/example/chattingapp/databinding/DetailSendMsgBinding;)V", "getBinding", "()Lcom/example/chattingapp/databinding/DetailSendMsgBinding;", "app_debug"})
    public final class RightViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.chattingapp.databinding.DetailSendMsgBinding binding = null;
        
        public RightViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.chattingapp.databinding.DetailSendMsgBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.databinding.DetailSendMsgBinding getBinding() {
            return null;
        }
    }
}