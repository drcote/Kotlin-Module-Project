 fun displayMenu(options: List<String>): Int {
        options.forEachIndexed { index, option -> println("$index. $option") }
        val choice = readLine()?.toIntOrNull()
        return if (choice != null && choice in options.indices) {
            choice
        } else {
            println("Ошибка: неверный ввод. Попробуйте снова.")
            displayMenu(options)
        }
    }

    fun createArchive(archives: MutableList<Archive>) {
        println("Введите имя архива:")
        val name = readLine()
        if (name.isNullOrBlank()) {
            println("Ошибка: имя архива не может быть пустым.")
        } else {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        }
    }

    fun createNote(archive: Archive) {
        println("Введите имя заметки:")
        val noteName = readLine()
        if (noteName.isNullOrBlank()) {
            println("Ошибка: имя заметки не может быть пустым.")
            return
        }
        println("Введите текст заметки:")
        val content = readLine()
        if (content.isNullOrBlank()) {
            println("Ошибка: текст заметки не может быть пустым.")
        } else {
            archive.notes.add(Note(noteName, content))
            println("Заметка '$noteName' добавлена.")
        }
    }