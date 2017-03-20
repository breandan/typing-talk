import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

open class Layout<T : LayoutProtocol>(val t: T){
    fun getName(): String {
        return t.getName()
    }

    companion object {
        inline fun <reified T: LayoutProtocol> create(instance: T): Layout<T> {
            return object: Layout<T>(instance) {}
        }
    }
}

open class TypeLiteral<T> {
    val type: Type = getSuperclassTypeParameter(this::class.java)
    companion object {
        fun getSuperclassTypeParameter(subclass: Class<*>) =
                (subclass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
    }
}

inline fun <reified R> Iterable<*>.genericFilterIsInstance() where R : Any =
        filterIsInstance<R>().filter { object : TypeLiteral<R>() {}.type == it::class.java.genericSuperclass }

interface LayoutProtocol {
    fun getName(): String
}

internal class Vertical : LayoutProtocol {
    override fun getName(): String {
        return "Vertical"
    }
}

internal class Horizontal : LayoutProtocol {
    override fun getName(): String {
        return "Horizontal"
    }
}

fun main(args: Array<String>) {
    val layouts = LinkedList<Layout<*>>()
    layouts.add(Layout.create(Horizontal()))
    layouts.add(Layout.create(Vertical()))
    println("Horizontal layouts:")
    layouts.genericFilterIsInstance<Layout<Horizontal>>().forEach { println(it.getName()) }
    /* prints:
    Horizontal layouts:
    Horizontal
     */
}

//fun main(args: Array<String>) {
//    val layouts = LinkedList<Layout<*>>()
//    layouts.add(Layout<Horizontal>(Horizontal()))
//    layouts.add(Layout<Vertical>(Vertical()))
//    println("Horizontal layouts:")
////    layouts.filter<Horizontal>(Horizontal::class.java).forEach { println(it.getName()) }
//    layouts.genericFilterIsInstance<Layout<Horizontal>>().forEach { println(it.getName()) }
//
//
//}


fun <T : LayoutProtocol> Iterable<Layout<*>>.filter(clazz: Class<T>): Iterable<Layout<T>> {
    val dest = ArrayList<Layout<T>>()

    for (element in this)
        if (element.t::class.java == clazz)
            dest.add(element as Layout<T>)

    return dest
}









//fun <T : LayoutProtocol> Iterable<Layout<*>>.filterLayouts() = filter { it.t is T } as Iterable<Layout<T>>


//private fun filterHorizontal(layouts: LinkedList<Layout<*>>): List<Layout<*>> {
//    return layouts.filter { (it.t is Horizontal) }.map { it as Layout<Horizontal> }
//}