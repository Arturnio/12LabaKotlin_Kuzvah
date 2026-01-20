import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager


fun main() {
//    val manager = resources.ResourceManager()
//    val minerals = resources.OutpostResource(id = 1, name = "Minerals", amount = 300)
//    val gas = resources.OutpostResource(id = 2, name = "Gas", amount = 100)
//
//    manager.add(minerals)
//    manager.add(gas)
//    manager.printAll()
//    val bonus = minerals.copy(amount = minerals.amount + 50)
//    println("Копия минералов с бонусом $bonus")

    val manager = ResourceManager()
    manager.add(OutpostResource(id = 1, name = "Minerals", amountInit = 120))
    manager.add(OutpostResource(id = 2, name = "Gas", amountInit = 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()

    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatorResult)
    handleModuleResult(labResult)
    println()
    manager.printAll()
    logger.log("Запуск базы")

    val loadedResources = FileStorage.load()
    loadedResources.forEach {manager.add(it)}
    if (loadedResources.isEmpty()) {
        manager.add(OutpostResource(1,"Minerals",300))
        manager.add(OutpostResource(2,"GAS",100))
    }
    FileStorage.save(manager.getAll())
}
val logger by lazy{
    SystemLogger
}

object SystemLogger{
    init{
        println("SystemLogger инициализирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println("Успех ${result.message}")
        is ModuleResult.ResourceProduced -> println("Произведени ${result.resourceName} ${result.amount}")
        is ModuleResult.NotEnoughResources -> println("Недоастаточно ресурса ${result.resourceName} Нужно ${result.required} есть ${result.available}")
        is ModuleResult.Error -> println("Ошибка ${result.reason}")
    }
}