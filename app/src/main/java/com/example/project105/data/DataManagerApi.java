package com.example.project105.data;

import com.example.project105.data.db.DbHelper;
import com.example.project105.data.network.ApiHelper;
import com.example.project105.data.prefs.PreferencesHelper;

public interface DataManagerApi extends PreferencesHelper, ApiHelper, DbHelper {

}
