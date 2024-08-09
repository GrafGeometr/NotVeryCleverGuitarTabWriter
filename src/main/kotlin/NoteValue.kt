package org.example

class NoteValue(val height: Int, val soundEffect: SoundEffect) {
    override fun toString(): String = "$height$soundEffect"
}