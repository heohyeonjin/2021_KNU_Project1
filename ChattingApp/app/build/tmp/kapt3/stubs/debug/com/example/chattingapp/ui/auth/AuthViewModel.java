package com.example.chattingapp.ui.auth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020DJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020HJ\u0006\u0010J\u001a\u00020DJ\u0006\u0010K\u001a\u00020DR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R \u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0$\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0$8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010&R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040$8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010&R\u001a\u00100\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\u001fR \u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR \u00106\u001a\b\u0012\u0004\u0012\u0002070\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR \u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR \u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR \u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0019\"\u0004\bB\u0010\u001b\u00a8\u0006L"}, d2 = {"Lcom/example/chattingapp/ui/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_signInLoading", "Landroidx/lifecycle/MutableLiveData;", "", "_signInResponse", "Lcom/example/chattingapp/data/model/SignUpForm;", "_signUpLoading", "_signUpResponse", "authSignInListener", "Lcom/example/chattingapp/ui/auth/AuthListener;", "getAuthSignInListener", "()Lcom/example/chattingapp/ui/auth/AuthListener;", "setAuthSignInListener", "(Lcom/example/chattingapp/ui/auth/AuthListener;)V", "authSignUpListener", "getAuthSignUpListener", "setAuthSignUpListener", "isSelected", "Landroidx/databinding/ObservableField;", "()Landroidx/databinding/ObservableField;", "setSelected", "(Landroidx/databinding/ObservableField;)V", "networkErrorString", "getNetworkErrorString", "setNetworkErrorString", "(Ljava/lang/String;)V", "signInEmail", "getSignInEmail", "setSignInEmail", "signInLoading", "Landroidx/lifecycle/LiveData;", "getSignInLoading", "()Landroidx/lifecycle/LiveData;", "signInPassword", "getSignInPassword", "setSignInPassword", "signInResponse", "getSignInResponse", "signUpLoading", "getSignUpLoading", "signUpResponse", "getSignUpResponse", "signUpResponseCode", "getSignUpResponseCode", "setSignUpResponseCode", "signupEmail", "getSignupEmail", "setSignupEmail", "signupGender", "", "getSignupGender", "setSignupGender", "signupName", "getSignupName", "setSignupName", "signupPassword", "getSignupPassword", "setSignupPassword", "signupPhone", "getSignupPhone", "setSignupPhone", "checkSignInField", "", "checkSignUpFeild", "getSharedPreference", "postSignIn", "Lkotlinx/coroutines/Job;", "postSignUP", "removeEditText", "setSignInLoadingFalse", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AuthViewModel";
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signupName;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signupPassword;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signupEmail;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signupPhone;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.Integer> signupGender;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String signUpResponseCode = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signInEmail;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.String> signInPassword;
    @org.jetbrains.annotations.NotNull()
    private androidx.databinding.ObservableField<java.lang.Boolean> isSelected;
    @org.jetbrains.annotations.Nullable()
    private com.example.chattingapp.ui.auth.AuthListener authSignUpListener;
    @org.jetbrains.annotations.Nullable()
    private com.example.chattingapp.ui.auth.AuthListener authSignInListener;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String networkErrorString = "\ub124\ud2b8\uc6cc\ud06c \uc5f0\uacb0\uc744 \ud655\uc778\ud574 \uc8fc\uc138\uc694.";
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _signUpResponse = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _signUpLoading = null;
    private final androidx.lifecycle.MutableLiveData<com.example.chattingapp.data.model.SignUpForm> _signInResponse = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.chattingapp.data.model.SignUpForm> signInResponse = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _signInLoading = null;
    
    public AuthViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignupName() {
        return null;
    }
    
    public final void setSignupName(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignupPassword() {
        return null;
    }
    
    public final void setSignupPassword(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignupEmail() {
        return null;
    }
    
    public final void setSignupEmail(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignupPhone() {
        return null;
    }
    
    public final void setSignupPhone(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.Integer> getSignupGender() {
        return null;
    }
    
    public final void setSignupGender(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSignUpResponseCode() {
        return null;
    }
    
    public final void setSignUpResponseCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignInEmail() {
        return null;
    }
    
    public final void setSignInEmail(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getSignInPassword() {
        return null;
    }
    
    public final void setSignInPassword(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.Boolean> isSelected() {
        return null;
    }
    
    public final void setSelected(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ObservableField<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.chattingapp.ui.auth.AuthListener getAuthSignUpListener() {
        return null;
    }
    
    public final void setAuthSignUpListener(@org.jetbrains.annotations.Nullable()
    com.example.chattingapp.ui.auth.AuthListener p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.chattingapp.ui.auth.AuthListener getAuthSignInListener() {
        return null;
    }
    
    public final void setAuthSignInListener(@org.jetbrains.annotations.Nullable()
    com.example.chattingapp.ui.auth.AuthListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNetworkErrorString() {
        return null;
    }
    
    public final void setNetworkErrorString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getSignUpResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getSignUpLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job postSignUP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.chattingapp.data.model.SignUpForm> getSignInResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getSignInLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job postSignIn() {
        return null;
    }
    
    public final void checkSignInField() {
    }
    
    public final void checkSignUpFeild() {
    }
    
    public final void removeEditText() {
    }
    
    public final void getSharedPreference() {
    }
    
    public final void setSignInLoadingFalse() {
    }
}