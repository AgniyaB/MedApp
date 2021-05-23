package ru.itmo.medicalapp.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.medicalapp.R

class TasksFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private val adapter = Adapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tasks_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler) ?: return
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
        loadData()
    }

    private fun loadData() {
        adapter.updateData(TasksStorage.getTasks(0))
    }

    inner class Adapter(private var tasks: List<Task>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, index: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val layout = R.layout.task_item
            val view = inflater.inflate(layout, parent, false)
            return ViewHolder(view)
        }

        fun updateData(tasks: List<Task>) {
            this.tasks = tasks
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return tasks.size
        }

        override fun onBindViewHolder(holder: ViewHolder, p: Int) {
            holder.bind(tasks[p]);
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val view: TextView = view.findViewById(R.id.task)

            fun bind(task: Task) {
                view.text = task.description
            }
        }
    }
}