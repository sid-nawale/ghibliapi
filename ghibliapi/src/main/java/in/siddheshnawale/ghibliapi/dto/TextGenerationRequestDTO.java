package in.siddheshnawale.ghibliapi.dto;

import lombok.Data;

@Data
public class TextGenerationRequestDTO {
    private String prompt;
    private String style;
}
