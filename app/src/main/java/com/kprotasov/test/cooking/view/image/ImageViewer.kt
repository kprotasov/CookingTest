package com.kprotasov.test.cooking.view.image

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.kprotasov.test.cooking.R
import kotlinx.android.synthetic.main.image_viewer.view.*

class ImageViewer(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var currentImage: Int = 1
    private var totalImageCount: Int = 1

    init {
        orientation = VERTICAL

        val view = LayoutInflater.from(context)
            .inflate(R.layout.image_viewer, this, false)
        addView(view)
    }

    fun setImages(images: List<String>, onImageClickListener: OnImageClickListener) {
        totalImageCount = images.size

        imageViewPager.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(imageViewPager)

        initAdapter(images, onImageClickListener)

        imageViewPager.scrollToPosition(currentImage - 1)

        initListeners()

        updateImageCount(currentImage, totalImageCount)
    }

    private fun initAdapter(images: List<String>, onImageClickListener: OnImageClickListener) {
        val adapter = ImageAdapter()
        adapter.setImageList(images)
        adapter.setOnImageClickListener(onImageClickListener)
        imageViewPager.adapter = adapter
    }

    private fun initListeners() {
        imageViewPager.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val position = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    onPageSelected(position)
                }
            }
        })
    }

    private fun onPageSelected(position: Int) {
        currentImage = position + 1
        updateImageCount(currentImage, totalImageCount)
    }

    private fun updateImageCount(currentImage: Int, totalImageCount: Int) {
        itemCountTextView.text = context.resources.getString(
            R.string.image_count_placeholder,
            currentImage.toString(),
            totalImageCount.toString()
        )
    }

    override fun onSaveInstanceState(): Parcelable? {
        val state = super.onSaveInstanceState()
        val superState = SavedState(state)

        superState.currentImage = this.currentImage
        superState.totalImageCount = this.totalImageCount

        return superState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val savedState = state as SavedState
        super.onRestoreInstanceState(savedState.superState)

        this.currentImage = savedState.currentImage
        this.totalImageCount = savedState.totalImageCount
    }
}