package in.siddheshnawale.ghibliapi.service;

import in.siddheshnawale.ghibliapi.client.StabilityAIClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GhibliArtService {

    private final StabilityAIClient stabilityAIClient;
    private final String apiKey;

    public GhibliArtService (StabilityAIClient stabilityAIClient ,@Value("${stability.api.key}") String apiKey){
        this.stabilityAIClient = stabilityAIClient ;
        this.apiKey = apiKey ;
    }

    public byte[] createGhibliArt(MultipartFile image, String prompt){
        String finalPrompt = prompt+ ", in the beautiful, detailed anime style of studio Ghibli" ;
        String engineId = "stable-diffusion-v1-6" ;
        String stylePreset = "anime" ;
        return new byte[0];   //this line is not in youtube vidio
    }

}
