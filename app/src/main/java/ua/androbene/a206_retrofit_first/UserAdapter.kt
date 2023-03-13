package ua.androbene.a206_retrofit_first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.androbene.a206_retrofit_first.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserVH>() {

    var users = emptyList<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserVH(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]
        holder.bind(user)
    }
}

class UserVH(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(user: User) {
        binding.userName.text = user.name
        binding.userEmail.text = user.email
        binding.userInitial.text =
            user.name.split(" ").take(2).fold("") { acc, s -> "$acc${s.take(1)}" }
        binding.userAddress.text = "${user.address.street} / ${user.address.suite}"
    }
}