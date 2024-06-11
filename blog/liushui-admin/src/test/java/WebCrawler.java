/**
 * @description:
 * @className:
 * @author: liuShun
 * @create: 2024/5/20 16:44
 * <p>
 * 接下来，我们将编写一个简单的Java爬虫代码，用于抓取网页标题：
 */
//```java

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebCrawler {

    public static void main(String[] args) {
        String url = "https://www.baidu.com"; // 需要爬取的网址
        String[] urls = {"https://www.1688.com", "https://www.taobao.com",
                "https://www.163.com", "https://www.baidu.com",
                "https://www.sina.com"}; // 需要爬取的网址
        try {
            for (String urlItem : urls) {
                Document document = Jsoup.connect(urlItem).get(); // 获取网页的HTML文档
                String title = document.outerHtml().trim().split("<title>")[1].split("</title>")[0]; // 提取网页标题
                System.out.println("网页标题： " + title);
            }
//                Document document = Jsoup.connect(url).get(); // 获取网页的HTML文档
//                String title = document.title(); // 提取网页标题
//                System.out.println("网页标题： " + title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

