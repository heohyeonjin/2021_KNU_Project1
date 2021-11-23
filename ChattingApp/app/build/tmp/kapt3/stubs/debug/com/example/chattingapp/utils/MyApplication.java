package com.example.chattingapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/example/chattingapp/utils/MyApplication;", "Landroid/app/Application;", "()V", "context", "Landroid/content/Context;", "onCreate", "", "Companion", "app_debug"})
public final class MyApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.chattingapp.utils.MyApplication.Companion Companion = null;
    public static com.example.chattingapp.utils.MySharedPreferences prefs;
    private static com.example.chattingapp.utils.MyApplication instance;
    
    public MyApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context context() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/chattingapp/utils/MyApplication$Companion;", "", "()V", "<set-?>", "Lcom/example/chattingapp/utils/MyApplication;", "instance", "getInstance", "()Lcom/example/chattingapp/utils/MyApplication;", "setInstance", "(Lcom/example/chattingapp/utils/MyApplication;)V", "prefs", "Lcom/example/chattingapp/utils/MySharedPreferences;", "getPrefs", "()Lcom/example/chattingapp/utils/MySharedPreferences;", "setPrefs", "(Lcom/example/chattingapp/utils/MySharedPreferences;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.utils.MySharedPreferences getPrefs() {
            return null;
        }
        
        public final void setPrefs(@org.jetbrains.annotations.NotNull()
        com.example.chattingapp.utils.MySharedPreferences p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.utils.MyApplication getInstance() {
            return null;
        }
        
        private final void setInstance(com.example.chattingapp.utils.MyApplication p0) {
        }
    }
}