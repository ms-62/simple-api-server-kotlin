import com.microsoft.playwright.Playwright
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import java.nio.file.Paths

fun main() {
    com.microsoft.playwright.impl.driver.Driver.ensure().install()
    // 1. 플레이라이트 실행
    Playwright.create().use { playwright ->
        // 2. 브라우저(Chromium) 실행 (headless = false면 화면이 보임)
        val browser = playwright.chromium().launch(
            BrowserType.LaunchOptions().setHeadless(false)
        )
        
        // 3. 새 페이지 열기 및 이동
        val page = browser.newPage()
        page.navigate("https://www.google.com")
        
        // 4. 검색창에 입력 및 엔터
        page.fill("textarea[name='q']", "Kotlin Playwright")
        page.press("textarea[name='q']", "Enter")
        
        // 5. 스크린샷 찍기
        page.screenshot(Page.ScreenshotOptions().setPath(java.nio.file.Paths.get("example.png")))
        
        println("테스트 완료: 제목은 ${page.title()}")
        // ... 코드 마지막 부분 (use 블록이 끝나기 전)
        println("브라우저를 확인하세요. 10초 후 종료됩니다.")
        Thread.sleep(10000) // 10초 동안 멈춤

    }
}