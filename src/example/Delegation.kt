package example
import kotlin.properties.Delegates


var counter: Int by Delegates.observable(0) { _,old,new ->println("Счетчик изменился $old -> $new") }
interface Base{
    fun someFun()
}
class BaseImpl(): Base{
    override fun someFun() {
    }
}
class Derived(someBase: Base) : Base by someBase

interface Messanger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessanger(val programName: String) : Messanger{
    override fun sendTextMessage() = println("send text Message")
    override fun sendVideoMessage() = println("send video Message")

}
class SmartPhone(val name: String, m: Messanger): Messanger by m{
    override fun sendTextMessage() = println(" send sms")
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("take photo")
}





class User{
    var name: String by Delegates.observable("no name") { _,old,new -> println("имя изменено $old -> $new") }
}






fun main(){

    counter =  1
    counter = 5

//    val max = InstantMessanger("MAX")
//    val photoCamera = PhotoCamera()
//    val yotaPhone = SmartPhone("YotaPhone",max)
//    yotaPhone.sendTextMessage()
//    yotaPhone.sendVideoMessage()
//    yotaPhone.send("Hello Kotlin")
//    yotaPhone.send("Learn delegation")
//    yotaPhone.takePhoto()
}