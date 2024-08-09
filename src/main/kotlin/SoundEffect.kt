package org.example

enum class SoundEffect {
    NONE,
    PALM_MUTE,
    VIBRATO,
    FLAGEOLET;

    override fun toString() = when (NONE) {
        this -> ""
        else -> "(${this.name.lowercase()})"
    }
}
