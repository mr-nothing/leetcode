package common

import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.cast
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure
import kotlin.reflect.safeCast

// TODO I'll make this work some day xD
fun <Input : Any, Output : Any> testData(
    fqpn: String,
    inputCls: KClass<Input>,
    outputCls: KClass<Output>
): List<Pair<Input, Output>> {
    val packageName = fqpn.substring(fqpn.lastIndexOf(".") + 1)
    val packageResourcesDir = ClassLoader.getSystemClassLoader().getResources(packageName).toList()
        .first { url -> url.path.contains("resources/test") }.file?.let { File(it) }
        ?: throw IllegalArgumentException("Test resource dir not found")

    return packageResourcesDir.listFiles()?.toList()?.map { file ->
        read(file, inputCls, outputCls)
    } ?: throw IllegalArgumentException("Resource $packageResourcesDir is not a directory")
}

private fun <Input : Any, Output : Any> read(
    filename: File,
    inputCls: KClass<Input>,
    outputCls: KClass<Output>
): Pair<Input, Output> {
    val data = filename.readLines()

    val inputClsParams = inputCls.primaryConstructor?.parameters
    val outputClsParams = outputCls.primaryConstructor?.parameters

    val indexOfDelimiter = data.indexOf("")
    val inputData = if (inputClsParams?.isNotEmpty() == true) {
        data.subList(0, indexOfDelimiter).zip(inputClsParams)
            .map { transform(it.first, it.second.type, it.second.type.jvmErasure) }.toList()
    } else {
        null
    }

    val outputData = if (outputClsParams?.isNotEmpty() == true) {
        data.subList(indexOfDelimiter + 1, data.size).zip(outputClsParams)
            .map { transform(it.first, it.second.type, it.second.type.jvmErasure) }.toList()
    } else {
        null
    }

    val input = inputData?.let { inputCls.primaryConstructor?.call(*it.toTypedArray()) }
    val output = outputData?.let { outputCls.primaryConstructor?.call(*it.toTypedArray()) }
    return input!! to output!!
}

@Suppress("UNCHECKED_CAST")
private fun <T : Any> transform(line: String, type: KType, cls: KClass<T>): T? {
    val tl = line.trim()
    if (tl == "null") {
        return null
    }
    return when (type.classifier) {
        MutableList::class -> {
            val arrayContent = parseArrayContent(tl)

            if (arrayContent.isEmpty()) {
                return type.jvmErasure.cast(mutableListOf<Any>()) as T
            }

            var bracketCounter = 0
            var inQuotes = false

            var startIndex = 0
            val arrayElements = mutableListOf<String>()
            for ((index, char) in arrayContent.withIndex()) {
                when (char) {
                    '[' -> {
                        if (inQuotes) {
                            continue
                        }
                        bracketCounter++
                    }
                    ']' -> {
                        if (inQuotes) {
                            continue
                        }
                        bracketCounter--
                    }
                    '"' -> {
                        if (bracketCounter != 0) {
                            continue
                        }
                        inQuotes = inQuotes.not()
                    }
                    ',' -> {
                        val inBrackets = bracketCounter != 0
                        if (!inBrackets && !inQuotes) {
                            arrayElements.add(arrayContent.substring(IntRange(startIndex, index - 1)))
                            startIndex = index + 1
                        }
                    }
                }
            }
            arrayElements.add(arrayContent.substring(IntRange(startIndex, arrayContent.lastIndex)))

            val elementType = type.arguments[0].type!!
            arrayElements.map { element ->
                elementType.jvmErasure.safeCast(
                    transform(
                        element,
                        elementType,
                        elementType.jvmErasure
                    )
                )
            }.toList()
        }
        String::class -> {
            tl.substring(1, tl.length - 1)
        }
        Int::class -> {
            tl.toInt()
        }
        Long::class -> {
            tl.toLong()
        }
        Boolean::class -> {
            tl.toBoolean()
        }
        else -> {
            throw IllegalArgumentException("String $line can not be recognized as any of supported data types.")
        }
    } as T
}

private fun parseArrayContent(str: String): String {
    return if (str.count { it == '[' || it == ']' } == str.indexOfFirst { it != '[' } + (str.lastIndex - str.indexOfLast { it != ']' })) {
        str.trim('[', ']')
    } else {
        str.substring(1, str.length - 1)
    }
}