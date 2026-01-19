package example

object GameSession{
    init {
        println("игровая сессия создана")
    }
    var isActive: Boolean = false
    fun start(){
        isActive = true
        println("Игра началась")
    }
    fun end(){
        isActive = false
        println("Игра завершена")
    }
}

object Logger{
    var count = 0
    fun log(message: String){
        count++
        println("[$count] $message")
    }
}

object AppSettings{
    val version = "1.0.0"
    var isDarkMode = true
    fun toggleTheme(){
        isDarkMode = !isDarkMode
    }
    fun checkTheme(){
        if (AppSettings.isDarkMode){
            println("dark theme on")
        }
    }
}


object Colors{
    const val RED = "#FF0000"
    const val GREEN = "#00FF00"
    const val BLUE = "#0000FF"
}

fun main(){
    Logger.log("1")

}