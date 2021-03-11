package pdp.uz.a8_1androidlessons

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog_view.*
import kotlinx.android.synthetic.main.custom_dialog_view.view.*
import kotlinx.android.synthetic.main.fragment_my_dialog.*
import kotlinx.android.synthetic.main.fragment_my_dialog.view.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        alert_dialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val create = builder.create()
            create.setMessage("Kotlin, Java, Android Studio")
            create.setTitle("Android Development")
            create.show()
        }

        custom_dialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val create = builder.create()
            create.setCancelable(false)
            val custonView = layoutInflater.inflate(R.layout.custom_dialog_view, null, false)
            create.setView(custonView)
            custonView.ok_btn.setOnClickListener {
                create.dismiss()
            }
            create.show()

        }

        fragment_dialog.setOnClickListener {
            val beginTransaction = supportFragmentManager.beginTransaction()
            val myDialogFragment = MyDialogFragment.newInstance("Dialog1", "Dialog2")
            val root = layoutInflater.inflate(R.layout.fragment_my_dialog, null, false)
            root.cancel_btn.setOnClickListener {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show()
            }

            myDialogFragment.show(beginTransaction, "dialog1")

        }
        date_picker_dialog.setOnClickListener {
            val datePicker = DatePickerDialog(this)
            datePicker.show()

        }
        time_picker_dialog.setOnClickListener {
            val timePickerDialog =
                TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

                    }

                }, 12, 21, true)
            timePickerDialog.show()
        }
        bottom_sheet_dialog.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val inflate = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null, false)
            bottomSheetDialog.setContentView(inflate)
            bottomSheetDialog.show()
        }

        snackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Text label", Snackbar.LENGTH_LONG)

            snackbar.setAction("Action", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Undo", Toast.LENGTH_SHORT).show()
                }

            })
            snackbar.show()
        }
    }
}