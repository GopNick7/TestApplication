package com.chisw.testapplication.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chisw.testapplication.R
import com.chisw.testapplication.data.net.model.Hit
import com.chisw.testapplication.model.SelectableModel
import com.chisw.testapplication.utils.parseISO8601Time
import kotlinx.android.synthetic.main.item_story.view.*

/**
 * Created by Nikita R. on 22.12.2018.
 */
class StoryAdapter(private val listener: (SelectableModel<Hit>, position: Int) -> Unit) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    private var storyList = mutableListOf<SelectableModel<Hit>>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryAdapter.StoryViewHolder(view)
    }

    override fun getItemCount(): Int = storyList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(storyList[position], listener)
    }

    fun showAllStory(data: List<SelectableModel<Hit>>) {
        this.storyList.addAll(data)
        notifyDataSetChanged()
    }

    fun getChecked(): Int {
        var countIsChecked = 0
        storyList.forEach { story ->
            if (story.isSwitched) {
                countIsChecked++
            }
        }
        return countIsChecked
    }

    fun setChecked(storySelectableModel: SelectableModel<Hit>, position: Int) {
        storyList[position].isSwitched = storySelectableModel.isSwitched
        notifyItemChanged(position)
    }

    class StoryViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(storyList: SelectableModel<Hit>, listener: (SelectableModel<Hit>, position: Int) -> Unit) {
            itemView.tvTitle.text = storyList.data.title
            itemView.tvCreatedAt.text = storyList.data.createdAt!!.parseISO8601Time().toString()
            itemView.btnSwitch.isChecked = storyList.isSwitched
            itemView.btnSwitch.setOnClickListener { listener(storyList, adapterPosition) }
        }
    }
}