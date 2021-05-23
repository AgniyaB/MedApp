package ru.itmo.medicalapp.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.itmo.medicalapp.R

class HomeFragment : Fragment() {

    interface HomeFragmentListener {
        fun onColleaguesRequired()
        fun onPatientsRequired()
        fun onTasksRequired()
    }

    private var listener: HomeFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeFragmentListener) {
            listener = context
        } else {
            throw ClassCastException("$context is not HomeFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colleagues = view.findViewById<View>(R.id.colleagues)
        colleagues.setOnClickListener {
            listener?.onColleaguesRequired()
        }
        val patients = view.findViewById<View>(R.id.patients)
        patients.setOnClickListener {
            listener?.onPatientsRequired()
        }
        val tasks = view.findViewById<View>(R.id.tasks)
        tasks.setOnClickListener {
            listener?.onTasksRequired()
        }
    }
}
