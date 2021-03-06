package com.example.gestiondesprojetspdagogiques

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class SemestreDut : AppCompatActivity() {

   // var id_projet:String = intent.getStringExtra("id_projet")

    private val conf : config= config()
    private var Base :String= conf.Base
    private val url: String = Base+"/projet-pedagogique/api/controller/addModule.php"

    lateinit var back : ImageView




    lateinit var suivant : Button

    lateinit var heure1 : EditText
    lateinit var heure2 : EditText
    lateinit var heure3 : EditText
    lateinit var heure4 : EditText
    lateinit var heure5 : EditText
    lateinit var heure6 : EditText
    lateinit var heure7 : EditText
    lateinit var heure8 : EditText


    lateinit var module1 : EditText
    lateinit var module2 : EditText
    lateinit var module3 : EditText
    lateinit var module4 : EditText
    lateinit var module5 : EditText
    lateinit var module6 : EditText
    lateinit var module7 : EditText
    lateinit var module8 : EditText






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semestre_dut)

        var id_projet:String = intent.getStringExtra("id")
        suivant = this.findViewById(R.id.suivant)

        heure1 = this.findViewById(R.id.heure1)
        heure2 = this.findViewById(R.id.heure2)
        heure3 = this.findViewById(R.id.heure3)
        heure4 = this.findViewById(R.id.heure4)
        heure5 = this.findViewById(R.id.heure5)
        heure6 = this.findViewById(R.id.heure6)
        heure7 = this.findViewById(R.id.heure7)
        heure8 = this.findViewById(R.id.heure8)


        module1 = this.findViewById(R.id.module1)
        module2 = this.findViewById(R.id.module2)
        module3 = this.findViewById(R.id.module3)
        module4 = this.findViewById(R.id.module4)
        module5 = this.findViewById(R.id.module5)
        module6 = this.findViewById(R.id.module6)
        module7 = this.findViewById(R.id.module8)
        module8 = this.findViewById(R.id.module9)

        back = this.findViewById(R.id.back)


        var maList : ArrayList<String> = ArrayList<String>(6)


        var maListHeure : ArrayList<String> = ArrayList<String>(6)

        var id_semestre :String ="1"











        suivant.setOnClickListener {

            // on recoit les modules et les heures
            maList.add(0,module1.text.toString())
            maList.add(1,module2.text.toString())
            maList.add(2,module3.text.toString())
            maList.add(3,module4.text.toString())
            maList.add(4,module5.text.toString())
            maList.add(5,module6.text.toString())
            maList.add(6,module7.text.toString())
            maList.add(7,module8.text.toString())

            maListHeure.add(0,heure1.text.toString())
            maListHeure.add(1,heure2.text.toString())
            maListHeure.add(2,heure3.text.toString())
            maListHeure.add(3,heure4.text.toString())
            maListHeure.add(4,heure5.text.toString())
            maListHeure.add(5,heure6.text.toString())
            maListHeure.add(6,heure7.text.toString())
            maListHeure.add(7,heure8.text.toString())

            Toast.makeText(applicationContext,maList.get(3).toString()+"use to string", Toast.LENGTH_LONG).show()


            for(j in 0 until 4 ){

                val queue = Volley.newRequestQueue(this)


                // Request a string response from the provided URL.
                val req = object : StringRequest(Request.Method.POST, url, Response.Listener <String> {

                        response1  ->
                    try {

                        val obj = JSONObject(response1)
                        val jsonArray: JSONArray = obj.getJSONArray("data")
                        var str_user: String = ""



                        for (i in 0 until jsonArray.length()) {
                            var jsonInner: JSONObject = jsonArray.getJSONObject(i)

                            id_projet =jsonInner.get("id_projet").toString()



                        }




                    } catch (e: JSONException){ e.printStackTrace()}
                    // condition si l'utilisateur n'a pas déja activer le compte ou b1 s'il existe comme prof ou admin

                    /*     if(id_cycle==1){
                             val intent = Intent(applicationContext, SemestreDut::class.java)
                             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             intent.putExtra("id_projet",id_projet)

                             startActivity(intent)


                         } else {
                             val intent = Intent(applicationContext, SemestreLicence::class.java)
                             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             intent.putExtra("id_projet",id_projet)

                             startActivity(intent)


                         } */


                },object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {

                        Toast.makeText(applicationContext,"error", Toast.LENGTH_LONG).show()
                        //   Toast.makeText(this, "Sorry !! ", Toast.LENGTH_LONG).show()}
                    }
                })   {

                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {

                        val params = HashMap<String,String>()

                            params.put("nom_module", maList.get(j))
                            params.put("nbr_heure", maListHeure.get(j))
                            params.put("id_semestre","1")
                            params.put("id_projet", id_projet)

                        return params
                    }


                }



                queue.add(req)
                queue.start()


            }



            for(j in 4 until maList.size ){

                val queue = Volley.newRequestQueue(this)


                // Request a string response from the provided URL.
                val req = object : StringRequest(Request.Method.POST, url, Response.Listener <String> {

                        response1  ->
                    try {

                        val obj = JSONObject(response1)
                        val jsonArray: JSONArray = obj.getJSONArray("data")
                        var str_user: String = ""



                        for (i in 0 until jsonArray.length()) {
                            var jsonInner: JSONObject = jsonArray.getJSONObject(i)

                            id_projet =jsonInner.get("id_projet").toString()



                        }




                    } catch (e: JSONException){ e.printStackTrace()}
                    // condition si l'utilisateur n'a pas déja activer le compte ou b1 s'il existe comme prof ou admin

                    /*     if(id_cycle==1){
                             val intent = Intent(applicationContext, SemestreDut::class.java)
                             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             intent.putExtra("id_projet",id_projet)

                             startActivity(intent)


                         } else {
                             val intent = Intent(applicationContext, SemestreLicence::class.java)
                             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             intent.putExtra("id_projet",id_projet)

                             startActivity(intent)


                         } */


                },object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {

                        Toast.makeText(applicationContext,"error", Toast.LENGTH_LONG).show()
                        //   Toast.makeText(this, "Sorry !! ", Toast.LENGTH_LONG).show()}
                    }
                })   {

                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {

                        val params = HashMap<String,String>()

                        params.put("nom_module", maList.get(j))
                        params.put("nbr_heure", maListHeure.get(j))
                        params.put("id_semestre","2")
                        params.put("id_projet", id_projet)

                        return params
                    }


                }



                queue.add(req)
                queue.start()

                val intent = Intent(applicationContext, SemestreDutDeux::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.putExtra("id", id_projet)

                startActivity(intent)

            }













        }







    }

















}