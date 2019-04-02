package com.infinixsoft.login.entity;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class UserPreferences {
    public static final String USER_PREFERENCES = "user_preferences";
    public static final String USER = "usuario";
    public static final String CONSTANT = "CONSTANT";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private User user;
    private Gson gson;
    private String json;

    public UserPreferences(Context context) {
        this.prefs = context.getSharedPreferences(this.USER_PREFERENCES, Context.MODE_PRIVATE);

        this.editor = prefs.edit();

        this.gson = new Gson();
        this.json = prefs.getString(USER, CONSTANT);

        if (this.json.equals(CONSTANT))
            this.user = null;
        else
            this.user = gson.fromJson(json, User.class);

    }

    public User getUser() {
        return this.user;
    }

    public void userLogged(Boolean state) {
        this.user.setLogged(state);
        this.setUser(this.user);
    }

    public void setUser(User user) {
        this.editor.putString(USER, this.gson.toJson(this.user, User.class));
        this.editor.commit();
    }

    public Person getPerson() {
        return this.user.getPersona();
    }
}
