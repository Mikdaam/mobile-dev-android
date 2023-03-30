package fr.android.dicegameactivity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class DiceGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_game)

        val button = findViewById<Button>(R.id.button)
        val text = findViewById<TextView>(R.id.textView)
        var count = 0;
        val colors = mapOf(
            1 to Color.rgb(125,165,95),
            2 to Color.rgb(215, 156, 59),
            3 to Color.rgb(231, 225, 145),
            4 to Color.rgb(52, 92, 102),
            5 to Color.rgb(12, 32, 65),
            6 to Color.rgb(85, 45,31)
        )

        text.setOnClickListener {
            val diceValue = (1..6).random()
            count++
            text.text = resources.getString(R.string.dice_text, diceValue)
            colors[diceValue]?.let { v -> text.setBackgroundColor(v) }
        }

        button.setOnClickListener {
            val toast = Toast.makeText(this, "Let's quit the activity", Toast.LENGTH_SHORT)
            toast.show()
            val intent = Intent(this, FortuneActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}