package co.jeanpidev.richtexteditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebolo.krichtexteditor.fragments.kRichEditorFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editorFragment = kRichEditorFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.textEditor, editorFragment, "EDITOR")
            .commit()
    }
}