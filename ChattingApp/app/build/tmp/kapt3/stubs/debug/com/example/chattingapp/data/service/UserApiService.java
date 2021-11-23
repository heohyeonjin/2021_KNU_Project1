package com.example.chattingapp.data.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/chattingapp/data/service/UserApiService;", "", "restApiService", "Lcom/example/chattingapp/data/service/rest/RestApiService;", "(Lcom/example/chattingapp/data/service/rest/RestApiService;)V", "login", "Lcom/example/chattingapp/data/model/SignUpForm;", "signInForm", "Lcom/example/chattingapp/data/model/SignInForm;", "(Lcom/example/chattingapp/data/model/SignInForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "", "signUpForm", "(Lcom/example/chattingapp/data/model/SignUpForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class UserApiService {
    private final com.example.chattingapp.data.service.rest.RestApiService restApiService = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.chattingapp.data.service.UserApiService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.example.chattingapp.data.service.UserApiService instance = null;
    
    public UserApiService(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.data.service.rest.RestApiService restApiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object signUp(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.data.model.SignUpForm signUpForm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    com.example.chattingapp.data.model.SignInForm signInForm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.chattingapp.data.model.SignUpForm> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chattingapp/data/service/UserApiService$Companion;", "", "()V", "instance", "Lcom/example/chattingapp/data/service/UserApiService;", "getInstance", "()Lcom/example/chattingapp/data/service/UserApiService;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.data.service.UserApiService getInstance() {
            return null;
        }
    }
}