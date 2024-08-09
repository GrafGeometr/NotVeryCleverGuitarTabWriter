package org.example

data class Duration(private val dur: JustDur, private val effect: DurEffect) {
    fun toDouble() = dur.toDouble() * effect.toDouble()
    override fun toString() = "$dur$effect"

    companion object {
        private fun List<Duration>.getLength(): Double = sumOf { it.toDouble() }

        fun fromDouble(value: Double): Duration? = JustDur.entries.map { v ->
            DurEffect.entries.map { e ->
                Duration(v, e)
            }
        }.flatten().find { it.toDouble() == value }

        private fun getSimpleSequences(): List<List<Duration>> {
            val toAdd = JustDur.entries.map { v ->
                DurEffect.entries.filter { it != DurEffect.TRIOLE }.map { e ->
                    Duration(v, e)
                }.filter { it != Duration(JustDur.THIRTY_SECOND, DurEffect.POINT) }.map {
                    listOf(it) }
            }.flatten().toMutableList()

            JustDur.entries.filter { it != JustDur.THIRTY_SECOND }.let { durs ->
                durs.forEach {
                    Duration(it, DurEffect.TRIOLE).let { d ->
                        toAdd += listOf(d, d, d)
                    }
                }
                durs.zip(durs.drop(1)).forEach {
                    toAdd += listOf(
                        Duration(it.first, DurEffect.TRIOLE),
                        Duration(it.second, DurEffect.TRIOLE)
                    )
                    toAdd += listOf(
                        Duration(it.second, DurEffect.TRIOLE),
                        Duration(it.first, DurEffect.TRIOLE)
                    )
                }
            }

            return toAdd
        }

        fun getSequences(t: Double): List<List<Duration>>? {
            if (t < 0.0) return null
            if (t == 0.0) return listOf(emptyList())
//            println(t)
            val toAdd = getSimpleSequences()

            val result = mutableListOf<List<Duration>>()

            toAdd.forEach { ds ->
                getSequences(t - ds.getLength())?.let { sequences ->
                    sequences.forEach { sequence ->
                        result += sequence + ds
                    }
                }
            }
            return result
        }
    }
}