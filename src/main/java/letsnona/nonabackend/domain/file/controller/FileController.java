package letsnona.nonabackend.domain.file.controller;

import letsnona.nonabackend.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final ProductService productService;

    @GetMapping("/images")
    ResponseEntity<byte[]> showImage(@RequestParam("img_path") String filePath) throws IOException {
        String decodeFilePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);
        System.out.println("decodeFilePath = " + decodeFilePath);
        return productService.getRespIMG(decodeFilePath);
    }


}
