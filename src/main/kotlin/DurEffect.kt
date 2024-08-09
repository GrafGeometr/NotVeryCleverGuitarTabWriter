package org.example

enum class DurEffect {
    NONE,
    POINT,
    TRIOLE;

    fun toDouble(): Double = when (this) {
        NONE -> 1.0
        POINT -> 1.5
        TRIOLE -> 2.0/3.0
    }

    override fun toString() = when (this) {
        NONE -> ""
        POINT -> "."
        TRIOLE -> "[3]"
    }
}