import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Serializable
data class Counter(val value: Long = 0) {
    operator fun plus(x: Long) = Counter(value + x)
}

fun main(args: Array<String>) = runBlocking {
    val api = Api()
    val result = api.mutate { counter: Counter -> counter + 1 }
    println("result: $result")
}

suspend inline fun <reified T: Any> Api.mutate(crossinline mutator: (T) -> T): T =
    mutate(mutatorAdapter(mutator)).let { Json.decodeFromJsonElement(it) }

suspend inline fun <reified T: Any> mutatorAdapter(
    crossinline mutator: suspend (T) -> T
): suspend (JsonObject) -> JsonObject =
    { data: JsonObject ->
        val parsedData = Json.decodeFromJsonElement<T>(data)
        val mutatedData = mutator(parsedData)
        Json.encodeToJsonElement(mutatedData).jsonObject
    }

class Api {
    suspend fun mutate(mutator: suspend (JsonObject) -> JsonObject?): JsonObject = withContext(Dispatchers.IO) {
        val oldData = requestData()
        val newData =  mutator(oldData) ?: return@withContext oldData

        postData(newData)
        return@withContext newData
    }

    private suspend fun requestData(): JsonObject {
        delay(100)
        return buildJsonObject {}
    }

    private suspend fun postData(data: JsonObject) {
        delay(100)
    }
}
