package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout

lateinit var GridView : GridView
lateinit var icnlist : List<GridViewModel>
lateinit var tabicon1 : ImageView
lateinit var tabicon2 : ImageView
lateinit var tabicon3 : ImageView
class Home_Screen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.orange)
        }
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION   // Hide navigation bar
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY // Make it reappear with a swipe
                // or View.SYSTEM_UI_FLAG_FULLSCREEN      // Hide the status bar as well
                )
        setContentView(R.layout.activity_home_screen)

        GridView = findViewById(R.id.icongridview)
        tabicon1 = findViewById(R.id.tabicon1)
        tabicon2 = findViewById(R.id.tabicon2)
        tabicon3 = findViewById(R.id.tabicon3)

        tabicon1.setOnClickListener {
            tabicon1.setBackgroundResource(R.drawable.tabstyle)
            tabicon2.setBackgroundResource(R.color.orange)
            tabicon3.setBackgroundResource(R.color.orange)
        }
        tabicon2.setOnClickListener {
            tabicon2.setBackgroundResource(R.drawable.tabstyle)
            tabicon1.setBackgroundResource(R.color.orange)
            tabicon3.setBackgroundResource(R.color.orange)
        }
        tabicon3.setOnClickListener {
            tabicon3.setBackgroundResource(R.drawable.tabstyle)
            tabicon2.setBackgroundResource(R.color.orange)
            tabicon1.setBackgroundResource(R.color.orange)
        }

        icnlist =ArrayList<GridViewModel>()

        icnlist = icnlist +GridViewModel(R.drawable.constructionbudget,"Construction Cost")
        icnlist = icnlist +GridViewModel(R.drawable.areagraph1,"Carpet \nArea")
        icnlist = icnlist +GridViewModel(R.drawable.cement1,"Cement Concrete")
        icnlist = icnlist +GridViewModel(R.drawable.plastering1,"Plaster Calculator")
        icnlist = icnlist +GridViewModel(R.drawable.brickwall1,"Brick Masanory")
        icnlist = icnlist +GridViewModel(R.drawable.blocks1,"Concrete Block")
        icnlist = icnlist +GridViewModel(R.drawable.fence1,"Boundary Wall")
        icnlist = icnlist +GridViewModel(R.drawable.wood1,"Flooring Calculator")
        icnlist = icnlist +GridViewModel(R.drawable.watertower,"Tank\n Volume")
        icnlist = icnlist +GridViewModel(R.drawable.airconditioner,"Air Conditioner")
        icnlist = icnlist +GridViewModel(R.drawable.solarpower1,"Solar \nRooftop")
        icnlist = icnlist +GridViewModel(R.drawable.heater1,"Solar Water Heater")
        icnlist = icnlist +GridViewModel(R.drawable.rollerbrush1,"Paint\n Work")
        icnlist = icnlist +GridViewModel(R.drawable.excavator1,"Excavation Calculator")
        icnlist = icnlist +GridViewModel(R.drawable.frame1,"Wood Framing")

        val adapter = AdapterGridView(iconlist = icnlist,this@Home_Screen)
        GridView.adapter = adapter


        GridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            var intentCarpet_Area                = Intent(this@Home_Screen,Carpet_Area::class.java)
            var intentconstructioncost           = Intent(this@Home_Screen,Constrution_Cost::class.java)
            var intentCement_Concrete_Calculator = Intent(this@Home_Screen,Cement_Concrete_Calculator::class.java)
            var intentplaster_Calculator = Intent (this@Home_Screen,Plaster_calculator::class.java)
            var intentBrick_Masanory = Intent (this@Home_Screen,Brick_Masanory::class.java)
            var intentConcrete_Block_Calculator = Intent (this@Home_Screen,Concrete_Block_Calculator::class.java)
            var intent_boundary_wall_Calculator = Intent (this@Home_Screen,Boundary_Wall::class.java)
            var intent_Flooring_Calculator = Intent (this@Home_Screen,Flooring_Calculator::class.java)
            var intent_Tank_volume_Calculator = Intent (this@Home_Screen,Tank_volume_calculator::class.java)
            var intent_Air_Conditioner_Calculator = Intent (this@Home_Screen,Air_Conditioner_Calculator::class.java)
            var intent_Solar_Rooftop_Calculator = Intent (this@Home_Screen,Solar_Rooftop::class.java)
            var intent_Solar_Water_Heater = Intent (this@Home_Screen,Solar_Water_Heater::class.java)

            when(position)
            {
                0 -> startActivity(intentconstructioncost)
                1 -> startActivity(intentCarpet_Area)
                2 -> startActivity(intentCement_Concrete_Calculator)
                3 -> startActivity(intentplaster_Calculator)
                4 -> startActivity(intentBrick_Masanory)
                5 -> startActivity(intentConcrete_Block_Calculator)
                6 -> startActivity(intent_boundary_wall_Calculator)
                7 -> startActivity(intent_Flooring_Calculator)
                8 -> startActivity(intent_Tank_volume_Calculator)
                9 -> startActivity(intent_Air_Conditioner_Calculator)
                10 -> startActivity(intent_Solar_Rooftop_Calculator)
                11 -> startActivity(intent_Solar_Water_Heater)
            }
        }

    }
}