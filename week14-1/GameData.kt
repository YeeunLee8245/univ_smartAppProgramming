package kr.co.yeaeun.myapplication

import android.content.Context
import androidx.room.*

@Entity(tableName = "game")
data class GameState(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val money: Long,
    val level: Long,
    val seed: Int
)

// 자동으로 interface를 구현해줌
@Dao
interface GameDao {
    @Query("INSERT INTO game VALUES(1,0,1, :seed)")
    fun insert(seed: Int)

    @Query("SELECT * from game")
    fun select():GameState

    @Update
    fun update(data: GameState)

    @Delete
    fun delete(data: GameState)
}

// singleton pattern
@Database(entities = [GameState::class], version = 1, exportSchema = false)
abstract class GameDatabase: RoomDatabase(){
    abstract fun gameDao() : GameDao

    companion object {
        private var database: GameDatabase? = null

        fun getDatabase(context: Context) : GameDatabase? {
            if (database == null){
                database = Room.databaseBuilder(
                        context.applicationContext,
                    GameDatabase::class.java,
                    "game.db"
                        ).build()
            }
            return database
        }
    }
}

// repository
class GameRepository(private val dao: GameDao){
    fun insert(seed: Int) {
        dao.insert(seed)
    }

    fun select(): GameState{
        return dao.select()
    }

    fun update(data: GameState){
        dao.update(data)
    }

    fun delete(data: GameState){
        dao.delete(data)
    }
}