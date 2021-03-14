package com.kprotasov.test.cooking.view.image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kprotasov.test.cooking.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_view.view.*

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var imageList = mutableListOf<String>()
    private var onImageClickListener: OnImageClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_view, parent, false)
        )

    override fun getItemCount(): Int =
        imageList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position], onImageClickListener)
    }

    fun setImageList(imageList: List<String>) {
        this.imageList.clear()
        this.imageList.addAll(imageList)
        notifyDataSetChanged()
    }

    fun setOnImageClickListener(listener: OnImageClickListener) {
        this.onImageClickListener = listener
    }

    class ImageViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(imageLink: String, onImageClickListener: OnImageClickListener?) {
            Picasso.get()
                .load(imageLink)
                .placeholder(R.drawable.image_placeholder)
                .into(view.imageView)

            view.setOnClickListener{
                onImageClickListener?.onImageClicked(imageLink)
            }
        }
    }

}