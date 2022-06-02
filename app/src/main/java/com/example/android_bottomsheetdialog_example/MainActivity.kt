package com.example.android_bottomsheetdialog_example

import android.content.DialogInterface
import android.os.Bundle
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_bottomsheetdialog_example.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button1.setOnClickListener {
            BottomSheetDialog(this).apply {
                behavior.run {
                    state = BottomSheetBehavior.STATE_EXPANDED
                    skipCollapsed = true
                }
                setOnShowListener { dialogInterface: DialogInterface ->
                    (dialogInterface as BottomSheetDialog).findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)?.let { frameLayout: FrameLayout ->
                        frameLayout.layoutParams = frameLayout.layoutParams.apply {
                            height = WindowManager.LayoutParams.MATCH_PARENT
                        }
                    }
                }
                setContentView(
                        layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog, null)
                )
            }.show()
        }

        binding.button2.setOnClickListener {
            BottomSheetDialogFragment().show(supportFragmentManager, null)
        }

        binding.button3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(binding.frame.id, BottomSheetDialogFragment()).commit()
        }
    }

}