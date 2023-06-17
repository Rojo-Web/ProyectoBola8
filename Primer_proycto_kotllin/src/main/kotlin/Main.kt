//variable instanciada para el bucle
var selecIncorreta=false

//Varaiables para el map
const val respuestaAfirmativa = "✔️"
const val respuestaNegativa = "✖️"
const val respuestaDudosa = "?"

//Unimos las respuestas
val respuestas= mutableMapOf(
    "si" to respuestaAfirmativa,
    "sin duda" to respuestaAfirmativa,
    "Claro que si" to respuestaAfirmativa,
    "Puede ser" to respuestaDudosa,
    "podria ser" to respuestaDudosa,
    "no" to respuestaNegativa,
    "absolutamente no" to respuestaNegativa,
    "para nada y no" to respuestaNegativa,
)

//guardado de respuestas
var guardarRespuestas = mutableListOf<String>()

fun main(args: Array<String>) {

    /*Clases
    val listafrut = listOf<String>("Pera","manzana", "Banano")
    for (frut in listafrut){
        println(frut)
    }
    listafrut.forEach{fruta -> println("Hoy comere "+fruta)}
    val frutaselec = listafrut.filter { selec -> selec.equals("manzana") }
    println("La seleccion fue: "+frutaselec)
    var n : Int? = null ?: 0;
    println(n)

    val rrrrr= mutableListOf<String>();
    rrrrr.add("santi")
    rrrrr.add("Carlos")
    rrrrr[0]="Santi";
    println(rrrrr)

    val numeros = listOf<Int>(1,2,3,4,5,6)

    val primermap = mutableMapOf(
        "santi" to  12,
        "neme" to 34,
        "maria" to 33
    )
    primermap["geral"] = 22
    println(primermap.filterValues { nom -> nom == 22 })

    val primerset = mutableSetOf("santi","neme","maria")
    println(primerset)
    primerset.add("geral")
    println(primerset.filter {name -> name == "santi"  } )


    var num1 = 1;
    var num2 = 2;
    var res0 = 0;
    var res = res0.sumas(2,3)

    var restLambda : (Int, Int) -> Int = {
         X : Int,Y: Int -> X-Y
    }

    println(restLambda(4,3))
    println(res)
    val superQQ= superWow(nom="santi")
    val lambda: String = superQQ()
    println(lambda)

    var pruebaNull : String? = null
    pruebaNull?.let {
        valor-> println("Nula $pruebaNull")
    }
    pruebaNull = "santi";
    pruebaNull.let { valor -> println("No nula") }*/

    //Proyecto bola 8

    menuInicial()

}
fun menuInicial(){

    //Ciclo para que si elije un numero que no esta pueda volver a intentarlo
    do {
        selecIncorreta=false
        //imoresion de menu para bola 8
        println(
            "Hola amig@ soy bola 8, dime ¿Que deseas hacer?" +
                    "\n1. realizar pregunta" +
                    "\n2.Respuestas" +
                    "\n3. Salir"
        )
        var selecBola = readlnOrNull()
        when (selecBola) {
            "1" -> preguntaBola()
            "2" ->respuestasBola()
            "3" ->salirBola()
            else -> selecIncorreta = true.apply { println("Error numero fuera de rango, vuelve a intentarlo ;D\n\n") }
        }
    }while (selecIncorreta ==true)
}

fun salirBola() {
    println("Good bye")

}

fun respuestasBola() {
    if (guardarRespuestas.isEmpty()){
        println("Bola 8: No has echo preguntas, vuelve cuando las hayas echo\n\n")
        menuInicial()
    }else {
        do {
            selecIncorreta = false
            //imoresion de menu para bola 8
            println(
                "Dime que respuestas deseas saber:" +
                        "\n1. Todas las respuestas" +
                        "\n2. Solo respuestas afirmativas" +
                        "\n3. Solo respuestas dudosas" +
                        "\n4. Solo respuestas negativas" +
                        "\n5. Regresar"
            )

            var selecMostrar = readlnOrNull()
            when (selecMostrar) {
                "1" -> tipoRespuesta()
                "2" -> tipoRespuesta(tipo = "afirmativo")
                "3" -> tipoRespuesta(tipo = "dudosa")
                "4" -> tipoRespuesta(tipo = "negativa")
                "5" -> menuInicial()
                else -> selecIncorreta =
                    true.apply { println("Error numero fuera de rango, vuelve a intentarlo ;D\n\n") }
            }
        } while (selecIncorreta == true)
    }
}

/*fun tipoRespuesta(tipo : String = "todos") {
    when(tipo){
        "todos" ->respuestas.keys.forEach { respuestas -> println(respuestas) }
        "afirmativo"->respuestas.filterValues { respuestas -> respuestas == respuestaAfirmativa }
            .also { respuestaAfirmativa -> println(respuestaAfirmativa) }
        "dudosa"->respuestas.filterValues { respuestas -> respuestas == respuestaDudosa }
            .also { respuestaDudosa -> println(respuestaDudosa) }
        "negativa"->respuestas.filterValues { respuestas -> respuestas == respuestaNegativa }
            .also { respuestaNegativa -> println(respuestaNegativa) }
    }
    menuInicial()
}*/

fun tipoRespuesta(tipo : String = "todos") {

    when(tipo){
        "todos" ->guardarRespuestas.forEach { respuestas -> println(respuestas) }
        "afirmativo"-> guardarRespuestas.filter { respuestas -> respuestas.contains("si")}
            .also { respuestaAfirmativa -> println(respuestaAfirmativa) }

        "dudosa"-> guardarRespuestas.filter { respuestas -> respuestas.contains("ser") }
            .also { respuestaDudosa -> println(respuestaDudosa) }

        "negativa"->  guardarRespuestas.filter { respuestas -> respuestas.contains("no") }
            .also { respuestaNegativa -> println(respuestaNegativa) }
    }
    menuInicial()
}

fun preguntaBola() {
    println("Que pregunta me deseas hacer?")
    var pregunta=readln()
    println("Conque esa es tu respuesta ... Ummmm dejame pienso ")
    try {
        //Ponemos a "Dormir" el programa durante los ms que queremos
        Thread.sleep((1000).toLong())
    } catch (e: Exception) {
        println(e)
    }
    print(".")
    try {
        //Ponemos a "Dormir" el programa durante los ms que queremos
        Thread.sleep((1000).toLong())
    } catch (e: Exception) {
        println(e)
    }
    print(".")
    try {
        //Ponemos a "Dormir" el programa durante los ms que queremos
        Thread.sleep((1000).toLong())
    } catch (e: Exception) {
        println(e)
    }
    print(".")
    try {
        //Ponemos a "Dormir" el programa durante los ms que queremos
        Thread.sleep((1000).toLong())
    } catch (e: Exception) {
        println(e)
    }
    print(" la respuesta es: ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
    guardarRespuestas.add(pregunta+" : "+respuestaGenerada)
    menuInicial()
}




/*Funciones de las clases
fun Int.sumas(x:Int, y:Int) : Int{
    return x+y;
}
fun lamdafun(ValorIn : String, Block : (String) -> Int ) : Int {
    return Block(ValorIn)
}
fun superWow(nom:String) : ()   -> String{
    return{
        "Hola $nom"
    }
}*/