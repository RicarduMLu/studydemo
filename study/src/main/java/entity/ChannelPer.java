package entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelPer {
    private String goodsCode;
    private String ownerOrgCode;
    private String permissionId;
}
