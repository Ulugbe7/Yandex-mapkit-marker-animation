package uz.yuksaksoft.yandex_mapkit_marker_animation

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("Your api key")
    }
}