package com.agh.mymci

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.core.widget.addTextChangedListener
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var edtphone: EditText
    lateinit var btnsub: Button
    lateinit var edtcheck : EditText
    lateinit var btnlog : Button

    private val sharedPrefFile = "sharedpreference"

    val rnds = (1000..9999).random()

    private val CHANNEL_ID = "5"
    private val notificationId = 101
    private lateinit var mediaPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtphone = findViewById(R.id.edtphone)
        btnsub = findViewById(R.id.btnsub)
        edtcheck = findViewById(R.id.edtcheck)
        btnlog = findViewById(R.id.btnlog)
        val btnbaste = findViewById<Button>(R.id.btnbaste)
        val txtrec = findViewById<TextView>(R.id.txtrecphone)
        val txthed = findViewById<TextView>(R.id.txtheader)
        val txtshownet = findViewById<TextView>(R.id.txtshownet)
        val txtshownet0 = findViewById<TextView>(R.id.txtshownet0)
        val frame1 = findViewById<FrameLayout>(R.id.framelogin)
        val frame2 = findViewById<FrameLayout>(R.id.framecheck)
        val frame3 = findViewById<FrameLayout>(R.id.frameinfo)
        val txtrezshow = findViewById<TextView>(R.id.txtrezervshow)
        val btnkharid = findViewById<Button>(R.id.btnkharid)

        mediaPlayer = MediaPlayer.create(this, R.raw.beep)


//----------------------------------------------------------------------

        frame1.visibility = View.VISIBLE
        frame2.visibility = View.GONE
        frame3.visibility = View.GONE

        edtphone.background = roundedCornersDrawable(
            2.dpToPixels(applicationContext), // border width in pixels
            Color.TRANSPARENT, // border color
            10.dpToPixels(applicationContext).toFloat() // corners radius
        )

        edtcheck.background = roundedCornersDrawable2(
            2.dpToPixels2(applicationContext), // border width in pixels
            Color.TRANSPARENT, // border color
            10.dpToPixels2(applicationContext).toFloat() // corners radius
        )

        btnsub.isEnabled = false
        btnlog.isEnabled = false

        //txtshownet.setText(" 2.01 گیگ \n\n از \n 2.01 گیگ ")

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, MODE_PRIVATE)

//----------------------------------------------------------------------

        btnsub.setOnClickListener {

            if (!edtphone.text.toString().equals("") && edtphone.text.toString()
                    .startsWith("09") && edtphone.text.length == 11
            ) {

                val phone: String = edtphone.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("phone", phone)
                editor.apply()
                editor.commit()
                val sharedphone = sharedPreferences.getString("phone", "defaultname")
                txtrec.setText(" لطفا کد ارسال شده به شماره ${sharedphone} را وارد کنید ").toString()
                txthed.setText("${sharedphone}               ")
                frame1.visibility = View.GONE
                frame2.visibility = View.VISIBLE
                createNotificationChannel()
                sendNotification()
                mediaPlayer.start()

            } else {

                Toast.makeText(this, "شماره وارد نشده یا صحیح نیست", Toast.LENGTH_SHORT).show()

            }

        }

        btnlog.setOnClickListener {


            if(edtcheck.text.toString() == rnds.toString()){

                Toast.makeText(getApplicationContext(), "ورود با موفقیت انجام شد", Toast.LENGTH_LONG).show();
                frame2.visibility = View.GONE
                frame3.visibility = View.VISIBLE
                mediaPlayer.start()

            }else{

                Toast.makeText(getApplicationContext(), "کد وارد شده اشتباه است", Toast.LENGTH_LONG).show();

            }


        }

        btnbaste.setOnClickListener {

            val builder = AlertDialog.Builder(this).create()
            val view =layoutInflater.inflate(R.layout.activity_scrolllist, null)

            val txt1=view.findViewById<TextView>(R.id.txt1)
            val txt2=view.findViewById<TextView>(R.id.txt2)
            val txt3=view.findViewById<TextView>(R.id.txt3)
            val txt4=view.findViewById<TextView>(R.id.txt4)
            val txt5=view.findViewById<TextView>(R.id.txt5)
            val txt6=view.findViewById<TextView>(R.id.txt6)
            val txt7=view.findViewById<TextView>(R.id.txt7)
            val txt8=view.findViewById<TextView>(R.id.txt8)
            val txt9=view.findViewById<TextView>(R.id.txt9)
            val txt10=view.findViewById<TextView>(R.id.txt10)
            val txt11=view.findViewById<TextView>(R.id.txt11)
            val txt12=view.findViewById<TextView>(R.id.txt12)
            val txt13=view.findViewById<TextView>(R.id.txt13)
            val btn1=view.findViewById<Button>(R.id.btn1)
            val btn2=view.findViewById<Button>(R.id.btn2)
            val btn3=view.findViewById<Button>(R.id.btn3)
            val btn4=view.findViewById<Button>(R.id.btn4)
            val btn5=view.findViewById<Button>(R.id.btn5)
            val btn6=view.findViewById<Button>(R.id.btn6)
            val btn7=view.findViewById<Button>(R.id.btn7)
            val btn8=view.findViewById<Button>(R.id.btn8)
            val btn9=view.findViewById<Button>(R.id.btn9)
            val btn10=view.findViewById<Button>(R.id.btn10)
            val btn11=view.findViewById<Button>(R.id.btn11)
            val btn12=view.findViewById<Button>(R.id.btn12)
            val btn13=view.findViewById<Button>(R.id.btn13)

            mediaPlayer.start()

            btn1.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt1.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn2.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt2.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn3.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt3.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn4.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt4.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn5.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt5.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn6.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt6.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn7.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt7.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn8.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt8.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn9.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt9.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn10.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt10.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn11.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt11.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn12.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt12.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }
            btn13.setOnClickListener {
                Toast.makeText(getApplicationContext(), "بسته با موفقیت رزرو شد", Toast.LENGTH_LONG).show();
                val baste: String = txt13.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("baste", baste)
                editor.apply()
                editor.commit()
                val sharedbaste = sharedPreferences.getString("baste", "defaultname")
                txtrezshow.setText("${sharedbaste}").toString()
                btnkharid.visibility = View.VISIBLE
                mediaPlayer.start()
                btnkharid.setOnClickListener {
                    txtshownet.visibility = View.VISIBLE
                    txtshownet0.visibility = View.GONE
                    btnkharid.visibility = View.GONE
                    txtshownet.setText("${sharedbaste}")
                    txtrezshow.setText(" بسته با موفقیت خریداری شد \n ممنون از خرید شما ")
                    mediaPlayer.start()
                }
            }

            builder.setView(view)
            builder.show()

        }

