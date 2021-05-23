package ru.itmo.medicalapp.tasks

object TasksStorage {
    val DEFAULT_TASKS_LIST =
        arrayListOf(Task("Help"), Task("Give"), Task("Run"))
    private val tasks: HashMap<Int, ArrayList<Task>> =
        hashMapOf(Pair(0, DEFAULT_TASKS_LIST))

    fun addTask(id: Int, task: Task) {
        tasks[id]?.add(task)
    }

    fun getTasks(id: Int): List<Task> {
        return tasks[id] ?: emptyList()
    }
}
