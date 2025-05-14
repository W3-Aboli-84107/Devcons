package com.example.app_emp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreManager {

        private static final String SHARED_PREF_NAME = "user_pref";
        private static final String KEY_EMAIL = "email";
        private static final String KEY_PASSWORD = "password";
        private static final String KEY_REMEMBER = "remember";

        private SharedPreferences sharedPreferences;
        private SharedPreferences.Editor editor;

        public SharedPreManager(Context context) {
            sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }

        public void saveLogin(String email, String password, boolean rememberMe) {
            editor.putString(KEY_EMAIL, email);
            editor.putString(KEY_PASSWORD, password);
            editor.putBoolean(KEY_REMEMBER, rememberMe);
            editor.apply();
        }

        public String getEmail() {
            return sharedPreferences.getString(KEY_EMAIL, "");
        }

        public String getPassword() {
            return sharedPreferences.getString(KEY_PASSWORD, "");
        }

        public boolean isRemembered() {
            return sharedPreferences.getBoolean(KEY_REMEMBER, false);
        }

        public void clear() {
            editor.clear();
            editor.apply();
        }
    }