//----------------------------------------------------------------------

        edtphone.addTextChangedListener(TextWatcher)
        edtcheck.addTextChangedListener(TextWatcher2)

    }

    private val TextWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (edtphone.text.length == 11) {

                btnsub.setBackgroundColor(Color.parseColor("#00AECD"))
                btnsub.setTextColor(Color.parseColor("#FFFFFF"))
                btnsub.isEnabled = true

            }else{

                btnsub.setBackgroundColor(Color.parseColor("#CECECE"))
                btnsub.setTextColor(Color.parseColor("#7B7B7B"))
                btnsub.isEnabled = false

            }

        }
    }

    private val TextWatcher2 = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (edtcheck.text.length == 4) {

                btnlog.setBackgroundColor(Color.parseColor("#00AECD"))
                btnlog.setTextColor(Color.parseColor("#FFFFFF"))
                btnlog.isEnabled = true

            }else{

                btnlog.setBackgroundColor(Color.parseColor("#CECECE"))
                btnlog.setTextColor(Color.parseColor("#7B7B7B"))
                btnlog.isEnabled = false

            }

        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "test"
            val descriptionText = "test"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {


        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("برای ورود به برنامه کد زیر را وارد کنید")
            .setContentText(rnds.toString())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }


}

//----------------------------------------------------------------------

fun roundedCornersDrawable(
    borderWidth: Int = 0, // border width in pixels
    borderColor: Int = Color.TRANSPARENT, // border color
    cornerRadius: Float = 25F, // corner radius in pixels
    bgColor: Int = Color.parseColor("#E8EAED") // view background color
): Drawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        setStroke(borderWidth, borderColor)
        setColor(bgColor)
        // make it rounded corners
        this.cornerRadius = cornerRadius
    }
}

fun Int.dpToPixels(context: Context):Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
).toInt()


fun roundedCornersDrawable2(
    borderWidth: Int = 0, // border width in pixels
    borderColor: Int = Color.TRANSPARENT, // border color
    cornerRadius: Float = 25F, // corner radius in pixels
    bgColor: Int = Color.parseColor("#E9EAEE") // view background color
): Drawable {
    return GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        setStroke(borderWidth, borderColor)
        setColor(bgColor)
        // make it rounded corners
        this.cornerRadius = cornerRadius
    }
}

fun Int.dpToPixels2(context: Context):Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
).toInt()

//----------------------------------------------------------------------


