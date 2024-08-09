package org.example

class Note(val value: NoteValue, val duration: Duration) {
    override fun toString(): String {
        return "$duration $value"
    }

    companion object {
        fun create(
            value: Int,
            duration: Double,
            effect: SoundEffect = SoundEffect.NONE,
        ): Note {
            return Note(
                NoteValue(value, effect), Duration.fromDouble(duration)!!
            )
        }
    }
}