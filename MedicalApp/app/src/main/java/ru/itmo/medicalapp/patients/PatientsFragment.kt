package ru.itmo.medicalapp.patients

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.medicalapp.R

class PatientsFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private val adapter = Adapter(emptyList())

    interface PatientsFragmentListener {
        fun onAddNewPatient()
    }

    private lateinit var listener: PatientsFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is PatientsFragmentListener) {
            listener = context
        } else {
            throw ClassCastException("$context is not PatientsFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.patients_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycler) ?: return
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
        loadData()

        val floatingButton = view.findViewById<View>(R.id.floating_action_button)
        floatingButton.setOnClickListener {
            listener.onAddNewPatient()
        }
    }

    private fun loadData() {
        adapter.updateData(PatientsStorage.getPatients(0))
    }

    inner class Adapter(private var patients: List<Patient>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, index: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val layout = R.layout.patient_item
            val view = inflater.inflate(layout, parent, false)
            return ViewHolder(view)
        }

        fun updateData(patients: List<Patient>) {
            this.patients = patients
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return patients.size
        }

        override fun onBindViewHolder(holder: ViewHolder, p: Int) {
            holder.bind(patients[p]);
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val title: TextView = view.findViewById(R.id.name)

            fun bind(patient: Patient) {
                title.text = patient.name
            }
        }
    }
}
