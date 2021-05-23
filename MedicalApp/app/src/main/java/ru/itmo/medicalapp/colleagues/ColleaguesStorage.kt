package ru.itmo.medicalapp.colleagues

object ColleaguesStorage {
    val DEFAULT_COLLEAGUES_LIST =
        arrayListOf(Colleague("Inna"), Colleague("Yury"), Colleague("Max"))
    private val colleagues: ArrayList<Colleague> = DEFAULT_COLLEAGUES_LIST

    fun addColleague(colleague: Colleague) {
        colleagues.add(colleague)
    }

    fun getColleagues(): List<Colleague> {
        return colleagues
    }
}
