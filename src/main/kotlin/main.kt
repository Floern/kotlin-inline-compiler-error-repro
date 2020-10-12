@file:Suppress("NOTHING_TO_INLINE", "unused", "UNUSED_PARAMETER")

fun main() {
	aa(42)
}

inline fun aa(x: Int) {
	bb { "aa!" }
}

inline fun AA(x: Int, y: String) {
	bb { "AA!" }
}

fun bb(l: () -> String) {
	println(l())
}
