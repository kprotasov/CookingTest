package com.kprotasov.test.cooking.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.updateLayoutParams
import com.kprotasov.test.cooking.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_item.view.*

class PostImagesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr) {

    fun setImages(imageList: List<String>) {
        val size = imageList.size
        if (size == 1) {
            val imageView = createImageView()
            this.addView(imageView)

            val constraintSet = ConstraintSet()
            constraintSet.clone(this)
            constraintSet.connect(imageView.id, ConstraintSet.RIGHT, id, ConstraintSet.RIGHT, 0)
            constraintSet.connect(imageView.id, ConstraintSet.TOP, id, ConstraintSet.TOP, 0)
            constraintSet.connect(imageView.id, ConstraintSet.END, id, ConstraintSet.END, 0)
            constraintSet.connect(imageView.id, ConstraintSet.BOTTOM, id, ConstraintSet.BOTTOM, 0)
            constraintSet.applyTo(this)

            Picasso.get()
                .load(imageList[0])
                .placeholder(R.drawable.image_placeholder)
                .into(imageView)
        } else if (size == 2) {
            val imageViewRight = createImageView()
            this.addView(imageViewRight)
            val imageViewLeft = createImageView()
            this.addView(imageViewLeft)

            val constraintSet = ConstraintSet()
            constraintSet.clone(this)
            constraintSet.connect(imageViewRight.id, ConstraintSet.RIGHT, id, ConstraintSet.RIGHT, 0)
            constraintSet.connect(imageViewRight.id, ConstraintSet.TOP, id, ConstraintSet.TOP, 0)
            constraintSet.connect(imageViewRight.id, ConstraintSet.END, imageViewLeft.id, ConstraintSet.START, 0)
            constraintSet.connect(imageViewRight.id, ConstraintSet.BOTTOM, id, ConstraintSet.BOTTOM, 0)

            constraintSet.connect(imageViewLeft.id, ConstraintSet.RIGHT, imageViewRight.id, ConstraintSet.LEFT, 0)
            constraintSet.connect(imageViewLeft.id, ConstraintSet.TOP, id, ConstraintSet.TOP, 0)
            constraintSet.connect(imageViewLeft.id, ConstraintSet.END, imageViewLeft.id, ConstraintSet.END, 0)
            constraintSet.connect(imageViewLeft.id, ConstraintSet.BOTTOM, id, ConstraintSet.BOTTOM, 0)
            constraintSet.applyTo(this)

            Picasso.get()
                .load(imageList[0])
                .placeholder(R.drawable.image_placeholder)
                .into(imageViewRight)

            Picasso.get()
                .load(imageList[1])
                .placeholder(R.drawable.image_placeholder)
                .into(imageViewLeft)
        }
    }

    private fun createImageView(): ImageView {
        val imageView = ImageView(context)
        val layoutParams = ViewGroup.LayoutParams(0, 0)
        imageView.layoutParams = layoutParams
        imageView.id = View.generateViewId()
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        //imageView.setImageResource(R.drawable.image_placeholder)
        return imageView
    }
}