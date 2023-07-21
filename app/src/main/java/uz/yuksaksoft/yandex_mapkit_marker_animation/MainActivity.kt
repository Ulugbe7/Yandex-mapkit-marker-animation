package uz.yuksaksoft.yandex_mapkit_marker_animation

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import uz.yuksaksoft.yandex_mapkit_marker_animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(this);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapView.map.move(
            CameraPosition(
                Point(55.751574, 37.573856),
                11f,
                0f,
                0f
            ),
            Animation(Animation.Type.SMOOTH, 3000f),
            null
        )

        binding.mapView.map.addCameraListener { map, cameraPosition, cameraUpdateReason, b ->
//            Log.d("TTT", b.toString())
            if (b) {
                binding.imgMarker.animate().translationY(0f).translationZ(0f)
                    .setDuration(500)
                    .setInterpolator(DecelerateInterpolator()).start()
            } else {
                binding.imgMarker.animate().translationY(-100f).translationZ(30f)
                    .setDuration(500)
                    .setInterpolator(DecelerateInterpolator()).withEndAction {}.start()
            }
        }
    }
}