 package com.panda.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView

 class MainActivity : AppCompatActivity() {
     var operator="*"
     var oldResult=""
     var newOperator=true

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
     fun btnSayiTik(view: View){
         // Screen
         var dataScreen = findViewById<TextView>(R.id.dataScreen) as TextView

         if (newOperator){
             dataScreen.text=""
         }
         newOperator=false
         //NumberButtons
         val btn0 = findViewById<Button>(R.id.btn0)
         val btn1 = findViewById<Button>(R.id.btn1)
         val btn2 = findViewById<Button>(R.id.btn2)
         val btn3 = findViewById<Button>(R.id.btn3)
         val btn4 = findViewById<Button>(R.id.btn4)
         val btn5 = findViewById<Button>(R.id.btn5)
         val btn6 = findViewById<Button>(R.id.btn6)
         val btn7 = findViewById<Button>(R.id.btn7)
         val btn8 = findViewById<Button>(R.id.btn8)
         val btn9 = findViewById<Button>(R.id.btn9)
         val dot_button = findViewById<Button>(R.id.dot_button)
         val plus_minus_button = findViewById<Button>(R.id.plus_minus_button)



         var btnSec = view as Button
         var btnTikDeger:String = dataScreen.text.toString()


         when(btnSec.id){
             btn0.id->{
                 btnTikDeger+="0"
             }
             btn1.id->{
                 btnTikDeger+="1"
             }
             btn2.id->{
                 btnTikDeger+="2"
             }
             btn3.id->{
                 btnTikDeger+="3"
             }
             btn4.id->{
                 btnTikDeger+="4"
             }
             btn5.id->{
                 btnTikDeger+="5"
             }
             btn6.id->{
                 btnTikDeger+="6"
             }
             btn7.id->{
                 btnTikDeger+="7"
             }
             btn8.id->{
                 btnTikDeger+="8"
             }
             btn9.id->{
                 btnTikDeger+="9"
             }
             plus_minus_button.id->{
                 if(btnTikDeger.contains('-')){
                     //btnTikDeger = btnTikDeger.replace('-',' ')
                     btnTikDeger = btnTikDeger.removePrefix("-")
                 }else if (btnTikDeger.contains('+')) {
                     //btnTikDeger = btnTikDeger.replace('','-')
                     btnTikDeger = btnTikDeger.removePrefix("+")
                 }else{
                     btnTikDeger="-"+btnTikDeger
                 }

             }
             dot_button.id->{
                 btnTikDeger+="."
             }
         }
         dataScreen.setText(btnTikDeger)
     }

    fun btnAC(view: View){
        var btnSec = view as Button;
        var dataScreen = findViewById<TextView>(R.id.dataScreen) as TextView
        var acButton  = findViewById<Button>(R.id.ac_button) as Button
        when(btnSec.id){
            acButton.id->{
                dataScreen.text="0"
            }
        }
    }




     fun btnOpTik(view:View){
         var percentButton = findViewById<Button>(R.id.percent_button) as Button
         var vurmaButton = findViewById<Button>(R.id.vurma_button) as Button
         var divideButton = findViewById<Button>(R.id.divide_button) as Button
         var plusButton = findViewById<Button>(R.id.plus_button) as Button
         var minusButton = findViewById<Button>(R.id.minus_button) as Button
         var dataScreen = findViewById<TextView>(R.id.dataScreen) as TextView
         var btnSec = view as Button

         when(btnSec.id){
            divideButton.id->{
                operator="/"
            }
             vurmaButton.id->{
                 operator="*"
             }
             plusButton.id->{
                 operator="+"
             }
             minusButton.id->{
                 operator="-"
             }
             percentButton.id->{
                 operator="%"
             }
         }

         oldResult= dataScreen.text.toString()
         newOperator=true

     }




     fun btnEqualsClick(view:View){
         var dataScreen = findViewById<TextView>(R.id.dataScreen)
         var yeniSayi=dataScreen.text.toString()
         var sonuc:Double?=null

         when(operator){
             "/"->{
                 sonuc = oldResult.toDouble()/yeniSayi.toDouble()
             }
             "*"->{
                 sonuc = oldResult.toDouble()*yeniSayi.toDouble()
             }
             "-"->{
                 sonuc = oldResult.toDouble()-yeniSayi.toDouble()
             }
             "+"->{
                 sonuc = oldResult.toDouble()+yeniSayi.toDouble()
             }
             "%"->{
                 sonuc = (oldResult.toDouble()/100)*yeniSayi.toDouble()
             }
         }
         dataScreen.text=sonuc.toString()
         newOperator=true
     }


}