package modules

import ModuleResult
import resources.OutpostResource
import resources.ResourceManager

class EnergyGenerator: OutpostModule("генератор энергии") {
    override fun performAction(manager: ResourceManager): ModuleResult {
        println("Генератор работает... Производит 20 энергии")
        val energy = manager.get("Energy")
        return if (energy != null) {
            energy.amount += 20
            ModuleResult.ResourceProduced("Energy",20)
        }else{
            manager.add(OutpostResource(99,"Energy",20))
            ModuleResult.Success("Енергия создана впервые")
        }
    }
}