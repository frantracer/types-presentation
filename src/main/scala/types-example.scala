sealed abstract class Enemy(val name: String, val position_x: Double, val speed: Double) {
    def draw : Unit = {
        println("Enemy " + name + " of " + this.getClass + " is in " + position_x)
    }
}

case class Goomba(override val name: String, override val position_x: Double) extends Enemy(name, position_x, 1) {

}

case class Koopa(override val name: String, override val position_x: Double) extends Enemy(name, position_x, 2) {

}

object TypeExample extends App {

    def move_enemies (enemies : List[Enemy]) : List[Enemy] = {
        enemies.map(enemy => enemy match {
            case goomba: Goomba => goomba.copy(position_x = goomba.position_x - goomba.speed)
            case koopa: Koopa => koopa.copy(position_x = koopa.position_x - koopa.speed)
        })
    }

    def enemy_is_in_stage (enemy : Enemy) : Boolean = {
        enemy.position_x > 0
    }

    def main_loop(turn : Int, enemies : List[Enemy]) : Unit = {
        println("TURN " + turn)
        enemies.map(enemy => enemy.draw)
        if(enemies.isEmpty) {
            println("Stage END")
        } else {
            main_loop(turn + 1, move_enemies(enemies).filter(enemy_is_in_stage))
        }
    }

    val stage_1_enemies : List[Goomba] = Goomba("goomba1", 1) :: Goomba("goomba2", 11) :: List[Goomba]()
    val stage_2_enemies : List[Enemy] = Goomba("goomba3", 5) :: Koopa("koopa1", 12) :: List[Goomba]()

    val my_array : Array[Int] = Array[Int]()

    println("== STAGE 1 ==")
    main_loop(0, stage_1_enemies)
    println("== STAGE 2 ==")
    main_loop(0, stage_2_enemies)
}

