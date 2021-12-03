fun main(args: Array<String>) {

    var puntopA = Punto("pa", 3, 2)
    var puntopB = Punto("pb", 1, 3)

    var punto1 = Punto("punto1",-1,0)
    var punto2 = Punto("punto2",3,1)
    var punto3 = Punto("punto3",-4,4)
    var punto4 = Punto("punto4",-3,2)
    var punto5 = Punto("punto5",6,-4)
    var punto6 = Punto("punto6",-5,6)
    var punto7 = Punto("punto7",10,-8)
    var punto8 = Punto("punto8",1,5)
    var punto9 = Punto("punto9",6,-7)

    var listadepuntos: List<Punto> = listOf(punto1,punto2,punto3,punto4,punto5,punto6,punto7,punto8,punto9)

    println(Punto.componenteVector(puntopB, puntopA).toString())


    println( Punto.localizacionGeograficaNS(listadepuntos))
}

class Punto(var id: String) {


    var x: Int = 0
    var y: Int = 0

    constructor(id: String, x: Int, y: Int) : this("") {
        this.x = x
        this.y = y
    }

    fun obtenerCoordenadas(): Pair<Int, Int> {

        return Pair(x, y)

    }

    override fun toString(): String {
        return "punto $id [$x , $y ]"
    }

    companion object {
        fun componenteVector(punto1: Punto, punto2: Punto): Punto {

            var punto3 = Punto(punto1.id + punto2.id, punto1.x - punto2.x, punto1.y - punto2.y)
            return punto3
        }


        fun localizacionGeograficaNS(lista: List<Punto>): Map<String, List<Punto>> {

            var listaNorte: MutableList<Punto> = mutableListOf()
            var listaSur: MutableList<Punto> = mutableListOf()
            var ite = lista.listIterator()
            var loc: MutableMap<String, List<Punto>> = mutableMapOf()
            for (i in ite) {
                if (i.y >= 0) {
                    listaNorte.add(i)
                } else {
                    listaSur.add(i)
                }
            }
            loc.put("Norte", listaNorte)
            loc.put("Sur", listaSur)
            return loc


        }


    }


}