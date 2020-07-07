package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SpecsIntroductionVO {
    @JsonProperty("id")
    Integer specsId;
    @JsonProperty("name")
    String specsName;
    @JsonProperty("imgUrl")
    String specsIcon;
    @JsonProperty("previewImgUrl")
    String specsPreview;

}
