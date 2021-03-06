/*
 * Copyright 2016 Victor Albertos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx_fcm.internal;

import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;

public class AppFcmListenerService extends FirebaseMessagingService {

    @Override public void onMessageReceived(RemoteMessage message){
        String from = message.getFrom();

        Bundle data = new Bundle();
        for (Map.Entry<String, String> entry : message.getData().entrySet()) {
            data.putString(entry.getKey(), entry.getValue());
        }

        RxFcm.Notifications.init(getApplication());
        RxFcm.Notifications.onNotificationReceived(from, data);
    }

}
