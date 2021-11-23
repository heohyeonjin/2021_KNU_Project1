package com.example.chattingapp.ui.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/example/chattingapp/ui/auth/SignInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/chattingapp/ui/auth/AuthListener;", "()V", "binding", "Lcom/example/chattingapp/databinding/ActivityLoginBinding;", "viewModel", "Lcom/example/chattingapp/ui/auth/AuthViewModel;", "getViewModel", "()Lcom/example/chattingapp/ui/auth/AuthViewModel;", "setViewModel", "(Lcom/example/chattingapp/ui/auth/AuthViewModel;)V", "viewModelFactory", "Lcom/example/chattingapp/ui/auth/AuthViewModelFactory;", "getViewModelFactory", "()Lcom/example/chattingapp/ui/auth/AuthViewModelFactory;", "setViewModelFactory", "(Lcom/example/chattingapp/ui/auth/AuthViewModelFactory;)V", "initViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "message", "", "type", "", "onStarted", "onSuccess", "app_debug"})
public final class SignInActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.chattingapp.ui.auth.AuthListener {
    private com.example.chattingapp.databinding.ActivityLoginBinding binding;
    public com.example.chattingapp.ui.auth.AuthViewModel viewModel;
    public com.example.chattingapp.ui.auth.AuthViewModelFactory viewModelFactory;
    
    public SignInActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chattingapp.ui.auth.AuthViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.ui.auth.AuthViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chattingapp.ui.auth.AuthViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.ui.auth.AuthViewModelFactory p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViewModel() {
    }
    
    @java.lang.Override()
    public void onStarted() {
    }
    
    @java.lang.Override()
    public void onSuccess() {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int type) {
    }
}