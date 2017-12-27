package pyxis.uzuki.live.desginratingbar

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Shader
import android.graphics.drawable.*
import android.graphics.drawable.shapes.RoundRectShape
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.RatingBar

open class DesignRatingBar constructor(context: Context, private val attrs: AttributeSet? = null) : RatingBar(context, attrs) {
    private val drawableShape = RoundRectShape(floatArrayOf(5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f), null, null)
    private var mSampleTile: Bitmap? = null

    var emptyIconRes: Int = R.drawable.ic_action_star_border
    var filledIconRes: Int = R.drawable.ic_action_star

    init {
        initView()

        progressDrawable = createLayerDrawable()
    }

    private fun initView() {
        if (attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DesignRatingBar) ?: return
        emptyIconRes = typedArray.getResourceId(R.styleable.DesignRatingBar_emptyIcon, R.drawable.ic_action_star_border)
        filledIconRes = typedArray.getResourceId(R.styleable.DesignRatingBar_filledIcon, R.drawable.ic_action_star)

        typedArray.recycle()
    }

    @Synchronized override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (mSampleTile != null) {
            val width = mSampleTile!!.width * numStars
            setMeasuredDimension(View.resolveSizeAndState(width, widthMeasureSpec, 0), measuredHeight)
        }
    }

    private fun createLayerDrawable(): LayerDrawable {
        val backgroundDrawable = createEmptyShape()
        val layerDrawable = LayerDrawable(arrayOf(backgroundDrawable, backgroundDrawable, createFilledShape()))
        layerDrawable.setId(0, android.R.id.background)
        layerDrawable.setId(1, android.R.id.secondaryProgress)
        layerDrawable.setId(2, android.R.id.progress)
        return layerDrawable
    }

    private fun createEmptyShape(): Drawable {
        val tileBitmap = ContextCompat.getDrawable(context, emptyIconRes)!!.toBitmap()
        if (mSampleTile == null) {
            mSampleTile = tileBitmap
        }
        return tileBitmap.getShapeDrawable()
    }

    private fun createFilledShape(): Drawable {
        val tileBitmap = ContextCompat.getDrawable(context, filledIconRes)!!.toBitmap()
        return ClipDrawable(tileBitmap.getShapeDrawable(), Gravity.START, ClipDrawable.HORIZONTAL)
    }

    private fun Drawable.toBitmap(): Bitmap {
        if (this is BitmapDrawable) {
            return this.bitmap
        }

        var width = this.intrinsicWidth
        width = if (width > 0) width else 1
        var height = this.intrinsicHeight
        height = if (height > 0) height else 1

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        this.setBounds(0, 0, canvas.width, canvas.height)
        this.draw(canvas)

        return bitmap
    }

    private fun Bitmap.getShapeDrawable(): Drawable = ShapeDrawable(drawableShape).apply {
        val bitmapShader = BitmapShader(this@getShapeDrawable, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP)
        paint.shader = bitmapShader
    }
}