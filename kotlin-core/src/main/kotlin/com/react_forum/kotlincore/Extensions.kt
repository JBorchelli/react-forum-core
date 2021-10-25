package com.react_forum.kotlincore

import java.util.Optional

/**
* Grabbed this extension from Martin Schroder's blog at:
* https://blog.akquinet.de/2019/07/11/java-optional-and-kotlin-nullable/
*    
* It allows for easy kotlin-like handling of Optionals when using the methods inherited from the CRUDRepository interface. 
*/
fun <T : Any> Optional<T>.toNullable(): T? = this.orElse(null)


