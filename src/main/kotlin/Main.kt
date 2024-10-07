fun main() {
    val archives = mutableListOf<Archive>()

    while (true) {
        println("Меню архивов:")
        val options = mutableListOf("Создать архив", "Выход") + archives.map { it.name }
        val choice = displayMenu(options)

        when (choice) {
            0 -> createArchive(archives)
            1 -> {
                println("Выход из программы.")
                return
            }
            else -> {
                val selectedArchive = archives[choice - 2]
                openArchive(selectedArchive)
            }
        }
    }
}

fun openArchive(archive: Archive) {
    while (true) {
        println("Архив '${archive.name}':")
        val options = mutableListOf("Создать заметку", "Вернуться") + archive.notes.map { it.name }
        val choice = displayMenu(options)

        when (choice) {
            0 -> createNote(archive)
            1 -> return
            else -> {
                val selectedNote = archive.notes[choice - 2]
                viewNote(selectedNote)
            }
        }
    }
}

fun viewNote(note: Note) {
    println("Заметка '${note.name}':")
    println(note.content)
}
