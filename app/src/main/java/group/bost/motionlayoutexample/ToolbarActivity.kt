package group.bost.motionlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import group.bost.motionlayoutexample.recyclerview.ListAdapter
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        ivHome.setOnClickListener { finish() }
        recyclerview.adapter = ListAdapter()
    }

}
