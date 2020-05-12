package group.bost.motionlayoutexample.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.Fragment
import group.bost.motionlayoutexample.R
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        if (savedInstanceState == null) {
            fragment = FirstFragment().also {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commitNow()
            }
        }

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                fragment?.let {
                    if (it is SecondFragment) it.motionLayout?.progress = p3
                }
            }

            override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
                super.onTransitionTrigger(motionLayout, triggerId, positive, progress)
                if (positive) {
                    openFragment(SecondFragment())
                } else {
                    openFragment(FirstFragment())
                }
            }
        })
    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
//        transaction.setCustomAnimations(
//            android.R.animator.fade_in,
//            android.R.animator.fade_out
//        )
        this.fragment = fragment.also {
            transaction
                .replace(R.id.container, it)
                .commitNow()
        }
    }

}
