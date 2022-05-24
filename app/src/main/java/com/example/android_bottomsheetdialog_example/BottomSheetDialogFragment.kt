package com.example.android_bottomsheetdialog_example

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import com.example.android_bottomsheetdialog_example.databinding.FragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetDialogBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme).apply {
            setOnShowListener { dialogInterface: DialogInterface ->
                (dialogInterface as BottomSheetDialog).findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)?.let { frameLayout: FrameLayout ->
                    BottomSheetBehavior.from(frameLayout).run {
                        state = BottomSheetBehavior.STATE_EXPANDED
                        skipCollapsed = true
                    }

                    frameLayout.layoutParams = frameLayout.layoutParams.apply {
                        height = WindowManager.LayoutParams.MATCH_PARENT
                    }
                }
            }
        }
    }

}