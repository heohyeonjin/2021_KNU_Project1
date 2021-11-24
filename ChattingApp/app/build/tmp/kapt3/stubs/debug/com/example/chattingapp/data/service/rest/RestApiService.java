package com.example.chattingapp.data.service.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/chattingapp/data/service/rest/RestApiService;", "", "login", "Lcom/example/chattingapp/data/model/SignUpForm;", "signInForm", "Lcom/example/chattingapp/data/model/SignInForm;", "(Lcom/example/chattingapp/data/model/SignInForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signUp", "", "signUpForm", "(Lcom/example/chattingapp/data/model/SignUpForm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface RestApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.chattingapp.data.service.rest.RestApiService.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @error.NonExistentClass()
    public abstract java.lang.Object signUp(@org.jetbrains.annotations.NotNull()
    @error.NonExistentClass()
    com.example.chattingapp.data.model.SignUpForm signUpForm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @error.NonExistentClass()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    @error.NonExistentClass()
    com.example.chattingapp.data.model.SignInForm signInForm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.chattingapp.data.model.SignUpForm> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/chattingapp/data/service/rest/RestApiService$Companion;", "", "()V", "instance", "Lcom/example/chattingapp/data/service/rest/RestApiService;", "getInstance", "()Lcom/example/chattingapp/data/service/rest/RestApiService;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final com.example.chattingapp.data.service.rest.RestApiService instance = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chattingapp.data.service.rest.RestApiService getInstance() {
            return null;
        }
    }
}