package com.tuwaiq.datepicker

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.*

const val DATE_PICKER_KEY = "date_picker"
class ShowDatePickerFragment : Fragment() , DatePickerDialogFragment.DatePickerCallback {

    private val dateFormat = "EEE, MMM dd, yyyy"

     private lateinit var dateBtn:Button
     private lateinit var showDate:TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view =  inflater.inflate(R.layout.fragment_show_date_picker, container,false)

        dateBtn = view.findViewById(R.id.date_btn)
        showDate = view.findViewById(R.id.show_date)

        return view
    }

    override fun onStart() {
        super.onStart()

        dateBtn.setOnClickListener{

            val args = Bundle()
            args.putSerializable(DATE_PICKER_KEY,dateBtn.toString())

            val datePicker = DatePickerDialogFragment()
            datePicker.arguments = args
             datePicker.setTargetFragment(this,0)


            datePicker.show(this.parentFragmentManager,"date picker")
        }
    }

    override fun onDateSelected(date: Date) {

        showDate.text = date.toString()
        showDate.text = DateFormat.format(dateFormat,date)

    }


}