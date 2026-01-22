import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*

fun main() {
    // 1. 서버 엔진 및 포트/호스트 설정 (Express의 app.listen과 유사)
    embeddedServer(Netty, port = 5252, host = "127.0.0.1") {
        
        // 2. 라우팅 설정 (Express의 app.get과 동일)
        routing {
            // index.html 매핑
            staticResources("/", "static", index = "index.html")
        
            // assets 폴더 매핑 시, 브라우저가 JS/CSS를 올바르게 인식하도록 보장
            static("/assets") {
                resources("static/assets")
            }
        }
    }.start(wait = true)
}
