package fr.android.onlydigits

import android.content.Context

fun <T> Map<T, Int>.bagToList() : List<T> {
    val elements = ArrayList<T>();
    this.entries.forEach { entry -> repeat(entry.value) { elements.add(entry.key) } }
    return elements;
}

class ElementPicker<T>(bag: Map<T, Int>) {
    var elements = bag.bagToList();

    fun pickElements(n: Int): List<T> {
        return elements.shuffled().subList(0, n);
    }

    companion object {
        fun <T> buildFromResources(context: Context, resourceId: Int, elementParser: (String) -> T): ElementPicker<T> {
            val res = context.resources.openRawResource(resourceId).bufferedReader().useLines {
                lineSeq -> lineSeq.associate {
                    line ->
                    val cols = line.split("\\s+".toRegex());
                    elementParser(cols[0]) to cols[1].toInt()
                }
            }

            return ElementPicker(res);
        }
    }
}