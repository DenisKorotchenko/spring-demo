package denis.korotchenko.demo

import my.den.MyBestParser
import my.ten.MyProducer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main() {
	val parser = MyBestParser()
	parser.parse("parsing")
	val producer = MyProducer()
	producer.produce("producing")

	//runApplication<DemoApplication>(*args)
}
