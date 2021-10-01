package hackee12.serial

interface SerialReader<T> {
    fun hasNext(): Boolean
    fun next(): T
}