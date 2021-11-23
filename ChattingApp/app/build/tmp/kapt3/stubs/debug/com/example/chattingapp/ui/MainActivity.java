package com.example.chattingapp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/chattingapp/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/example/chattingapp/databinding/ActivityMainBinding;", "chatListFragment", "Lcom/example/chattingapp/ui/navigation/ChattingListFragment;", "companyList", "Ljava/util/ArrayList;", "Lcom/example/chattingapp/data/model/Corporation;", "Lkotlin/collections/ArrayList;", "getCompanyList", "()Ljava/util/ArrayList;", "setCompanyList", "(Ljava/util/ArrayList;)V", "companyListFragment", "Lcom/example/chattingapp/ui/navigation/CompanyListFragment;", "mypageFragment", "Lcom/example/chattingapp/ui/navigation/MypageFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "MainActivity";
    private com.example.chattingapp.databinding.ActivityMainBinding binding;
    private com.example.chattingapp.ui.navigation.ChattingListFragment chatListFragment;
    private com.example.chattingapp.ui.navigation.CompanyListFragment companyListFragment;
    private com.example.chattingapp.ui.navigation.MypageFragment mypageFragment;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.chattingapp.data.model.Corporation> companyList;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.chattingapp.data.model.Corporation> getCompanyList() {
        return null;
    }
    
    public final void setCompanyList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.chattingapp.data.model.Corporation> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}