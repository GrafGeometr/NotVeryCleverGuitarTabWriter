package org.example

enum class JustDur {
    WHOLE,
    HALF,
    QUARTER,
    EIGHTH,
    SIXTEENTH,
    THIRTY_SECOND;

    fun toDouble(): Double = when (this) {
        WHOLE -> 1.0
        HALF -> 0.5
        QUARTER -> 0.25
        EIGHTH -> 0.125
        SIXTEENTH -> 0.0625
        THIRTY_SECOND -> 0.03125
    }

    override fun toString() = when (this) {
        WHOLE -> "1"
        HALF -> "1/2"
        QUARTER -> "1/4"
        EIGHTH -> "1/8"
        SIXTEENTH -> "1/16"
        THIRTY_SECOND -> "1/32"
    }
}