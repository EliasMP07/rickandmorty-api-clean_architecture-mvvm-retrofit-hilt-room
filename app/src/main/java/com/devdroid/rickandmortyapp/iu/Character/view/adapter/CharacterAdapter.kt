package com.devdroid.rickandmortyapp.iu.Character.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devdroid.rickandmortyapp.R
import com.devdroid.rickandmortyapp.databinding.ItemCharacterBinding
import com.devdroid.rickandmortyapp.domain.model.CharacterItem

class CharacterAdapter(
    private val onItemSelected:(CharacterItem) -> Unit,
    private val onFavoriteSelected:(CharacterItem) -> Unit
) : ListAdapter<CharacterItem, CharacterAdapter.CharacterViewHolder>(DiffCallBack){



    companion object DiffCallBack : DiffUtil.ItemCallback<CharacterItem>() {
        override fun areItemsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
            return oldItem == newItem
        }
    }


    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterItem, onItemSelected: (CharacterItem) -> Unit, onFavoriteSelected: (CharacterItem) -> Unit) {



            Glide.with(binding.imageView)
                .load(character.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(binding.imageView)

            binding.apply {
                imgStatus.background = when (character.status) {
                    "Alive" -> ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_live)
                    "Dead" -> ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_dead)
                    else -> {
                        ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_unknown)
                    }
                }
                tvName.text = character.name
                tvStatus.text = character.status
                tvGender.text = character.gender
                imgGender.background = when (character.gender) {
                    "Female" -> ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_female)
                    "Male" -> ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_male)
                    else -> {
                        ContextCompat.getDrawable(this@CharacterViewHolder.itemView.context, R.drawable.ic_gender_unknown)
                    }
                }
                cbFavorite.isChecked = character.favorite
                tvLocation.text = character.location?.name

                tvOrigin.text = character.origin?.name

                parent.setOnClickListener {
                    onItemSelected(character)
                }
                cbFavorite.setOnClickListener {
                    onFavoriteSelected(character)
                }
            }
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(
            getItem(position), onItemSelected, onFavoriteSelected
        )
    }

}