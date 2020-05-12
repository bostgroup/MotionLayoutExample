package group.bost.motionlayoutexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import group.bost.motionlayoutexample.fragment.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSimple.setOnClickListener {
            startActivity(SimpleActivity::class.java)
        }
        btnCustomAttr.setOnClickListener {
            startActivity(CustomAttrsActivity::class.java)
        }
        btnKeyPosition.setOnClickListener {
            startActivity(KeyPositionActivity::class.java)
        }
        btnToolbar.setOnClickListener {
            startActivity(ToolbarActivity::class.java)
        }
        btnBottomSheet.setOnClickListener {
            startActivity(BottomSheetActivity::class.java)
        }
        btnFragment.setOnClickListener {
            startActivity(FragmentActivity::class.java)
        }
    }

    private fun <T> startActivity(cls: Class<T>) {
        startActivity(Intent(this, cls))
    }

}
