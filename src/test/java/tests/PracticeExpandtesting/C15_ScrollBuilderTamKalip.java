package tests.PracticeExpandtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class C15_ScrollBuilderTamKalip {
    private WebElement element;
    private int offsetY = 0;
    private int speed = 500; // Varsayılan hız: 500 ms
    private int maxRetries = 0;
    private boolean screenshotOnFail = false;

    // Yapıcı metot
    public C15_ScrollBuilderTamKalip(WebElement element) {
        this.element = element;
    }

    // Builder metodları
    public C15_ScrollBuilderTamKalip withOffset(int y) {
        this.offsetY = y;
        return this;
    }

    public C15_ScrollBuilderTamKalip withSpeed(int milliseconds) {
        if (milliseconds < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speed = milliseconds;
        return this;
    }

    public C15_ScrollBuilderTamKalip withRetry(int retryCount) {
        if (retryCount < 0) {
            throw new IllegalArgumentException("Retry count cannot be negative");
        }
        this.maxRetries = retryCount;
        return this;
    }

    public C15_ScrollBuilderTamKalip withScreenshotOnFail() {
        this.screenshotOnFail = true;
        return this;
    }

    public void execute() {
        int attempts = 0;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        while (attempts <= maxRetries) {
            try {
                // Öğenin ekranın görünür alanında olup olmadığını kontrol et
                boolean isElementInView = (Boolean) js.executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2, " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "return e === elem;",
                        element
                );

                if (isElementInView) {
                    return; // Öğe zaten görünür, kaydırmaya gerek yok
                }

                // Kaydırma işlemi için JavaScript
                String script = "arguments[0].scrollIntoView({"
                        + "behavior: 'smooth'," // Animasyonlu kaydırma
                        + "block: 'center',"
                        + "inline: 'center'"
                        + "});"
                        + (offsetY != 0 ? "window.scrollBy(0, " + offsetY + ");" : "")
                        + (speed > 0 ? "await new Promise(resolve => setTimeout(resolve, " + speed + "));" : "");

                js.executeScript(script, element);

                // Kaydırmadan sonra öğenin görünür olduğunu kontrol et
                isElementInView = (Boolean) js.executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2, " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "return e === elem;",
                        element
                );

                if (isElementInView) {
                    return; // Başarılı, döngüden çık
                } else {
                    throw new RuntimeException("Element is not in view after scrolling");
                }
            } catch (Exception e) {
                attempts++;
                if (screenshotOnFail && attempts <= maxRetries) {
                    takeScreenshot();
                }
                if (attempts > maxRetries) {
                    throw new RuntimeException("Failed to scroll to element after " + maxRetries + " retries", e);
                }
                try {
                    Thread.sleep(500); // Tekrar denemeden önce kısa bir bekleme
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void takeScreenshot() {
        // Ekran görüntüsü alma mantığı (örnek olarak boş bırakıldı)
        // Gerçek uygulamada buraya ekran görüntüsü alma kodu eklenmeli
        // Örneğin:
        /*
        try {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot, new File("screenshots/error_" + System.currentTimeMillis() + ".png"));
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
        */
        System.out.println("Screenshot taken (placeholder)");
    }
}