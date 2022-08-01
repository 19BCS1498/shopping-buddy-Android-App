package util

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class MSPButton(context: Context, attrs: AttributeSet): AppCompatButton(context, attrs) {
    init {
        applyFont() //call function to apply font components
    }
    private fun applyFont(){
        // this function is used get file from assets folder and set it to title textview
        val typeface: Typeface = Typeface.createFromAsset(context.assets, "Montserrat-Bold.ttf")
        setTypeface(typeface)
    }
}
