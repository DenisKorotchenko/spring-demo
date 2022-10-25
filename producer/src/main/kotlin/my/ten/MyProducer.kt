package my.ten

import my.tim.SuperLogger

class MyProducer {

    val logger = SuperLogger()

    fun produce(str: String) {
        logger.log(str, SuperLogger.Level.ERROR)
    }
}