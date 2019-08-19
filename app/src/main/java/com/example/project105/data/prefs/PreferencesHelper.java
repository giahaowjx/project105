package com.example.project105.data.prefs;

public interface PreferencesHelper {

    boolean getCurrentLoginState();

    void setCurrentLoginState(boolean state);

    Long getCurrentUserId();

    void setCurrentUserId(Long id);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserPass();

    void setCurrentUserPass(String password);

    void setEmailToIdMap(String email, long id);

    Long getIdUsingEmail(String email);

    void deleteEmailToIdMap(String email);

    void resetCurrentLoginInfo();

}
