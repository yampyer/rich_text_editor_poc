package co.jeanpidev.richtexteditor

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolitems.*
import kotlinx.android.synthetic.main.activity_main_third.*


class MainActivityThird : AppCompatActivity() {
    private var scrollerAtEnd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_third)

        initToolbar()
    }

    private fun initToolbar() {
        val bold: IARE_ToolItem = ARE_ToolItem_Bold()
        val italic: IARE_ToolItem = ARE_ToolItem_Italic()
        val underline: IARE_ToolItem = ARE_ToolItem_Underline()
        val strikethrough: IARE_ToolItem = ARE_ToolItem_Strikethrough()
        val quote: IARE_ToolItem = ARE_ToolItem_Quote()
        val listNumber: IARE_ToolItem = ARE_ToolItem_ListNumber()
        val listBullet: IARE_ToolItem = ARE_ToolItem_ListBullet()
        val hr: IARE_ToolItem = ARE_ToolItem_Hr()
        val link: IARE_ToolItem = ARE_ToolItem_Link()
        val subscript: IARE_ToolItem = ARE_ToolItem_Subscript()
        val superscript: IARE_ToolItem = ARE_ToolItem_Superscript()
        val left: IARE_ToolItem = ARE_ToolItem_AlignmentLeft()
        val center: IARE_ToolItem = ARE_ToolItem_AlignmentCenter()
        val right: IARE_ToolItem = ARE_ToolItem_AlignmentRight()
        val image: IARE_ToolItem = ARE_ToolItem_Image()
        val video: IARE_ToolItem = ARE_ToolItem_Video()
        val at: IARE_ToolItem = ARE_ToolItem_At()
        areToolbar.addToolbarItem(bold)
        areToolbar.addToolbarItem(italic)
        areToolbar.addToolbarItem(underline)
        areToolbar.addToolbarItem(strikethrough)
        areToolbar.addToolbarItem(quote)
        areToolbar.addToolbarItem(listNumber)
        areToolbar.addToolbarItem(listBullet)
        areToolbar.addToolbarItem(hr)
        areToolbar.addToolbarItem(link)
        areToolbar.addToolbarItem(subscript)
        areToolbar.addToolbarItem(superscript)
        areToolbar.addToolbarItem(left)
        areToolbar.addToolbarItem(center)
        areToolbar.addToolbarItem(right)
        areToolbar.addToolbarItem(image)
        areToolbar.addToolbarItem(video)
        areToolbar.addToolbarItem(at)
        arEditText.setToolbar(areToolbar)
        setHtml()
        initToolbarArrow()
    }

    private fun setHtml() {
        val html = """
            <p style="text-align: center;"><strong>New Feature in 0.1.2</strong></p>
            <p style="text-align: center;">&nbsp;</p>
            <p style="text-align: left;"><span style="color: #3366ff;">In this release, you have a new usage with ARE.</span></p>
            <p style="text-align: left;">&nbsp;</p>
            <p style="text-align: left;"><span style="color: #3366ff;">AREditText + ARE_Toolbar, you are now able to control the position of the input area and where to put the toolbar at and, what ToolItems you'd like to have in the toolbar. </span></p>
            <p style="text-align: left;">&nbsp;</p>
            <p style="text-align: left;"><span style="color: #3366ff;">You can not only define the Toolbar (and it's style), you can also add your own ARE_ToolItem with your style into ARE.</span></p>
            <p style="text-align: left;">&nbsp;</p>
            <p style="text-align: left;"><span style="color: #ff00ff;"><em><strong>Why not give it a try now?</strong></em></span></p>
            """.trimIndent()
        arEditText.fromHtml(html)
    }

    private fun initToolbarArrow() {
        val imageView: ImageView = findViewById(R.id.arrow)
        if (this.areToolbar is ARE_ToolbarDefault) {
            (areToolbar as ARE_ToolbarDefault).viewTreeObserver.addOnScrollChangedListener {
                val scrollX = (areToolbar as ARE_ToolbarDefault).scrollX
                val scrollWidth = (areToolbar as ARE_ToolbarDefault).width
                val fullWidth = (areToolbar as ARE_ToolbarDefault).getChildAt(0).width
                scrollerAtEnd = if (scrollX + scrollWidth < fullWidth) {
                    imageView.setImageResource(android.R.drawable.arrow_down_float)
                    false
                } else {
                    imageView.setImageResource(android.R.drawable.arrow_up_float)
                    true
                }
            }
        }
        imageView.setOnClickListener {
            scrollerAtEnd = if (scrollerAtEnd) {
                (areToolbar as ARE_ToolbarDefault).smoothScrollBy(-Int.MAX_VALUE, 0)
                false
            } else {
                val hsWidth = (areToolbar as ARE_ToolbarDefault).getChildAt(0).width
                (areToolbar as ARE_ToolbarDefault).smoothScrollBy(hsWidth, 0)
                true
            }
        }
    }
}