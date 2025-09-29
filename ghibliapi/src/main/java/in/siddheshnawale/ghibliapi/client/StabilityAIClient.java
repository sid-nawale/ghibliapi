package in.siddheshnawale.ghibliapi.client;

import in.siddheshnawale.ghibliapi.dto.TextToImageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
    name = "stabilityAiClient",
    url = "${stability.api.base-url}",
    configuration = in.siddheshnawale.ghibliapi.config.FeignConfig.class
)
public interface StabilityAIClient {

    @PostMapping(
        value = "/v1/generation/{engine_id}/text-to-image",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        headers = {"Accept=image/png"}
    )
    byte[] generateImageFromText(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("engine_id") String engineId,
            @RequestBody TextToImageRequest requestBody
            );
    byte[] generateImageFromImage(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("engine_id") String engineId,
            @RequestPart("init_image")MultipartFile initImage,
            @RequestPart("text_prompts[0][text]") String textPrompt,
            @RequestPart("style_preset") String stylePreset
            );
}
