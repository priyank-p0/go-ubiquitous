package com.example.android.sunshine.app.wear;

import android.util.Log;

import com.example.android.sunshine.app.sync.SunshineSyncAdapter;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;
/**
 * Created by priyankpatel on 8/27/16.
 */
public class wearservice extends WearableListenerService  {

        private static final String TAG = wearservice.class.getSimpleName();

        private static final String WEATHER_PATH = "/weather";

        @Override
        public void onDataChanged(DataEventBuffer dataEvents) {
            for (DataEvent dataEvent : dataEvents) {
                if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                    String path = dataEvent.getDataItem().getUri().getPath();
                    Log.d(TAG, path);
                    if (path.equals(WEATHER_PATH)) {
                        SunshineSyncAdapter.syncImmediately(this);
                    }
                }
            }
        }
    }


