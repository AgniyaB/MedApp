package ru.itmo.medicalapp.colleagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.medicalapp.R

class ColleaguesFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private val adapter = Adapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.colleagues_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler) ?: return
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
        loadData()
    }

    private fun loadData() {
        adapter.updateData(ColleaguesStorage.getColleagues())
    }

    inner class Adapter(private var colleagues: List<Colleague>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, index: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val layout = R.layout.patient_item
            val view = inflater.inflate(layout, parent, false)
            return ViewHolder(view)
        }

        fun updateData(colleagues: List<Colleague>) {
            this.colleagues = colleagues
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return colleagues.size
        }

        override fun onBindViewHolder(holder: ViewHolder, p: Int) {
            holder.bind(colleagues[p]);
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val title: TextView = view.findViewById(R.id.name)

            fun bind(colleague: Colleague) {
                title.text = colleague.name
            }
        }
    }
}
