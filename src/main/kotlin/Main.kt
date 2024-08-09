package org.example


fun middle(size: Double): Music {
    val result = mutableListOf<Note>()

    val durations = Duration.getSequences(size)!!.filter {
        it.size < 8
    }.random()

    val drop = (1..4).random()
    result += Note.create(-drop, durations[0].toDouble(), SoundEffect.PALM_MUTE)

    durations.drop(1).forEach {
        result += Note(
            NoteValue(
                result.last().value.height + listOf(
                    -1, 0, 0, 0, 0, 0, 0, 1
                ).random(), SoundEffect.PALM_MUTE
            ), it
        )
    }

    return result
}

fun intro(size: Double): Music {
    val firstNote = Note.create(0, 1.0 / 8)

    return listOf(firstNote) + middle(size - 1.0 / 8)
}


fun outro(size: Double): Music {
    val firstNote = Note.create(0, 1.0 / 8)
    val lastNote = Note.create(1, 1.0 / 4)

    return listOf(firstNote) + middle(size - 1.0 / 8 - 1.0 / 4) + listOf(
        lastNote
    )
}


fun main() {
    intro(3.0 / 8).forEach {
        println(it)
    }
    println()
    outro(5.0 / 8).forEach {
        println(it)
    }
}