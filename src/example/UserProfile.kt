package example

import kotlin.properties.Delegates

class UserProfile(initalName: String,initialEmail:String){
    var name:String by Delegates.observable(initalName){ _,old,new ->println("имя изменено $old -> $new") }
    var email: String by Delegates.observable(initialEmail){_,old,new ->println("имаил изменен $old -> $new")}

    val avatar: String by lazy{
        println("Загружаем аватар для $name")
        "avatar_of_$name.png"
    }
}

fun main() {
    println("Создаём профиль пользователя...")
    val user = UserProfile("Алиса","alice@example.com")
    println("\nИмя: ${user.name}")
    println("Email: ${user.email}")

    println("\nОбращаемся к аватару впервые:")
    println("Файл аватара: ${user.avatar}")

    println("\nОбращаемся к аватару снова (должен быть взят из кэша):")
    println("Файл аватара: ${user.avatar}")

    println("\nМеняем email:")
    user.email = "alice_new@example.org"

    println("\nМеняем имя:")
    user.name = "Алиса К."
}