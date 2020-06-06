# KotlinAndroidApp
## Basic COVID-19 STATUS App with RecyclerView
## Concepts of Kotlin used in App:
1. ***Constants:***
	- Package Name: 
	  	- package com.example.finalkotlinproject.CustomZoom
	- companion object is used to define constant values for the Class ZoomCenter
	  (companion object for constants: It's singleton object in the class having single instance only)
	- Eg:
	  ```
	  companion object {
        const val sShrinkAmount = 0.15f
        const val sShrinkDistance = 0.9f
      }
	  ```
2. ***Nullability***
	- Package Name:
	  	- package com.example.finalkotlinproject.Model
	  	- package com.example.finalkotlinproject.HelpAdapter
	  	- package com.example.finalkotlinproject.TeamAdapter
	- In all Data Class/Adapter nullability check is added using `?` or `!!`
	  (`?` - check if the value is not null while using it along with variable)
	  (`!!` - It's not null operator which convert to non-null type and throws Null Pointer Exception if it's null) 

3. ***Inheritence***
	- Activity:
	  	- MainActivity
	  	- ExploreTeams
	  	- PrecautionActivity
	  	- ExploreHelp
	- All activity extends AppCompatActivity Class and override the functionality of it using override keyword
	- Eg:
	  ```
	  class MainActivity : AppCompatActivity() {
    	override fun onCreate(savedInstanceState: Bundle?) {
        	super.onCreate(savedInstanceState)
        	setContentView(R.layout.activity_main)
        	discover_button.setOnClickListener(){
            	val discover_intent = Intent(this,ExploreTeams::class.java)
            	supertartActivity(discover_intent)
        	}
        	precaution_button.setOnClickListener(){
            	val precaution_intent = Intent(this,PrecautionActivity::class.java )
            	startActivity(precaution_intent)
        	}
        	help_button.setOnClickListener(){
            	val help_intent = Intent(this,ExploreHelp::class.java)
            	startActivity(help_intent)
        	}
        }
      }
      ```
4. ***Data Class***
	- Package Name:
	  	- package com.example.finalkotlinproject.Model
    - CustomTeams.kt Kotlin file has 2 Data Class : CustomTeams, HelpNumbers
    - Both Data Class is the Object which holds data to be used by TeamAdapter and HelpAdapter Class repectively
    - The Data Class are instantiate using the CustomTeams(<data>) and HelpNumbers(<data>) which initialise the object holding passed data

5. ***Compact Functions***
	- Package Name:
	  	- package com.example.finalkotlinproject.HelpAdapter
	  	- package com.example.finalkotlinproject.TeamAdapter
    - Abstract function "getItemCount()" returns result which is single expression 
    - Hence we can avoid the {} and return statement and is used = to return the expression(here it's return the size of ArrayList passed to Adapter) 
    - Eg:
      `override fun getItemCount(): Int = teams.size`  

6. ***Abtract Class***
	- Package Name:
		- package com.example.finalkotlinproject.TeamAdapter
		- package com.example.finalkotlinproject.HelpAdapter
	- Both TeamAdapter and HelpAdapter are subclasses which are implementing the abstract properties of Abstract Class Adapter
	  (methods that has to be implemented by subclasses are onCreateViewHolder(),getItemCount(),onBindViewHolder() as they are abstarct method of Parent Class)

7. ***Extention Function***
    - Package Name:
      	- package com.example.finalkotlinproject.TeamAdapter
	  	- package com.example.finalkotlinproject.HelpAdapter
	- In extention function we can add functionality to the existing function of the Class
	- Here infalting property is added to ViewGroup Class using dot notation i.e ViewGroup.inflate(layoutIdentifier:Int)
	- So in onCreateViewHolder() function , only inflate function need to be called on parent ViewGroup	      
    - Eg: 
      `fun ViewGroup.inflate(layoutR: Int) : View = LayoutInflater.from(context).inflate(layoutR,this,false)`

8. ***filters***
    - Package Name:
      - package com.example.finalkotlinproject.TeamAdapter
    - Here in App ,filter is applied on String to filter out only digits part of it
    - Filter condition is added in `{}` and `it` refers to each item of String
    - Eg:
      `val totalCase  = h.itemView.description1.text.toString().filter { it.isDigit() }`
9. ***Interface***
	- Package Name:
	    - package com.example.finalkotlinproject.HelpAdapter
	- Here the method onRequestPermissionsResult() of interface 'OnRequestPermissionsResultCallback' from class 'ActivityCompat' is implemented
	- Eg:
	```
	class HelpAdapter(val context: Context, private val helpnumbers:ArrayList<HelpNumbers>,val requestCall: Int) :  RecyclerView.Adapter<RecyclerView.ViewHolder>(),ActivityCompat.OnRequestPermissionsResultCallback
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)        
	{
	   if(requestCode == requestCall) makeCall()
	}
	```

10. ***Annotation***
	- Package Name: 
	    - package com.example.finalkotlinproject.HelpAdapter
	- SuppressLint annotation specifies that for the given function ignore the specified Warnings given in the String form
	- Eg:
	  ```
	  @SuppressLint("MissingPermission")
          private fun makeCall(){
           val callIn = Intent(Intent.ACTION_CALL)
           callIn.data = Uri.parse("tel:" + callNumber)
           mContext.startActivity(callIn)
          }
	  ```

## Working of App:

- ***Name***: COVID19-STATUS
- ***Description***:
  - Stats Button:
    - The redirection give the basic stats of total,current,death cases(data is refered and not live data) of countries
    - The status button pop-ups the window showing status is critical or not critical based total cases evaluation
    (Picasso is used to load images of countries flags though url's, Hence require internet)
  - Precaution Button:
    - The redirection give the list of steps that can be followed to prevent the infection
  - Help Button:
    - The redirection give the list of emergency numbers of different State and Union Territory of India. 
    - On clicking to any number of respective State/Union Territory it redirect to make a Phone call
   
